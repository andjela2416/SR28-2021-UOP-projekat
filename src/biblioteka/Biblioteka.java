package biblioteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import projekat.Administrator;
import projekat.Bibliotekar;
import projekat.ClanBiblioteke;
import projekat.IzdavanjeKnjige;
import projekat.Knjiga;
import projekat.Pol;
import projekat.PrimerakKnjige;
import projekat.Tip;
import projekat.Zanr;
import projekat.Zaposleni;

public class Biblioteka {

    protected String naziv;
    protected String adresa;
    protected String telefon;
    protected String radnoVreme;
    protected ArrayList<IzdavanjeKnjige> listaIzdavanja;
    protected ArrayList<PrimerakKnjige> listaPrimeraka;
    protected ArrayList<Knjiga> listaKnjiga;
    protected ArrayList<Zanr> listaZanrova;
    protected ArrayList<ClanBiblioteke> listaClanova;
    protected ArrayList<Tip> listaTipova;
    protected ArrayList<Administrator> listaAdministratora;
    protected ArrayList<Bibliotekar> listaBibliotekara;
    
    

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}





	public Biblioteka(String naziv, String adresa, String telefon, String radnoVreme,
			ArrayList<IzdavanjeKnjige> listaIzdavanja, ArrayList<PrimerakKnjige> listaPrimeraka,
			ArrayList<Knjiga> listaKnjiga, ArrayList<Zanr> listaZanrova, ArrayList<ClanBiblioteke> listaClanova,
			ArrayList<Tip> listaTipova, ArrayList<Administrator> listaAdministratora,
			ArrayList<Bibliotekar> listaBibliotekara) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.listaIzdavanja = listaIzdavanja;
		this.listaPrimeraka = listaPrimeraka;
		this.listaKnjiga = listaKnjiga;
		this.listaZanrova = listaZanrova;
		this.listaClanova = listaClanova;
		this.listaTipova = listaTipova;
		this.listaAdministratora = listaAdministratora;
		this.listaBibliotekara = listaBibliotekara;
	}

	public Biblioteka() {
		super();
		this.naziv = "";
		this.adresa = "";
		this.telefon ="";
		this.radnoVreme = "";
		this.listaClanova = new ArrayList<ClanBiblioteke> ();
		this.listaTipova = new ArrayList<Tip> ();
		this.listaZanrova = new ArrayList<Zanr> ();
		this.listaKnjiga = new ArrayList<Knjiga> ();
		this.listaPrimeraka = new ArrayList<PrimerakKnjige> ();
		this.listaIzdavanja = new ArrayList<IzdavanjeKnjige> ();
		this.listaAdministratora = new ArrayList<Administrator> ();
		this.listaBibliotekara = new ArrayList<Bibliotekar> ();
	}




	@Override
	public String toString() {
		return "Biblioteka [naziv=" + naziv + ", adresa=" + adresa + ", telefon=" + telefon + ", radnoVreme="
				+ radnoVreme + ", listaIzdavanja=" + listaIzdavanja + ", listaPrimeraka=" + listaPrimeraka
				+ ", listaKnjiga=" + listaKnjiga + ", listaZanrova=" + listaZanrova + ", listaClanova=" + listaClanova
				+ ", listaTipova=" + listaTipova + ", listaAdministratora=" + listaAdministratora
				+ ", listaBibliotekara=" + listaBibliotekara + "]";
	}

	public void ucitajAdministratore() {
        try {
            File administratoriFile = new File("src/fajlovi/administratori.txt");
            BufferedReader reader = new BufferedReader(new FileReader(administratoriFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String jmbg= lineSplit[3];
                String adresa = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                double plata = Double.parseDouble(lineSplit[6]);
                String korisnickoIme = lineSplit[7];
                String lozinka = lineSplit[8];

                Administrator korisnik = new Administrator(id,ime,prezime,jmbg,adresa,pol,plata,korisnickoIme,lozinka);
                this.listaAdministratora.add(korisnik);
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public void ucitajBibliotekare() {
        try {
            File bibliotekariFile = new File("src/fajlovi/bibliotekari.txt");
            BufferedReader reader = new BufferedReader(new FileReader(bibliotekariFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String jmbg= lineSplit[3];
                String adresa = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                double plata = Double.parseDouble(lineSplit[6]);
                String korisnickoIme = lineSplit[7];
                String lozinka = lineSplit[8];

                Bibliotekar korisnik = new Bibliotekar(id,ime,prezime,jmbg,adresa,pol,plata,korisnickoIme,lozinka);
                this.listaBibliotekara.add(korisnik);
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public void ucitajKnjige() {
        try {
            File knjigeFile = new File("src/fajlovi/knjige.txt");
            BufferedReader reader = new BufferedReader(new FileReader(knjigeFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("|");
                String id = lineSplit[0];
                String naslovKnjige = lineSplit[1];
                String originalNaslovKnjige = lineSplit[2];
                String pisac = lineSplit[3];
                int godinaObjavljivanja = Integer.parseInt(lineSplit[4]);
                String jezikOriginala = lineSplit[5];
                String opis = lineSplit[6];
                Zanr zanr = this.nadjiZanr(lineSplit[7]);
                

                Knjiga korisnik = new Knjiga (id,naslovKnjige, originalNaslovKnjige,pisac,godinaObjavljivanja,jezikOriginala,opis,zanr );
                this.listaKnjiga.add(korisnik);
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public Zanr nadjiZanr(String id) {
        Zanr trazeni = null;
        for(int i = 0; i < this.listaZanrova.size(); i++) {
            if (this.listaZanrova.get(i).getId() == id) {
                trazeni = this.listaZanrova.get(i);
            }
        }
        return trazeni;
        }
	public void ucitajClanove(ArrayList<ClanBiblioteke> clanovi) {
        try {
            File clanoviFile = new File("src/fajlovi/clanovi.txt");
            BufferedReader reader = new BufferedReader(new FileReader(clanoviFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String jmbg = lineSplit[3];
                String adresa = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                String brojClanskeKarte = lineSplit[6];
                LocalDate datumPoslUplate = LocalDate.parse(lineSplit[7]);
                int brojMeseci = Integer.parseInt(lineSplit[8]);
                boolean aktivnost = Boolean.parseBoolean(lineSplit[9]);
                Tip tipClanarine = this.nadjiTip(lineSplit[10]);
                

                ClanBiblioteke korisnik = new ClanBiblioteke (id,ime, prezime, jmbg,adresa,pol,brojClanskeKarte,datumPoslUplate,brojMeseci,aktivnost,tipClanarine );
                this.listaClanova.add(korisnik);
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public Tip nadjiTip(String id) {
        Tip trazeni = null;
        for(int i = 0; i < this.listaTipova.size(); i++) {
            if (this.listaKnjiga.get(i).getId() == id) {
                trazeni = this.listaTipova.get(i);
            }
        }
        return trazeni;
        }
	public void ucitajPrimerkeKnjiga() {
        try {
            File primerciKnjigaFile = new File("src/fajlovi/primerciKnjiga.txt");
            BufferedReader reader = new BufferedReader(new FileReader(primerciKnjigaFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("|");
                String id = lineSplit[0];
                int brojStrana = Integer.parseInt(lineSplit[1]);
                boolean mekPovez = Boolean.parseBoolean(lineSplit[2]);
                int godinaStampanja = Integer.parseInt(lineSplit[3]);
                String jezikStampanja = lineSplit[4];
                boolean iznajmljena = Boolean.parseBoolean(lineSplit[5]);
                Knjiga knjiga= this.nadjiKnjigu(lineSplit[6]);

                PrimerakKnjige korisnik = new PrimerakKnjige (id,brojStrana,mekPovez,godinaStampanja,jezikStampanja,iznajmljena,knjiga);
                this.listaPrimeraka.add(korisnik);
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public Knjiga nadjiKnjigu(String id) {
        Knjiga trazeni = null;
        for(int i = 0; i < this.listaKnjiga.size(); i++) {
            if (this.listaKnjiga.get(i).getId() == id) {
                trazeni = this.listaKnjiga.get(i);
            }
        }
        return trazeni;
        }
	
}
