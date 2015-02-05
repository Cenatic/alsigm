package ieci.tdw.ispac.ispaclib.search.vo;

import ieci.tdw.ispac.api.item.IItemCollection;

public class SearchResultVO {
	
	public static int NO_LIMITED=-1;
	//Colleci�n con el resultado de la b�squeda
	IItemCollection resultados;
	//N�mero total de registros que satisfacen la b�squeda
	int numTotalRegistros;
	//N�mero m�ximo de registros resultantes de la b�squeda
	int numMaxRegistros=NO_LIMITED;
	
	public SearchResultVO() {
		super();
	}

	public SearchResultVO(IItemCollection resultados, int numTotalRegistros,
			int numMaxRegistros) {
		super();
		this.resultados = resultados;
		this.numTotalRegistros = numTotalRegistros;
		this.numMaxRegistros = numMaxRegistros;
	}

	public IItemCollection getResultados() {
		return resultados;
	}

	public void setResultados(IItemCollection resultados) {
		this.resultados = resultados;
	}

	public int getNumTotalRegistros() {
		return numTotalRegistros;
	}

	public void setNumTotalRegistros(int numTotalRegistros) {
		this.numTotalRegistros = numTotalRegistros;
	}

	public int getNumMaxRegistros() {
		return numMaxRegistros;
	}

	public void setNumMaxRegistros(int numMaxRegistros) {
		this.numMaxRegistros = numMaxRegistros;
	}
	

}
