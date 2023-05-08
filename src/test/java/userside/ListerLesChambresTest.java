package userside;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import core.application.Chambre;
import core.port.serverside.ChambreDao;
import core.port.userside.ChambreService;
import serverside.ChambreStubDao;

public class ListerLesChambresTest {

	@Test
	void ne_retourne_aucun_chambre_si_hotel_sans_chambre() {
		// Given
		ChambreDao chambreDao = new ChambreStubDao(List.of());
		ChambreService sut = new ChambreService(chambreDao);

		// When
		List<Chambre> chambres = sut.recupererChambres();

		// Then
		assertEquals(0, chambres.size());
	}

	@Test
	void retourne_une_chambre_si_hotel_a_une_chambre() {
		// Given
		ChambreDao chambreDao = new ChambreStubDao(List.of(new Chambre(1, 0, 50)));
		ChambreService sut = new ChambreService(chambreDao);

		// When
		List<Chambre> chambres = sut.recupererChambres();

		// Then
		assertEquals(List.of(new Chambre(1, 0, 50)), chambres);
	}
	
	@Test
	void retourne_deux_chambres_si_hotel_a_deux_chambres_rdv_et_1er_etage() {
		// Given
		ChambreDao chambreDao = new ChambreStubDao(List.of(new Chambre(1, 0, 50), new Chambre(101, 1, 53.5)));
		ChambreService sut = new ChambreService(chambreDao);

		// When
		List<Chambre> chambres = sut.recupererChambres();

		// Then
		assertEquals(List.of(new Chambre(1, 0, 50), new Chambre(101, 1, 53.5)), chambres);
	}
	
	@Test
	void retourne_deux_chambres_si_hotel_a_une_chambre_par_etage() {
		// Given
		ChambreDao chambreDao = new ChambreStubDao(List.of(new Chambre(1, 0, 50), new Chambre(101, 1, 53.5)
				, new Chambre(201, 2, 61), new Chambre(301, 3, 66.5)));
		ChambreService sut = new ChambreService(chambreDao);

		// When
		List<Chambre> chambres = sut.recupererChambres();

		// Then
		assertEquals(List.of(new Chambre(1, 0, 50), new Chambre(101, 1, 53.5)
				, new Chambre(201, 2, 61), new Chambre(301, 3, 66.5)), chambres);
	}
}
