package controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.entity.Chambre;
import business.gateway.ChambreDao;
import business.usecase.RecuperationChambre;
import business.usecase.RecuperationChambreUseCase;
import gateway.ChambreStubDao;

public class ListerLesChambresTest {

	@Test
	void ne_retourne_aucun_chambre_si_hotel_sans_chambre() {
		// Given
		ChambreDao chambreDao = new ChambreStubDao(List.of());
		RecuperationChambre sut = new RecuperationChambreUseCase(chambreDao);
		ChambreStringPresenter chambrePresenter = new ChambreStringPresenter();

		// When
		sut.execute(chambrePresenter);

		// Then
		assertEquals("", chambrePresenter.getChaine());
	}

	@Test
	void retourne_une_chambre_si_hotel_a_une_chambre() {
		// Given
		ChambreDao chambreDao = new ChambreStubDao(List.of(new Chambre(1, 0, 50)));
		RecuperationChambre sut = new RecuperationChambreUseCase(chambreDao);
		ChambreStringPresenter chambrePresenter = new ChambreStringPresenter();

		// When
		sut.execute(chambrePresenter);

		// Then
		assertEquals(" etage = 0, num = 1, prix = 50.0", chambrePresenter.getChaine());
	}
	
	@Test
	void retourne_deux_chambres_si_hotel_a_deux_chambres_rdv_et_1er_etage() {
		// Given
		ChambreDao chambreDao = new ChambreStubDao(List.of(new Chambre(1, 0, 50), new Chambre(101, 1, 53.5)));
		RecuperationChambre sut = new RecuperationChambreUseCase(chambreDao);
		ChambreStringPresenter chambrePresenter = new ChambreStringPresenter();

		// When
		sut.execute(chambrePresenter);

		// Then
		assertEquals(" etage = 0, num = 1, prix = 50.0 etage = 1, num = 101, prix = 53.5", chambrePresenter.getChaine());
	}
	
	@Test
	void retourne_deux_chambres_si_hotel_a_une_chambre_par_etage() {
		// Given
		ChambreDao chambreDao = new ChambreStubDao(List.of(new Chambre(1, 0, 50), new Chambre(101, 1, 53.5)
				, new Chambre(201, 2, 61), new Chambre(301, 3, 66.5)));
		RecuperationChambre sut = new RecuperationChambreUseCase(chambreDao);
		ChambreStringPresenter chambrePresenter = new ChambreStringPresenter();

		// When
		sut.execute(chambrePresenter);

		// Then
		assertEquals(" etage = 0, num = 1, prix = 50.0 etage = 1, num = 101, prix = 53.5 etage = 2, num = 201, prix = 61.0 etage = 3, num = 301, prix = 66.5", chambrePresenter.getChaine());
	}
}
