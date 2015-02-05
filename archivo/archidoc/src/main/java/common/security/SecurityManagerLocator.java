package common.security;

/**
 * 1 Sistema 2 Transferencias 3 Pr�stamos y consultas 4 Dep�sito 5 Fondos
 * documentales 6 Descripci�n 7 Gesti�n de usuarios
 */
public class SecurityManagerLocator {

	// public static PrevisionesSecurityManager loockupPrevisionesSM() {
	// return PrevisionesSecurityManager.getInstance();
	// }
	//
	// public static RelacionesSecurityManager lookupRelacionesSM() {
	// return RelacionesSecurityManager.getInstance();
	// }
	public static DepositoSecurityManager loockupDepositoSM() {
		return DepositoSecurityManager.getInstance();
	}

	public static TransferenciasSecurityManager loockupTransferenciasSM() {
		return TransferenciasSecurityManager.getInstance();
	}

	// public static RelacionesSecurityManagerI loockupRelacionesSMI() {
	// return new RelacionesSecurityManagerImpl();
	// }
	//
	public static ServiciosSecurityManager loockupServiciosSM() {
		return ServiciosSecurityManager.getInstance();
	}

	//
	//
	// public static DepositoSecurityManagerI loockupDespositoSMI() {
	// return new DepositoSecurityManagerImpl();
	// }
	//
	// public static CuadroClasificacionSecurityManagerI
	// loockupCuadroClasficacionSMI() {
	// return new CuadroClasificacionManagerImpl();
	// }
	//
	public static FondosSecurityManager lookupFondosSecurityManager() {
		return FondosSecurityManager.getInstance();
	}

	public static DescripcionSecurityManager loockupDescripcionSM() {
		return DescripcionSecurityManager.getInstance();
	}

	public static DocumentosElectronicosSecurityManager loockupDocumentosElectronicosSM() {
		return DocumentosElectronicosSecurityManager.getInstance();
	}

	public static DocumentosVitalesSecurityManager lookupDocumentosVitalesSM() {
		return DocumentosVitalesSecurityManager.getInstance();
	}

	public static AuditoriaSecurityManager loockupAuditoriaSM() {
		return AuditoriaSecurityManager.getInstance();
	}

	public static SecurityManagerBase loockupUsuariosSM() {
		return ControlAccesoSecurityManager.getInstance();
	}

	// public static ValoracionSecurityManager lookupValoracionSM() {
	// return ValoracionSecurityManager.getInstance();
	// }
	// public static EliminacionSecurityManager lookupEliminacionSM() {
	// return EliminacionSecurityManager.getInstance();
	// }

	public static SalasSecurityManager lookupSalasSecurityManager() {
		return SalasSecurityManager.getInstance();
	}

}
