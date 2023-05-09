package controller;

import java.util.List;

import business.entity.dto.ChambreDto;
import business.usecase.presenter.ChambrePresenter;

public class ChambreStringPresenter implements ChambrePresenter {

	private String chaine = "";
	
	@Override
	public void execute(List<ChambreDto> chambres) {
		for (ChambreDto chambreDto : chambres) {
			chaine += " etage = " + chambreDto.getEtage() + ", num = " + chambreDto.getNumero() + ", prix = " + chambreDto.getPrix();
		}
	}

	public String getChaine() {
		return chaine;
	}

}
