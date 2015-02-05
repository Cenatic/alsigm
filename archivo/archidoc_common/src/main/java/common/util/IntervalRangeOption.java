package common.util;

/**
 * Informaci�n de un rango.
 */
public class IntervalRangeOption extends IntervalOption
{

	/** Item m�nimo. */
	private String minItem = null;

	/** Item m�ximo. */
	private String maxItem = null;

	
	/**
	 * Constructor.
	 */
	public IntervalRangeOption()
	{
		super(IntervalOption.ITEM_RANGE);
	}

	
	/**
	 * Constructor.
	 */
	public IntervalRangeOption(String minItem, String maxItem)
	{
		this();
		setMinItem(minItem);
		setMaxItem(maxItem);
	}

	
	/**
	 * Obtiene el �tem m�ximo.
	 * @return Item m�ximo.
	 */
	public String getMaxItem()
	{
		return maxItem;
	}
	
	
	/**
	 * Establece el �tem m�ximo.
	 * @param itemMaxNumber Item m�ximo.
	 */
	public void setMaxItem(String itemMaxNumber)
	{
		this.maxItem = itemMaxNumber;
	}
	
	
	/**
	 * Obtiene el �tem m�nimo.
	 * @return Item m�nimo.
	 */
	public String getMinItem()
	{
		return minItem;
	}
	
	
	/**
	 * Establece el �tem m�nimo.
	 * @param itemMinNumber Item m�nimo.
	 */
	public void setMinItem(String itemMinNumber)
	{
		this.minItem = itemMinNumber;
	}
}
