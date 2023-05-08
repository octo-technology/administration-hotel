package service;

import java.util.List;

import dao.Chambre;
import dao.ChambreDao;

public class ChambreService {

	private ChambreDao chambreDao;

	public ChambreService(ChambreDao chambreDao) {
		this.chambreDao = chambreDao;
	}
	
	public List<Chambre> recupererChambres() {
		return chambreDao.recupererChambres();
	}
	
}