package myPackage;

public class DossierBancaire {
	private Compte CompteCourant;
    private Compte CompteEpargne;

	//Constructeur
    public DossierBancaire()
    {
    	CompteCourant = new Compte();
        CompteEpargne = new Compte();
    }

    public void deposer(double value) {
        CompteEpargne.setSolde(0.6*value);
        CompteCourant.setSolde(0.4*value);
    }
    public double get_solde() {
        return CompteCourant.getSolde()+CompteEpargne.getSolde();
    }
    public void remunerer() {
        CompteEpargne.setSolde(CompteEpargne.getSolde()*0.032);
    }

    public void retirer(double value){
        CompteCourant.setSolde(-value);
    }
	
}
