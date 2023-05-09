package controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import business.entity.Chambre;
import business.entity.Hotel;
import business.entity.PrixChambre;
import business.gateway.HotelRepository;
import business.usecase.RecuperationChambre;
import business.usecase.RecuperationChambreUseCase;
import gateway.HotelStubRepository;

public class ListerLesChambresTest {

	@Test
	void ne_retourne_aucun_chambre_si_hotel_sans_chambre() {
		// Given
		HotelRepository chambreDao = new HotelStubRepository(new Hotel(List.of()));
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
		HotelRepository chambreDao = new HotelStubRepository(new Hotel(List.of(new Chambre(1, 0, new PrixChambre(50)))));
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
		HotelRepository chambreDao = new HotelStubRepository(new Hotel(List.of(new Chambre(1, 0,  new PrixChambre(50)), new Chambre(101, 1,  new PrixChambre(53.5)))));
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
		HotelRepository chambreDao = new HotelStubRepository(new Hotel(List.of(new Chambre(1, 0,  new PrixChambre(50)), new Chambre(101, 1,  new PrixChambre(53.5))
				, new Chambre(201, 2,  new PrixChambre(61)), new Chambre(301, 3,  new PrixChambre(66.5)))));
		RecuperationChambre sut = new RecuperationChambreUseCase(chambreDao);
		ChambreStringPresenter chambrePresenter = new ChambreStringPresenter();

		// When
		sut.execute(chambrePresenter);

		// Then
		assertEquals(" etage = 0, num = 1, prix = 50.0 etage = 1, num = 101, prix = 53.5 etage = 2, num = 201, prix = 61.0 etage = 3, num = 301, prix = 66.5", chambrePresenter.getChaine());
	}
}
