package core.port.userside;

import java.util.List;

import core.application.Chambre;
import core.port.serverside.ChambreDao;

public class ChambreService {

	private static final int PRIX_MAX = 200;
	private ChambreDao chambreDao;

	public ChambreService(ChambreDao chambreDao) {
		this.chambreDao = chambreDao;
	}
	
	public List<Chambre> recupererChambres() {
		return chambreDao.recupererChambres();
	}

	public void modifierPrixChambres(double prixChambreRdc) {
		List<Chambre> chambres = chambreDao.recupererChambres();
		for (Chambre chambre : chambres) {
			if (chambre.getEtage() == 1) {
				chambre.setPrix(prixChambreRdc * 1.07);
			} else if (chambre.getEtage() == 2) {
				chambre.setPrix(prixChambreRdc * 1.22);
			} else if (chambre.getEtage() == 3) {
				chambre.setPrix(prixChambreRdc * 1.33);
			} else {
				chambre.setPrix(prixChambreRdc);	
			}
			if (chambre.getPrix() > PRIX_MAX) {
				chambre.setPrix(PRIX_MAX);
			}
		}
		chambreDao.modifierChambres(chambres);
	}
	
}