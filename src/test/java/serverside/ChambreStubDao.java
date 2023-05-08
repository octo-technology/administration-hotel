package serverside;
import java.util.List;

import core.application.Chambre;
import core.port.serverside.ChambreDao;

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