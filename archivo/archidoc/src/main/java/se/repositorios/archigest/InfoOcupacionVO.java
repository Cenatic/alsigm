package se.repositorios.archigest;

import java.io.Serializable;

/**
 * Informaci�n de ocupaci�n de un repositorio electr�nico.
 */
public class InfoOcupacionVO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long m_espacioOcupado;
	private Long m_espacioTotal;
	private Long m_numeroFicheros;

	public InfoOcupacionVO() {
	}

	public InfoOcupacionVO(Long _espacioOcupado, Long _espacioTotal,
			Long _numeroFicheros) {
		m_espacioOcupado = _espacioOcupado;
		m_espacioTotal = _espacioTotal;
		m_numeroFicheros = _numeroFicheros;
	}

	public Long getEspacioOcupado() {
		return m_espacioOcupado;
	}

	public void setEspacioOcupado(Long _espacioOcupado) {
		m_espacioOcupado = _espacioOcupado;
	}

	public Long getEspacioTotal() {
		return m_espacioTotal;
	}

	public void setEspacioTotal(Long _espacioTotal) {
		m_espacioTotal = _espacioTotal;
	}

	public Long getNumeroFicheros() {
		return m_numeroFicheros;
	}

	public void setNumeroFicheros(Long _numeroFicheros) {
		m_numeroFicheros = _numeroFicheros;
	}
}
