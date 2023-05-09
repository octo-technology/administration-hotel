package business.usecase;

import business.entity.Hotel;
import business.gateway.HotelRepository;
import business.usecase.presenter.ChambrePresenter;

public class RecuperationChambreUseCase implements RecuperationChambre {

	private HotelRepository hotelRepository;

	public RecuperationChambreUseCase(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	public void execute(ChambrePresenter chambrePresenter) {
		Hotel hotel = hotelRepository.recuperer();
		chambrePresenter.execute(hotel.getChambresDto());
	}

}