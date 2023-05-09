package business.entity.dto;

import java.util.Objects;

public class ChambreDto {

	private int numero;
	private int etage;
	private double prix;

	public ChambreDto(int numero, int etage, double prix) {
		this.numero = numero;
		this.etage = etage;
		this.prix = prix;
	}

	public int getNumero() {
		return numero;
	}
	
	public int getEtage() {
		return etage;
	}
	
	public double getPrix() {
		return prix;
	}

	@Override
	public int hashCode() {
		return Objects.hash(etage, numero, prix);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChambreDto other = (ChambreDto) obj;
		return etage == other.etage && numero == other.numero
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
	}


}