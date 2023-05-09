package business.entity;

import java.util.Objects;

public class Chambre {

	private static final int PRIX_MAX = 200;

	private int numero;
	private int etage;
	private double prix;

	public Chambre(int numero, int etage, double prix) {
		this.numero = numero;
		this.etage = etage;
		this.prix = prix;
	}

	public void modifierPrix(double prixChambreRdc) {
		if (etage == 1) {
			prix = prixChambreRdc * 1.07;
		} else if (etage == 2) {
			prix = prixChambreRdc * 1.22;
		} else if (etage == 3) {
			prix = prixChambreRdc * 1.33;
		} else {
			prix = prixChambreRdc;	
		}
		if (prix > PRIX_MAX) {
			prix = PRIX_MAX;
		}
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
		Chambre other = (Chambre) obj;
		return etage == other.etage && numero == other.numero && prix == other.prix;
	}

	@Override
	public String toString() {
		return "Chambre [numero=" + numero + ", etage=" + etage + ", prix=" + prix + "]";
	}



}