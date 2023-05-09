package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import business.entity.Chambre;
import business.entity.Hotel;
import business.entity.PrixChambre;
import business.usecase.ModifierPrixChambres;
import business.usecase.ModifierPrixChambresUseCase;
import gateway.HotelSpyRepository;

public class ModifierPrixChambreTest {

	@Test
	void le_prix_chambres_rdc_est_de_100euros_si_fixe_prix_chambre_rdc_a_100euros() {
		// Given
		HotelSpyRepository hotelSpyDao = new HotelSpyRepository(new Hotel(List.of(new Chambre(1, 0, new PrixChambre(50)))));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(hotelSpyDao);

		// When
		sut.execute(100);

		// Then
		assertEquals(new Hotel(List.of(new Chambre(1, 0, new PrixChambre(100)))), hotelSpyDao.getHotelMdifie());
	}
	
	@Test
	void le_prix_chambres_1er_etage_est_de_107euros_si_fixe_prix_chambre_rdc_a_100euros_car_7_pourcents_du_prix() {
		// Given
		HotelSpyRepository hotelSpyDao = new HotelSpyRepository(new Hotel(List.of(new Chambre(101, 1, new PrixChambre(50)))));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(hotelSpyDao);

		// When
		sut.execute(100);

		// Then
		assertEquals(new Hotel(List.of(new Chambre(101, 1, new PrixChambre(107)))), hotelSpyDao.getHotelMdifie());
	}
	
	@Test
	void le_prix_chambres_2e_etage_est_de_122euros_si_fixe_prix_chambre_rdc_a_100euros_car_22_pourcents_du_prix() {
		// Given
		HotelSpyRepository hotelSpyDao = new HotelSpyRepository(new Hotel(List.of(new Chambre(201, 2, new PrixChambre(50)))));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(hotelSpyDao);

		// When
		sut.execute(100);

		// Then
		assertEquals(new Hotel(List.of(new Chambre(201, 2, new PrixChambre(122)))), hotelSpyDao.getHotelMdifie());
	}
	
	@Test
	void le_prix_chambres_2e_etage_est_de_133euros_si_fixe_prix_chambre_rdc_a_100euros_car_33_pourcents_du_prix() {
		// Given
		HotelSpyRepository hotelSpyDao = new HotelSpyRepository(new Hotel(List.of(new Chambre(301, 3, new PrixChambre(50)))));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(hotelSpyDao);

		// When
		sut.execute(100);

		// Then
		assertEquals(new Hotel(List.of(new Chambre(301, 3, new PrixChambre(133)))), hotelSpyDao.getHotelMdifie());
	}
	
	@Test
	void le_prix_chambres_2e_etage_est_de_200euros_si_fixe_prix_chambre_rdc_a_180euros_car_plafonne_a_200euros() {
		// Given
		HotelSpyRepository hotelSpyDao = new HotelSpyRepository(new Hotel(List.of(new Chambre(1, 0, new PrixChambre(50)), new Chambre(301, 3, new PrixChambre(60)))));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(hotelSpyDao);

		// When
		sut.execute(180);

		// Then
		assertEquals(new Hotel(List.of(new Chambre(1, 0, new PrixChambre(180)), new Chambre(301, 3, new PrixChambre(200)))), hotelSpyDao.getHotelMdifie());
	}
}