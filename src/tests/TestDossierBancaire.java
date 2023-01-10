package tests;

import static org.junit.Assert.*;
import myPackage.DossierBancaire;

import org.junit.Test;

//The Test annotation indicates that the public void method to which it is attached can be run as a test case.
public class TestDossierBancaire {

	@Test  
	public void test_constructeur() 
	{
		DossierBancaire dossier=new DossierBancaire();
		assertEquals(0,dossier.get_solde(),0);
	}

	@Test  
	public void test_SET_GET() 
	{
		DossierBancaire dossier=new DossierBancaire();
		dossier.deposer(100);
		assertEquals(100,dossier.get_solde(),0); 
	}

	@Test
	public void test_remunerer() 
	{
		DossierBancaire dossier=new DossierBancaire();
		dossier.deposer(100);
		dossier.remunerer();
		assertEquals(100*0.6*0.032+100,dossier.get_solde(),0); 

	}

}
