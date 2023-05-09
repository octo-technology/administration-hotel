package gateway;
import java.util.List;

import business.entity.Chambre;
import business.gateway.ChambreDao;

public class ChambreSpyDao implements ChambreDao {

	private List<Chambre> chambres;
	private List<Chambre> chambresModifiees;

	public ChambreSpyDao(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	@Override
	public List<Chambre> recupererChambres() {
		return chambres;
	}

	@Override
	public void modifierChambres(List<Chambre> chambres) {
		this.chambresModifiees = chambres;
		
	}

	public List<Chambre> getListeChambresModifiees() {
		return chambresModifiees;
	}
}