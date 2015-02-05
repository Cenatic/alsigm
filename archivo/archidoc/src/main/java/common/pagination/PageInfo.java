package common.pagination;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.displaytag.properties.SortOrderEnum;

import xml.config.ConfiguracionSistemaArchivoFactory;

import common.util.ArrayUtils;
import common.util.StringUtils;
import common.util.TypeConverter;

/**
 * Informaci�n de una p�gina del listado.
 */
public class PageInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** N�mero de p�gina. */
	private int pageNumber;

	/** N�mero de registros por p�gina. */
	private int objectsPerPage;

	/** Criterio de ordenaci�n. */
	private String sortCriterion;

	/** Direcci�n de ordenaci�n. */
	private SortOrderEnum sortDirection;

	/** N�mero m�ximo de resultados. */
	private int maxNumItems = -1;

	/** Flag que indica que se est� exportando el listado. */
	private boolean exportingList = false;

	private static final int DEFAULT_PAGE_NUMBER = 1; // p�gina 1
	private static final int DEFAULT_OBJECTS_PER_PAGE = 15; // 15 regs./p�g.
	private static final String[] SORT_ORDER_STRINGS = { "", " DESC", " ASC" };

	/**
	 * Constructor.
	 */
	public PageInfo(HttpServletRequest request, String defaultSortCriterion) {
		this(request, DEFAULT_OBJECTS_PER_PAGE, defaultSortCriterion,
				SortOrderEnum.ASCENDING);
	}

	/**
	 * Constructor.
	 */
	public PageInfo(HttpServletRequest request, int objectsPerPage,
			String sortCriterion) {
		this(request, objectsPerPage, sortCriterion, SortOrderEnum.ASCENDING);
	}

	/**
	 * Constructor.
	 */
	public PageInfo(HttpServletRequest request, String sortCriterion,
			SortOrderEnum sortDirection) {
		this(request, DEFAULT_OBJECTS_PER_PAGE, sortCriterion, sortDirection);
	}

	/**
	 * Constructor.
	 */
	public PageInfo(HttpServletRequest request, int objectsPerPage,
			String sortCriterion, SortOrderEnum sortDirection) {
		// Comprobar si es una exportaci�n de datos
		setExportingList(checkExportingList(request));

		if (exportingList) // Obtener todos los resultados
		{
			// Primera p�gina
			setPageNumber(DEFAULT_PAGE_NUMBER);

			// Todos los resultados
			setObjectsPerPage(Integer.MAX_VALUE);
		} else // Obtener solo los resultados de la p�gina actual
		{
			// N�mero de p�gina
			setPageNumber(TypeConverter.toInt(request.getParameter("page"),
					DEFAULT_PAGE_NUMBER));

			// N�mero de registros por p�gina
			setObjectsPerPage(objectsPerPage);
		}

		// Criterio de ordenaci�n
		String _sortCriterion = request.getParameter("sort");
		if (StringUtils.isNotBlank(_sortCriterion))
			setSortCriterion(_sortCriterion);
		else
			setSortCriterion(sortCriterion);

		// Direcci�n de ordenaci�n
		String _sortDirection = request.getParameter("dir");
		if (StringUtils.isNotBlank(_sortDirection))
			setSortDirection(SortOrderEnum.fromName(_sortDirection));
		else
			setSortDirection(sortDirection);
	}

	public static boolean checkExportingList(HttpServletRequest request) {
		boolean isExport = false;
		Enumeration parameterNames = request.getParameterNames();
		String parameterName;
		while (parameterNames.hasMoreElements() && !isExport) {
			parameterName = (String) parameterNames.nextElement();
			if (parameterName.startsWith("d-") && parameterName.endsWith("-e"))
				isExport = true;
		}
		return isExport;
	}

	/**
	 * @return Returns the pageNumber.
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            The pageNumber to set.
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return Returns the recordsNumber.
	 */
	public int getObjectsPerPage() {
		return objectsPerPage;
	}

	/**
	 * @param recordsNumber
	 *            The recordsNumber to set.
	 */
	public void setObjectsPerPage(int recordsNumber) {
		this.objectsPerPage = recordsNumber;
	}

	/**
	 * @return Returns the maxNumResults.
	 */
	public int getMaxNumItems() {
		return maxNumItems;
	}

	/**
	 * @param maxNumResults
	 *            The maxNumResults to set.
	 */
	public void setMaxNumItems(int maxNumResults) {
		this.maxNumItems = maxNumResults;
	}

	/**
	 * @return Returns the sortCriterion.
	 */
	public String getSortCriterion() {
		return sortCriterion;
	}

	/**
	 * @param sortCriterion
	 *            The sortCriterion to set.
	 */
	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	/**
	 * @return Returns the sortDirection.
	 */
	public SortOrderEnum getSortDirection() {
		return sortDirection;
	}

	/**
	 * @param sortDirection
	 *            The sortDirection to set.
	 */
	public void setSortDirection(SortOrderEnum sortDirection) {
		this.sortDirection = sortDirection;
	}

	/**
	 * @return Returns the exportingList.
	 */
	public boolean isExportingList() {
		return exportingList;
	}

	/**
	 * @param exportingList
	 *            The exportingList to set.
	 */
	public void setExportingList(boolean exportingList) {
		this.exportingList = exportingList;
	}

	/**
	 * Obtiene el literal SQL del tipo de ordenaci�n.
	 * 
	 * @return Literal SQL.
	 */
	public String getSortOrderString() {
		if (sortDirection != null)
			return SORT_ORDER_STRINGS[sortDirection.getCode()];
		else
			return SORT_ORDER_STRINGS[0];
	}

	/**
	 * Obtiene la sentencia SQL de ordenaci�n (ORDER BY).
	 * 
	 * @param sortCriteria
	 *            Lista de criterios de ordenaci�n.
	 * @return Sentencia SQL de ordenaci�n.
	 */
	public String getOrderBy(Map sortCriteria) {
		StringBuffer sql = new StringBuffer();

		if ((sortCriteria != null) && StringUtils.isNotBlank(sortCriterion)) {
			Object columnDefs = sortCriteria.get(sortCriterion);
			if (columnDefs != null) {
				if (columnDefs instanceof Object[]) {
					Object[] defs = (Object[]) columnDefs;
					if (!ArrayUtils.isEmpty(defs)) {
						sql.append(" ORDER BY ");

						for (int i = 0; i < defs.length; i++) {
							if (i > 0)
								sql.append(",");

							sql.append(defs[i].toString()).append(
									getSortOrderString());
						}
					}
				} else // if (columnDefs instanceof String)
				{
					sql.append(" ORDER BY ").append(columnDefs.toString())
							.append(getSortOrderString());
				}
			}
		}

		return sql.toString();
	}

	/**
	 * Obtiene el n�mero de registro inicial.
	 * 
	 * @return N�mero de registro inicial.
	 */
	public int getInitialRecordNumber() {
		return (pageNumber - 1) * objectsPerPage;
	}

	/**
	 * Establece el n�mero m�ximo de resultados de la consulta por defecto.
	 */
	public void setDefautMaxNumItems() {
		setMaxNumItems(ConfiguracionSistemaArchivoFactory
				.getConfiguracionSistemaArchivo().getConfiguracionGeneral()
				.getNumMaxResultados());
	}
}
