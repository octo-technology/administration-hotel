package gateway;
import business.entity.Hotel;
import business.gateway.HotelRepository;

public class HotelStubRepository implements HotelRepository {

	private Hotel hotel;

	public HotelStubRepository(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public Hotel recuperer() {
		return hotel;
	}

	@Override
	public void modifier(Hotel hotel) {
	}

}