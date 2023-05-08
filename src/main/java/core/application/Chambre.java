package core.application;

import java.util.Objects;

public class Chambre {

	private int numero;
	private int etage;
	private double prix;

	public Chambre(int numero, int etage, double prix) {
		this.numero = numero;
		this.etage = etage;
		this.prix = prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}

	public int getEtage() {
		return etage;
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