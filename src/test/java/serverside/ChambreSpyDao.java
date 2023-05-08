package serverside;
import java.util.List;

import core.application.Chambre;
import core.port.serverside.ChambreDao;

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