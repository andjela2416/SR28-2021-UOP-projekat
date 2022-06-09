package bibliotekaMain;

import java.util.ArrayList;

import biblioteka.Biblioteka;
import guiProzori.GlavniProzor;
import projekat.ClanBiblioteke;
import projekat.IzdavanjeKnjige;
import projekat.Knjiga;
import projekat.PrimerakKnjige;
import projekat.Tip;
import projekat.Zanr;
import projekat.Zaposleni;



public class BibliotekaMain {

	private static String CLANOVI_FAJL = "clanovi.txt";
	private static String IZNAJMLJIVANJE_FAJL = "izdavanje.txt";
	private static String KNJIGE_FAJL = "Knjiga.txt";
	private static String PRIMERCIKNJIGA_FAJL = "primerciKnjiga.txt";
	private static String TIPOVICLANARINE_FAJL = "tipoviClanarine.txt";
	private static String ZANROVI_FAJL = "zanrovi.txt";
	private static String BIBLIOTEKARI_FAJL= "bibliotekari.txt";
	private static String ADMINISTRATORI_FAJL= "administratori.txt";
	private static String ZAPOSLENI_FAJL= "zaposleni.txt";
	

	public static void main(String[] args) {

		
		Biblioteka biblioteka = new Biblioteka();
		
		GlavniProzor g=new GlavniProzor(biblioteka);
		g.setVisible(true);
		
		biblioteka.ucitajTip(TIPOVICLANARINE_FAJL);
		biblioteka.ucitajClanove(CLANOVI_FAJL);
		biblioteka.ucitajZanrove(ZANROVI_FAJL);
		biblioteka.ucitajKnjige(KNJIGE_FAJL);
		biblioteka.ucitajPrimerkeKnjiga(PRIMERCIKNJIGA_FAJL);
		biblioteka.ucitajIznajmljivanje(IZNAJMLJIVANJE_FAJL);
		biblioteka.ucitajBibliotekare(BIBLIOTEKARI_FAJL);
		biblioteka.ucitajAdministratore(ADMINISTRATORI_FAJL);
		biblioteka.ucitajZaposlene(ZAPOSLENI_FAJL);
		
		System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(biblioteka);
		System.out.println("----------------------------------------------");
		
		
		
		
		
		//System.out.println("Dodavanje test podataka: ");
		
		
		//ClanBiblioteke testClan = new ClanBiblioteke(5,"Marko","Peric","6551546542","test adresa",Pol.MUSKI,"006", LocalDate.of(2022, 02, 19), 24, true, biblioteka.pronadjiTipClanarine(2));
		//biblioteka.dodajClana(testClan);
		
		
		//System.out.println("Snimanje dodanih podataka: ");
		//biblioteka.snimiClanove(CLANOVI_FAJL);
		
		
	
	}
	
	
	
	
	
	/**************************************************************************************************************************/
	
	
	public static void ispisiSvePodatke(Biblioteka biblioteka) {
		
		
	
		
		for(Tip tip : biblioteka.getListaTipova()) {
			System.out.println(tip + "\n");
		}
		
		for(ClanBiblioteke clan : biblioteka.getListaClanova()) {
			System.out.println(clan + "\n");
		}
		
		for(Zanr zanr : biblioteka.getListaZanrova()) {
			System.out.println(zanr + "\n");
		}
		
		for(Knjiga knjiga : biblioteka.getListaKnjiga()) {
			System.out.println(knjiga + "\n");
		}
		
		for(PrimerakKnjige primerci : biblioteka.getListaPrimeraka()) {
			System.out.println(primerci + "\n");
		}
		
		for(IzdavanjeKnjige iznajmljivanje : biblioteka.getListaIzdavanja()) {
			System.out.println(iznajmljivanje + "\n");
		}
		
		for(Zaposleni zaposleni : biblioteka.getListaZaposlenih()) {
			System.out.println(zaposleni + "\n");
		}
	}
	
	
	

    }

