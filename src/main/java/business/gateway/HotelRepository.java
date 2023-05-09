package business.gateway;

import business.entity.Hotel;

public interface HotelRepository {

	Hotel recuperer();

	void modifier(Hotel hotel);
}
