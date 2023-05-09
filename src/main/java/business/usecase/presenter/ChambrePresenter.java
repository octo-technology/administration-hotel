package business.usecase.presenter;

import java.util.List;

import business.entity.dto.ChambreDto;

public interface ChambrePresenter {

	public void execute(List<ChambreDto> chambres);
}
