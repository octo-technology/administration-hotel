package business.entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import business.entity.dto.ChambreDto;

public class Hotel {

	private List<Chambre> chambres;
	
	public Hotel(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public List<Chambre> getChambres() {
		return chambres;
	}

	public void modifierPrix(double prixChambreRdc) {
		for (Chambre chambre : chambres) {
			chambre.modifierPrix(prixChambreRdc);
		}
	}
	
	public List<ChambreDto> getChambresDto() {
		return chambres.stream().map(c -> c.toChambreDto()).collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(chambres);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(chambres, other.chambres);
	}

	@Override
	public String toString() {
		return "Hotel [chambres=" + chambres + "]";
	}
}
