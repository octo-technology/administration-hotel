package business.usecase;

import business.entity.Hotel;
import business.gateway.HotelRepository;

public class ModifierPrixChambresUseCase implements ModifierPrixChambres {

	private HotelRepository hotelRepository;

	public ModifierPrixChambresUseCase(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	public void execute(double prixChambreRdc) {
		Hotel hotel = hotelRepository.recuperer();
		hotel.modifierPrix(prixChambreRdc);
		hotelRepository.modifier(hotel);
	}
}
