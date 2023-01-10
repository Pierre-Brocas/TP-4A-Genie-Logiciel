package tests;

import static org.junit.Assert.*;
import myPackage.Compte;

import org.junit.Test;

public class TestCompte {

    @Test  
	public void test_Nouveau_Compte() 
	{
		Compte c = new Compte();
		assertEquals(0,c.getSolde(),0);
	}

    @Test  
	public void test_methodes_Compte() 
	{
		Compte c = new Compte();
		c.setSolde(100);
		assertEquals(100,c.getSolde(),0);
	}
}
