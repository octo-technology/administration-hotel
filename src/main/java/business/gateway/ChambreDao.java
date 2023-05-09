package business.gateway;

import java.util.List;

import business.entity.Chambre;

public interface ChambreDao {

	List<Chambre> recupererChambres();

	void modifierChambres(List<Chambre> chambres);
}
