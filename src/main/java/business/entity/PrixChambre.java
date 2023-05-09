package business.entity;

import java.util.Objects;

public class PrixChambre {

	private static final int PRIX_MAX = 200;
	private double valeur;

	public PrixChambre(double valeur) {
		this.valeur = valeur;
	}

	public double getValeur() {
		return valeur;
	}
	
	public PrixChambre getPrixAugmenteDe(int pourcentage) {
		return new PrixChambre(valeur + (valeur * pourcentage) / 100);
	}

	public PrixChambre getPrixMax() {
		return new PrixChambre(PRIX_MAX);
	}
	
	public boolean estSuperieurAPrixMax() {
		return valeur > PRIX_MAX;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valeur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrixChambre other = (PrixChambre) obj;
		return Double.doubleToLongBits(valeur) == Double.doubleToLongBits(other.valeur);
	}

	@Override
	public String toString() {
		return "PrixChambre [valeur=" + valeur + "]";
	}

}
