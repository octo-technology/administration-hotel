package business.usecase;

import java.util.List;

import business.entity.Chambre;
import business.gateway.ChambreDao;

public class RecuperationChambreUseCase implements RecuperationChambre {

	private ChambreDao chambreDao;

	public RecuperationChambreUseCase(ChambreDao chambreDao) {
		this.chambreDao = chambreDao;
	}
	
	public List<Chambre> execute() {
		return chambreDao.recupererChambres();
	}

}