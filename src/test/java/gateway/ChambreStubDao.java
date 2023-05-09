package gateway;
import java.util.List;

import business.entity.Chambre;
import business.gateway.ChambreDao;

public class ChambreStubDao implements ChambreDao {

	private List<Chambre> chambres;

	public ChambreStubDao(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	@Override
	public List<Chambre> recupererChambres() {
		return chambres;
	}

	@Override
	public void modifierChambres(List<Chambre> chambres) {
	}

}