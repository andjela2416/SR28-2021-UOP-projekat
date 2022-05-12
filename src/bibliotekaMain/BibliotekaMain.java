package bibliotekaMain;

import java.time.LocalDate;
import java.util.ArrayList;

import biblioteka.Biblioteka;
import projekat.ClanBiblioteke;
import projekat.Pol;
import projekat.Tip;

public class BibliotekaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ClanBiblioteke clan = new ClanBiblioteke("002","Milorad","Djurica","1231231231","Bulevar",Pol.valueOf("MUSKI"),"877",LocalDate.now(),10,true,);
        ArrayList<ClanBiblioteke> clanovi = new ArrayList<ClanBiblioteke>();
        clanovi.add(clan);
        Biblioteka.ucitajClanove(clanovi);
        Biblioteka.snimiClanove();
        
        Tip tipClanarine = new Tip("002321","Decija",150.00);
        ArrayList<Tip> tipClan = new ArrayList<Tip>();
        tipClan.add(tipClanarine);
        Biblioteka.nadjiTip(tipClan);
        Biblioteka.snimiTipClanarine();
	}
	
}
