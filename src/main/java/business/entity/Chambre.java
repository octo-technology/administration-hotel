package business.entity;

import java.util.Objects;

import business.entity.dto.ChambreDto;

public class Chambre {

	private int numero;
	private int etage;
	private PrixChambre prix;

	public Chambre(int numero, int etage, PrixChambre prix) {
		this.numero = numero;
		this.etage = etage;
		this.prix = prix;
	}

	public void modifierPrix(double prixChambreRdc) {
		prix = new PrixChambre(prixChambreRdc);
		if (etage == 1) {
			prix = prix.getPrixAugmenteDe(7);
		} else if (etage == 2) {
			prix =  prix.getPrixAugmenteDe(22);
		} else if (etage == 3) {
			prix = prix.getPrixAugmenteDe(33);
		}
		if (prix.estSuperieurAPrixMax()) {
			prix = prix.getPrixMax();
		}
	}
	
	public ChambreDto toChambreDto() {
		return new ChambreDto(numero, etage, prix.getValeur());
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
		return etage == other.etage && numero == other.numero && Objects.equals(prix, other.prix);
	}

	@Override
	public String toString() {
		return "Chambre [numero=" + numero + ", etage=" + etage + ", prix=" + prix + "]";
	}

}