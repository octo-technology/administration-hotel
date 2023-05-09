package business.usecase;

import java.util.List;

import business.entity.Chambre;
import business.gateway.ChambreDao;

public class ModifierPrixChambresUseCase implements ModifierPrixChambres {

	private ChambreDao chambreDao;

	public ModifierPrixChambresUseCase(ChambreDao chambreDao) {
		this.chambreDao = chambreDao;
	}

	public void execute(double prixChambreRdc) {
		List<Chambre> chambres = chambreDao.recupererChambres();
		for (Chambre chambre : chambres) {
			chambre.modifierPrix(prixChambreRdc);
		}
		chambreDao.modifierChambres(chambres);
	}
}
