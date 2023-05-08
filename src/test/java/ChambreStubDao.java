import java.util.List;

import dao.Chambre;
import dao.ChambreDao;

public class ChambreStubDao implements ChambreDao {

	private List<Chambre> chambres;

	public ChambreStubDao(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	@Override
	public List<Chambre> recupererChambres() {
		return chambres;
	}

}