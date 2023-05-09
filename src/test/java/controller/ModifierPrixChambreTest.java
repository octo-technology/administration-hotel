package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import business.entity.Chambre;
import business.usecase.ModifierPrixChambres;
import business.usecase.ModifierPrixChambresUseCase;
import gateway.ChambreSpyDao;

public class ModifierPrixChambreTest {

	@Test
	void le_prix_chambres_rdc_est_de_100euros_si_fixe_prix_chambre_rdc_a_100euros() {
		// Given
		ChambreSpyDao chambreSpyDao = new ChambreSpyDao(List.of(new Chambre(1, 0, 50)));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(chambreSpyDao);

		// When
		sut.execute(100);

		// Then
		assertEquals(List.of(new Chambre(1, 0, 100)), chambreSpyDao.getListeChambresModifiees());
	}
	
	@Test
	void le_prix_chambres_1er_etage_est_de_107euros_si_fixe_prix_chambre_rdc_a_100euros_car_7_pourcents_du_prix() {
		// Given
		ChambreSpyDao chambreSpyDao = new ChambreSpyDao(List.of(new Chambre(101, 1, 50)));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(chambreSpyDao);

		// When
		sut.execute(100);

		// Then
		assertEquals(List.of(new Chambre(101, 1, 107)), chambreSpyDao.getListeChambresModifiees());
	}
	
	@Test
	void le_prix_chambres_2e_etage_est_de_122euros_si_fixe_prix_chambre_rdc_a_100euros_car_22_pourcents_du_prix() {
		// Given
		ChambreSpyDao chambreSpyDao = new ChambreSpyDao(List.of(new Chambre(201, 2, 50)));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(chambreSpyDao);

		// When
		sut.execute(100);

		// Then
		assertEquals(List.of(new Chambre(201, 2, 122)), chambreSpyDao.getListeChambresModifiees());
	}
	
	@Test
	void le_prix_chambres_2e_etage_est_de_133euros_si_fixe_prix_chambre_rdc_a_100euros_car_33_pourcents_du_prix() {
		// Given
		ChambreSpyDao chambreSpyDao = new ChambreSpyDao(List.of(new Chambre(301, 3, 50)));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(chambreSpyDao);

		// When
		sut.execute(100);

		// Then
		assertEquals(List.of(new Chambre(301, 3, 133)), chambreSpyDao.getListeChambresModifiees());
	}
	
	@Test
	void le_prix_chambres_2e_etage_est_de_200euros_si_fixe_prix_chambre_rdc_a_180euros_car_plafonne_a_200euros() {
		// Given
		ChambreSpyDao chambreSpyDao = new ChambreSpyDao(List.of(new Chambre(1, 0, 50), new Chambre(301, 3, 60)));
		ModifierPrixChambres sut = new ModifierPrixChambresUseCase(chambreSpyDao);

		// When
		sut.execute(180);

		// Then
		assertEquals(List.of(new Chambre(1, 0, 180), new Chambre(301, 3, 200)), chambreSpyDao.getListeChambresModifiees());
	}
}