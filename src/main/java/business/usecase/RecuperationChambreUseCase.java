package business.usecase;

import java.util.List;
import java.util.stream.Collectors;

import business.entity.Chambre;
import business.entity.dto.ChambreDto;
import business.gateway.ChambreDao;
import business.usecase.presenter.ChambrePresenter;

public class RecuperationChambreUseCase implements RecuperationChambre {

	private ChambreDao chambreDao;

	public RecuperationChambreUseCase(ChambreDao chambreDao) {
		this.chambreDao = chambreDao;
	}
	
	public void execute(ChambrePresenter chambrePresenter) {
		List<Chambre> chambres = chambreDao.recupererChambres();
		List<ChambreDto> chambresDto = chambres.stream().map(c -> c.toChambreDto()).collect(Collectors.toList());
		chambrePresenter.execute(chambresDto);
	}

}