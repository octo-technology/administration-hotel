package gateway;
import business.entity.Hotel;
import business.gateway.HotelRepository;

public class HotelSpyRepository implements HotelRepository {

	private Hotel hotel;
	private Hotel hotelModifie;

	public HotelSpyRepository(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public Hotel recuperer() {
		return hotel;
	}

	@Override
	public void modifier(Hotel hotel) {
		hotelModifie = hotel;
	}

	public Hotel getHotelMdifie() {
		return hotelModifie;
	}
}