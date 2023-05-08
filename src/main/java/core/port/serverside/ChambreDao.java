package core.port.serverside;

import java.util.List;

import core.application.Chambre;

public interface ChambreDao {

	List<Chambre> recupererChambres();

	void modifierChambres(List<Chambre> chambres);
}
