package Model;

import java.util.List;

public class Panier {
	private List<LignePanier> LignesPanier ;

	public Panier(List<LignePanier> lignesPanier) {
		super();
		LignesPanier = lignesPanier;
	}

	public List<LignePanier> getLignesPanier() {
		return LignesPanier;
	}

	public void setLignesPanier(List<LignePanier> lignesPanier) {
		LignesPanier = lignesPanier;
	}
	
	
}
