package myPackage;

public class Compte {
    // Attribut
    private double _solde;

    // Contructeur
    public Compte(){
        _solde=0;
    }

    // Méthodes
    public void setSolde(double value){
        _solde += value;
    }
    public double getSolde(){
        return _solde;
    }
}


