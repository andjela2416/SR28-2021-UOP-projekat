package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import guiProzori.GlavniProzor;
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
    protected ArrayList<Zaposleni> listaZaposlenih;
    
	public Biblioteka(String naziv, String adresa, String telefon, String radnoVreme,
			ArrayList<IzdavanjeKnjige> listaIzdavanja, ArrayList<PrimerakKnjige> listaPrimeraka,
			ArrayList<Knjiga> listaKnjiga, ArrayList<Zanr> listaZanrova, ArrayList<ClanBiblioteke> listaClanova,
			ArrayList<Tip> listaTipova, ArrayList<Administrator> listaAdministratora,
			ArrayList<Bibliotekar> listaBibliotekara, ArrayList<Zaposleni> listaZaposlenih) {
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
		this.listaZaposlenih = listaZaposlenih;
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
		this.listaZaposlenih = new ArrayList<Zaposleni> ();
	}


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

	public ArrayList<IzdavanjeKnjige> getListaIzdavanja() {
		return listaIzdavanja;
	}

	public void setListaIzdavanja(ArrayList<IzdavanjeKnjige> listaIzdavanja) {
		this.listaIzdavanja = listaIzdavanja;
	}
	public void dodajIzdavanjeKnjige(IzdavanjeKnjige izdavanje) {
		this.listaIzdavanja.add(izdavanje);
	}

	public void obrisiIzdavanjeKnjige(IzdavanjeKnjige izdavanje) {
		this.listaIzdavanja.remove(izdavanje);
	}

	public ArrayList<PrimerakKnjige> getListaPrimeraka() {
		return listaPrimeraka;
	}

	public void setListaPrimeraka(ArrayList<PrimerakKnjige> listaPrimeraka) {
		this.listaPrimeraka = listaPrimeraka;
	}
	public void dodajPrimerakKnjige(PrimerakKnjige primerak) {
		this.listaPrimeraka.add(primerak);
	}

	public void obrisiPrimerakKnjige(PrimerakKnjige primerak) {
		this.listaPrimeraka.remove(primerak);
	}

	public ArrayList<Knjiga> getListaKnjiga() {
		return listaKnjiga;
	}

	public void setListaKnjiga(ArrayList<Knjiga> listaKnjiga) {
		this.listaKnjiga = listaKnjiga;
	}
	public void dodajKnjigu(Knjiga knjiga) {
		this.listaKnjiga.add(knjiga);
	}

	public void obrisiKnjigu(Knjiga knjiga) {
		this.listaKnjiga.remove(knjiga);
	}

	public ArrayList<Zanr> getListaZanrova() {
		return listaZanrova;
	}

	public void setListaZanrova(ArrayList<Zanr> listaZanrova) {
		this.listaZanrova = listaZanrova;
	}
	public void dodajZanr(Zanr zanr) {
		this.listaZanrova.add(zanr); 
	}

	public void obrisiZanr(Zanr zanr) {
		this.listaZanrova.remove(zanr);
	}

	public ArrayList<ClanBiblioteke> getListaClanova() {
		return listaClanova;
	}

	public void setListaClanova(ArrayList<ClanBiblioteke> listaClanova) {
		this.listaClanova = listaClanova;
	}
	
	public void dodajClana(ClanBiblioteke clan) {
		this.listaClanova.add(clan);
	}

	public void obrisiClana(ClanBiblioteke clan) {
		this.listaClanova.remove(clan);
	}
	public ArrayList<Tip> getListaTipova() {
		return listaTipova;
	}

	public void setListaTipova(ArrayList<Tip> listaTipova) {
		this.listaTipova = listaTipova;
	}
	public void dodajTip(Tip tip) {
		this.listaTipova.add(tip);
	}

	public void obrisiTip(Tip tip) {
		this.listaTipova.remove(tip);
	}

	public ArrayList<Administrator> getListaAdministratora() {
		return listaAdministratora;
	}

	public void setListaAdministratora(ArrayList<Administrator> listaAdministratora) {
		this.listaAdministratora = listaAdministratora;
	}
	public void dodajAdministratora(Administrator admin) {
		this.listaAdministratora.add(admin);
	}

	public void obrisiAdministratora(Administrator admin) {
		this.listaAdministratora.remove(admin);
	}

	public ArrayList<Bibliotekar> getListaBibliotekara() {
		return listaBibliotekara;
	}

	public void setListaBibliotekara(ArrayList<Bibliotekar> listaBibliotekara) {
		this.listaBibliotekara = listaBibliotekara;
	}


	public ArrayList<Zaposleni> getListaZaposlenih() {
		return listaZaposlenih;
	}

	public void setListaZaposlenih(ArrayList<Zaposleni> listaZaposlenih) {
		this.listaZaposlenih = listaZaposlenih;
	}
	
	public void dodajBibliotekara(Bibliotekar bibliotekar) {
		this.listaBibliotekara.add(bibliotekar);
	}

	public void obrisiBibliotekara(Bibliotekar bibliotekar) {
		this.listaBibliotekara.remove(bibliotekar);
	}
	public ArrayList<Knjiga> sveNeobrisaneKnjige() {
		ArrayList<Knjiga> neobrisane = new ArrayList<Knjiga>();
		for(Knjiga knjiga : this.listaKnjiga) {
			if(!knjiga.isObrisan()) {
				neobrisane.add(knjiga);
			}
		}
		return neobrisane;
		
	}
	public Knjiga pronadjiKnjigu(String id) {
		for (Knjiga knjiga : sveNeobrisaneKnjige()) {
			if(knjiga.getId().equals(id)) {
				return knjiga;
			}
		}
		return null;
	}
	public ArrayList<ClanBiblioteke> sviNeobrisaniClanovi() {
		ArrayList<ClanBiblioteke> neobrisani = new ArrayList<ClanBiblioteke>();
		for (ClanBiblioteke clan : this.listaClanova) {
			if(!clan.isObrisan()) {
				neobrisani.add(clan);
				clan.setAktivan(clan.getDatumPoslUplate().plusDays(clan.getBrojMeseciClan()*30).isAfter(LocalDate.now()));
			}
		}
		return neobrisani;
	}
	
	public ClanBiblioteke pronadjiClana(String id) {
		for (ClanBiblioteke clan : sviNeobrisaniClanovi()) {
			if(clan.getId().equals(id)) {
				return clan;
			}
		}
		return null;
	}
	public ArrayList<PrimerakKnjige> sviNeobrisaniPrimerciKnjiga() {
		ArrayList<PrimerakKnjige> neobrisani = new ArrayList<PrimerakKnjige>();
		for (PrimerakKnjige primerak : this.listaPrimeraka) {
			if(!primerak.isObrisan()) {
				neobrisani.add(primerak);
				//System.out.println(this.listaPrimeraka);
			}
		}
		
		return neobrisani;
		
	}
	public ArrayList<PrimerakKnjige> sviNeiznajmljeniPrimerciKnjiga() {
		ArrayList<PrimerakKnjige> neiznajm = new ArrayList<PrimerakKnjige>();
		for (PrimerakKnjige primerak : this.sviNeobrisaniPrimerciKnjiga()) {
			if(!primerak.isIznajmljena()) {
				neiznajm.add(primerak);
				//System.out.println(this.listaPrimeraka);
			}
		}
		
		return neiznajm;
		
	}
	
//	public PrimerakKnjige pronadjiPrimerak(String id) {
//		System.out.println(sviNeobrisaniPrimerciKnjiga());
//		for (PrimerakKnjige primerak : sviNeobrisaniPrimerciKnjiga()) {
//			if(primerak.getId().equals(id)) {
//				return primerak;
//			}
//		}
//		return null;
//	}

	public ArrayList<Bibliotekar> sviNeobrisaniBibliotekari() {
		ArrayList<Bibliotekar> neobrisani = new ArrayList<Bibliotekar>();
		for (Bibliotekar bibliotekar : this.listaBibliotekara) {
			if(!bibliotekar.isObrisan()) {
				neobrisani.add(bibliotekar);
			}
		}
		return neobrisani;
	}
	public Bibliotekar pronadjiBibliotekara(String id) {
		for (Bibliotekar bibliotekar : sviNeobrisaniBibliotekari() ){
			if(bibliotekar.getId().equals(id)) {
				return bibliotekar;
			}
		}
		return null;
	}
	public ArrayList<Administrator> sviNeobrisaniAdministratori() {
		
		ArrayList<Administrator> neobrisani = new ArrayList<Administrator>();
		
		for (Administrator admin: this.listaAdministratora) {
			
			if(!admin.isObrisan()) {
				neobrisani.add(admin);
			}
		}
		
		return neobrisani;
	}
	public Administrator pronadjiAdministratora(String id) {
		for (Administrator administrator : this.listaAdministratora) {
			if(administrator.getId().equals(id)) {
				return administrator;
			}
		}
		return null;
	}
	public ArrayList<IzdavanjeKnjige> svaNeobrisanaIzdavanja() {
//		System.out.println(this.listaIzdavanja);
		ArrayList<IzdavanjeKnjige> neobrisani = new ArrayList<IzdavanjeKnjige>();
		for (IzdavanjeKnjige izdavanje: this.listaIzdavanja) {
			if(!izdavanje.isObrisan()) {
				neobrisani.add(izdavanje);
			}
		}
		return neobrisani;
	}
	
//	public IzdavanjeKnjige pronadjiIzdavanje(String id) {
//		for (IzdavanjeKnjige izdavanje : svaNeobrisanaIzdavanja()) {
//			if(izdavanje.getId().equals(id)) {
//				return izdavanje;
//			}																	
//		}
//		return null;
//	}
	public ArrayList<Tip> sviNeobrisaniTipovi() {
		ArrayList<Tip> neobrisani = new ArrayList<Tip>();
		for (Tip tipclanarine: this.listaTipova) {
			if(!tipclanarine.isObrisan()) {
				neobrisani.add(tipclanarine);
			}
		}
		return neobrisani;
	}
	public Tip nadjiTip(String id) {
        Tip trazeni = null;
        //System.out.println(this.listaTipova);
        for(Tip t:sviNeobrisaniTipovi()) {
            if (t.getId().equals(id)) {
                trazeni = t;
            }
        }
        return trazeni;
        }
	
	public ArrayList<Zanr> sviNeobrisaniZanrovi() {
		ArrayList<Zanr> neobrisani = new ArrayList<Zanr>();
		for (Zanr zanrknjige: this.listaZanrova) {
			if(!zanrknjige.isObrisan()) {
				neobrisani.add(zanrknjige);
			}
		}
		return neobrisani;
		
	}
	public Zanr nadjiZanr(String id) {
        Zanr trazeni = null;
        for(int i = 0; i < sviNeobrisaniZanrovi().size(); i++) {
            if (sviNeobrisaniZanrovi().get(i).getOznaka().equals(id)) {
                trazeni =sviNeobrisaniZanrovi().get(i);
            }
        }
        return trazeni;                          ////////vidi da li radi!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
        }
	
	



	@Override
	public String toString() {
		return "Biblioteka [naziv=" + naziv + ", adresa=" + adresa + ", telefon=" + telefon + ", radnoVreme="
				+ radnoVreme + ", listaIzdavanja=" + listaIzdavanja + ", listaPrimeraka=" + listaPrimeraka
				+ ", listaKnjiga=" + listaKnjiga + ", listaZanrova=" + listaZanrova + ", listaClanova=" + listaClanova
				+ ", listaTipova=" + listaTipova + ", listaAdministratora=" + listaAdministratora
				+ ", listaBibliotekara=" + listaBibliotekara + ", listaZaposlenih=" + listaZaposlenih + "]";
	}

	public void ucitajAdministratore(String ADMINISTRATORI_FAJL) {
        try {
        	
            File administratoriFile = new File("fajlovi/administratori.txt");
            BufferedReader reader = new BufferedReader(new FileReader(administratoriFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String jmbg= lineSplit[3];
                String adresa = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                boolean obrisan = Boolean.parseBoolean(lineSplit[6]);
                double plata = Double.parseDouble(lineSplit[7]);
                String korisnickoIme = lineSplit[8];
                String lozinka = lineSplit[9];

                boolean provera = true;
                for (Administrator admin:this.listaAdministratora) {
                	if (admin.getId().equals(id)) {
                		provera = false;
                		break;
                	}
                }
                if (provera) {
                	Administrator administrator = new Administrator(id,ime,prezime,jmbg,adresa,pol,obrisan,plata,korisnickoIme,lozinka);
                	this.listaAdministratora.add(administrator);
                }
                
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public void ucitajBibliotekare(String BIBLIOTEKARI_FAJL) {
        try {
            File bibliotekariFile = new File("fajlovi/bibliotekari.txt");
            BufferedReader reader = new BufferedReader(new FileReader(bibliotekariFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String jmbg= lineSplit[3];
                String adresa = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                boolean obrisan = Boolean.parseBoolean(lineSplit[6]);
                double plata = Double.parseDouble(lineSplit[7]);
                String korisnickoIme = lineSplit[8];
                String lozinka = lineSplit[9];

                boolean provera = true;
                for (Bibliotekar bibliotekar:this.listaBibliotekara) {
                	if (bibliotekar.getId().equals(id)) {
                		provera = false;
                		break;
                	}
                }
                if (provera) {
                	Bibliotekar bibliotekar = new Bibliotekar(id,ime,prezime,jmbg,adresa,pol,obrisan,plata,korisnickoIme,lozinka);
                	this.listaBibliotekara.add(bibliotekar);
                }
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }

	
	public void ucitajKnjige(String KNJIGE_FAJL) {
        try {
            File knjigeFile = new File("fajlovi/Knjiga.txt");
            BufferedReader reader = new BufferedReader(new FileReader(knjigeFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String naslovKnjige = lineSplit[1];
                String originalNaslovKnjige = lineSplit[2];
                String pisac = lineSplit[3];
                int godinaObjavljivanja = Integer.parseInt(lineSplit[4]);
                String jezikOriginala = lineSplit[5];
                String opis = lineSplit[6];
                String zanrId = lineSplit[7];
                Zanr zanr = nadjiZanr2(zanrId);
                
                boolean obrisan = Boolean.parseBoolean(lineSplit[8]);
                
                boolean provera = true;
                for (Knjiga knjiga:this.listaKnjiga) {
                	if (knjiga.getId().equals(id)) {
                		provera = false;
                		break;
                	}
                }
                if (provera) {
                	Knjiga knjiga = new Knjiga (id,naslovKnjige, originalNaslovKnjige,pisac,godinaObjavljivanja,jezikOriginala,opis,zanr,obrisan );
                    this.listaKnjiga.add(knjiga);
                }
                
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public Zanr nadjiZanr2(String id) {
		this.ucitajZanrove("zanrovi.txt");
	
		for (Zanr zanr : listaZanrova) {
			//System.out.println(clan);
			if(zanr.getOznaka().equals(id)) {
				return zanr;
			
			}
		}
		return null;
	}
	public IzdavanjeKnjige nadjiIzdavanje(String id) {
		this.ucitajIznajmljivanje("izdavanje.txt"); 
	
		for (IzdavanjeKnjige izdavanje: listaIzdavanja) {
			//System.out.println(clan);
			if(izdavanje.getId().equals(id)) {
				return izdavanje;
			
			}
		}
		return null;
	}

//	public Zanr nadjiZanr(String id) {
//        Zanr trazeni = null;
//        for(int i = 0; i < this.listaZanrova.size(); i++) {
//            if (this.listaZanrova.get(i).getOznaka().equals(id)) {
//                trazeni = this.listaZanrova.get(i);
//            }
//        }
//        return trazeni;
//        }
	public void ucitajClanove(String CLANOVI_FAJL) {
        try {
            File clanoviFile = new File("fajlovi/clanovi.txt");
            BufferedReader reader = new BufferedReader(new FileReader(clanoviFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String jmbg = lineSplit[3];
                String adresa = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                boolean obrisan = Boolean.parseBoolean(lineSplit[6]);
                String brojClanskeKarte = lineSplit[7];
                LocalDate datumPoslUplate = LocalDate.parse(lineSplit[8]);
                int brojMeseci = Integer.parseInt(lineSplit[9]);
                boolean aktivnost = Boolean.parseBoolean(lineSplit[10]);
                Tip tipClanarine = this.nadjiTip2(lineSplit[11]);
                
                boolean provera = true;
                for (ClanBiblioteke clan:this.listaClanova) {
                	if (clan.getId().equals(id)) {
                		provera = false;
                		break;
                	}
                }
                if (provera) {
                	ClanBiblioteke korisnik = new ClanBiblioteke (id,ime, prezime, jmbg,adresa,pol,obrisan,brojClanskeKarte,datumPoslUplate,brojMeseci,aktivnost,tipClanarine );
                    this.listaClanova.add(korisnik);
                }
                
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
//	public Tip nadjiTip(String id) {
//        Tip trazeni = null;
//        //System.out.println(this.listaTipova);
//        for(Tip t:this.listaTipova) {
//            if (t.getId().equals(id)) {
//                trazeni = t;
//            }
//        }
//        return trazeni;
//        }
	public Tip nadjiTip2(String id) {
		this.ucitajTip("tipoviClanarine.txt");
		for (Tip tip : this.listaTipova) {
			//System.out.println(clan);
			if(tip.getId().equals(id)) {
				return tip;
			
			}
		}
		return null;
	}
	public void ucitajPrimerkeKnjiga(String pRIMERCIKNJIGA_FAJL) {
        try {
            File primerciKnjigaFile = new File("fajlovi/primerciKnjiga.txt");
            BufferedReader reader = new BufferedReader(new FileReader(primerciKnjigaFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                int brojStrana = Integer.parseInt(lineSplit[1]);
                boolean mekPovez = Boolean.parseBoolean(lineSplit[2]);
                int godinaStampanja = Integer.parseInt(lineSplit[3]);
                String jezikStampanja = lineSplit[4];
                boolean iznajmljena = Boolean.parseBoolean(lineSplit[5]);
                Knjiga knjiga= this.nadjiKnjigu2(lineSplit[6]);
                //System.out.println(this.nadjiKnjigu(lineSplit[6]));
                boolean obrisan = Boolean.parseBoolean(lineSplit[7]);
                boolean provera = true;
                for (PrimerakKnjige primerak:this.listaPrimeraka) {
                	if (primerak.getId().equals(id)) {
                		provera = false;
                		break;
                	}
                }
                if (provera) {
                	PrimerakKnjige primerakKnjige = new PrimerakKnjige (id,brojStrana,mekPovez,godinaStampanja,jezikStampanja,iznajmljena,knjiga,obrisan);
                    this.listaPrimeraka.add(primerakKnjige);
                }
                
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public Knjiga nadjiKnjigu(String id) {
        Knjiga trazeni = null;
//        System.out.println(this.getListaKnjiga());
        for(int i = 0; i < this.getListaKnjiga().size(); i++) {
        	
            if (this.getListaKnjiga().get(i).getId().equals(id)) {
                trazeni = this.listaKnjiga.get(i);
                
            }
        }
        return trazeni;
        }
	public void ucitajTip(String TIPOVI_FAJL) {
		try {
			File file = new File("fajlovi/" + TIPOVI_FAJL);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				String id = split[0];
				String naziv = split[1];
				double cena = Double.parseDouble(split[2]);
				boolean obrisan = Boolean.parseBoolean(split[3]);
				
				  boolean provera = true;
	                for (Tip tip:this.listaTipova) {
	                	if (tip.getId().equals(id)) {
	                		provera = false;
	                		break;
	                	}
	                }
	                if (provera) {
	                	Tip tip = new Tip(id, naziv, cena,obrisan);
	    				listaTipova.add(tip);
	                }
				
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o tipu clanarine");
			e.printStackTrace();
		}
	}
	
	ArrayList<PrimerakKnjige> sviPrimerci = new ArrayList<PrimerakKnjige>();
	public void ucitajIznajmljivanje(String IZNAJMLJIVANJE_FAJL) {
		try {
			File file = new File("fajlovi/" + IZNAJMLJIVANJE_FAJL);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				String id = split[0];
				LocalDate datumIzdavanja = LocalDate.parse(split[1]);
				LocalDate datumVracanja = LocalDate.parse(split[2]);
				//zelimo upis primeraka npr 2,3 pa pravimo List koju posle prebacimo u ArrayList
				
				String x = split[3];
				String[]str =  x.split(",");
				ArrayList<PrimerakKnjige> PrimerakId = new ArrayList<PrimerakKnjige>();
				for (String s: str) {
					for(PrimerakKnjige p : this.listaPrimeraka) {
						if (p.getId().equals(s)) {
							PrimerakId.add(p);
						}
					}
				}
			

				String ZaposleniId = split[4];
				Zaposleni zaposleni = pronadjiZaposlenog(ZaposleniId);
				//System.out.println(zaposleni);
				
				String ClanId = split[5];
				ClanBiblioteke clan = (ClanBiblioteke) nadjiClana(ClanId);
				
				boolean obrisan = Boolean.parseBoolean(split[6]);
				
				 boolean provera = true;
	                for (IzdavanjeKnjige izdavanje:this.listaIzdavanja) {
	                	if (izdavanje.getId().equals(id)) {
	                		provera = false;
	                		break;
	                	}
	                }
	                if (provera) {
	                	IzdavanjeKnjige izdavanje = new IzdavanjeKnjige(id,datumIzdavanja, datumVracanja, PrimerakId,zaposleni, clan,obrisan);
	    				listaIzdavanja.add(izdavanje);
	                }
				
			
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o iznajmljivanju");
			e.printStackTrace();
		}
	}
	public Biblioteka ucitajBiblioteku(String imeFajla) {
        try {
            File file = new File("fajlovi/biblioteka.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] split = line.split("\\|");

                String naziv = (split[0]);
                String adresa = (split[1]);
                String brojT = (split[2]);
                String radnoV = (split[3]);
                
                

                Biblioteka biblioteka = new Biblioteka(naziv, adresa, brojT, radnoV, null,null,null, null, null,null,null,null,null);
                return biblioteka;

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom snimanja podataka o iznajmljivanju");
            e.printStackTrace();
        }
        return null;

    }
	public void snimiBiblioteku(String imeFajla) {
        try {
            File file = new File("fajlovi/biblioteka.txt");
            String content = "";


            content += this.getNaziv() + "|" + this.getAdresa() + "|" + this.getTelefon() + "|" 
                        + this.getRadnoVreme() + "\n";


            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("Greska prilikom snimanja biblioteke.");
        }
    }
	public Zaposleni pronadjiZaposlenog(String id) {
		Zaposleni zaposleni = null;
		this.ucitajAdministratore("administratori.txt");
		this.ucitajBibliotekare("bibliotekari.txt");
		for (Administrator a:this.listaAdministratora) {
			
			if (a.getId().equals(id)) {
				zaposleni = a;
				//System.out.println(zaposleni);
				
			}
		}
		if (zaposleni==null) {
			for (Bibliotekar a:this.listaBibliotekara) {
				
				if (a.getId().equals(id)) {
					
					zaposleni = a;
				}
			}
			
		}
		//System.out.println(zaposleni);
		return zaposleni;
	}
	
	public ClanBiblioteke nadjiClana(String id) {
		this.ucitajClanove("clanovi.txt");
		for (ClanBiblioteke clan : this.listaClanova) {
			//System.out.println(clan);
			if(clan.getId().equals(id)) {
				return clan;
			
			}
		}
		return null;
	}
	public Knjiga nadjiKnjigu2(String id) {
		this.ucitajKnjige("Knjiga.txt");
		for (Knjiga knjiga : this.listaKnjiga) {
			//System.out.println(clan);
			if(knjiga.getId().equals(id)) {
				return knjiga;
			
			}
		}
		return null;
	}
	public PrimerakKnjige pronadjiPrimerak(String id) {
		this.ucitajPrimerkeKnjiga("primerciKnjiga.txt");
		
		for (PrimerakKnjige primerak : this.listaPrimeraka) {
			
			if(primerak.getId().equals(id)) {
				return primerak;
				
			}
		}
		
		return null;
	}

	
	public void ucitajZanrove(String imeFajla) {
		try {
			File file = new File("fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				String oznaka = split[0];
				String opis = split[1];
				boolean obrisan = Boolean.parseBoolean(split[2]);
				
				 boolean provera = true;
	                for (Zanr zanr:this.listaZanrova) {
	                	if (zanr.getOznaka().equals(oznaka)) {
	                		provera = false;
	                		break;
	                	}
	                }
	                if (provera) {
	            		Zanr zanr = new Zanr(oznaka, opis,obrisan);
	    				listaZanrova.add(zanr);
	                }
				
			
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o zanrovima");
			e.printStackTrace();
		}
	}
	public void snimiKnjige() {
		try {
			File file = new File("fajlovi/Knjiga.txt" );
			String content = "";
			for (Knjiga knjiga : this.listaKnjiga) {
				content += knjiga.getId() + "|" + knjiga.getNaslovKnjige() + "|"
						+ knjiga.getOriginalNaslovKnjige() + "|" + knjiga.getPisac() + "|"
						+ knjiga.getGodinaObjavljivanja() + "|"+ knjiga.getJezikOriginala()+ "|" + knjiga.getOpis() + "|" + knjiga.getZanr().getOznaka() + "|" + knjiga.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja knjiga.");
		}
	}
	public void snimiZanrove() {
		try {
			File file = new File("fajlovi/zanrovi.txt");
			String content = "";
			for (Zanr zanr : this.listaZanrova) {
				content += zanr.getOznaka() + "|" + zanr.getOpis()+ "|" +zanr.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja zanrova.");
		}
	}
	
	
	public void snimiClanove() {
		try {
			File file = new File("fajlovi/clanovi.txt");
			String content = "";
			for (ClanBiblioteke clan : this.listaClanova) {    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				content += clan.getId() + "|" + clan.getIme() + "|" 
						+ clan.getPrezime() + "|" + clan.getJmbg() + "|"
						+ clan.getAdresa() + "|" + clan.getPol() + "|" + clan.isObrisan()+ "|"+ clan.getBrojClanskeKarte()
						+ "|" + clan.getDatumPoslUplate() + "|" + clan.getBrojMeseciClan() 
						+ "|" + clan.isAktivan() + "|" + clan.getTip().getId() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja clanova.");
		}
	}

	
	public void snimiPrimerkeKnjiga() {

		try {
			File file = new File("fajlovi/primerciKnjiga.txt" );
			String content = "";
			for (PrimerakKnjige primerak : this.listaPrimeraka) {
				
				content += primerak.getId() + "|" + primerak.getBrojStrana() + "|" 
						+ primerak.isMekPovez() + "|" + primerak.getGodinaStampanja() + "|"
						+ primerak.getJezikStampanja()+"|"+ primerak.isIznajmljena() + "|" + primerak.getKnjiga().getId() + "|" + primerak.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public void snimiTipClanarine() {
		try {
			File file = new File("fajlovi/tipoviClanarine.txt" );
			String content = "";
			for (Tip tip : this.listaTipova) {
				content += tip.getId() + "|" + tip.getNaziv() + "|" + tip.getCena()+ "|" + tip.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja tipa clanarine.");
		}
	}
	public void snimiZaposlene(String ZAPOSLENI_FAJL) {
		try {
			File file = new File("fajlovi/" + ZAPOSLENI_FAJL);
			String content = "";
			for (Zaposleni zaposleni : this.listaZaposlenih) {
				content += zaposleni.getId() + "|" + zaposleni.getIme() + "|" 
						+ zaposleni.getPrezime() + "|" + zaposleni.getJmbg() + "|"
						+ zaposleni.getAdresa() + "|" + zaposleni.getPol() + "|" + zaposleni.isObrisan()+ "|" + zaposleni.getPlata() + "|" + zaposleni.getKorisnickoIme() + "|" 
						+ zaposleni.getLozinka() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja zaposlenih.");
		}
	}

	
	public void snimiIznajmljivanje() {
		try {
			File file = new File("fajlovi/izdavanje.txt" );
			String content = "";
			
			for (IzdavanjeKnjige iznajmljivanje : this.listaIzdavanja) {
				String sviprimerci="";
				ArrayList<PrimerakKnjige> primerci = iznajmljivanje.getPrimerci();
				
				for(PrimerakKnjige i:primerci) {
					
					sviprimerci+=i.getId()+",";
				}
				
				StringBuffer sb  = new StringBuffer(sviprimerci);
				sb.deleteCharAt(sb.length()-1);
				
				content += iznajmljivanje.getId() + "|" +iznajmljivanje.getDatumIznajmljivanja() + "|" + iznajmljivanje.getDatumVracanja() + "|" + sb + "|"
						+ iznajmljivanje.getZaposleni().getId() + "|" + iznajmljivanje.getClan().getId() + "|" + iznajmljivanje.isObrisan() + "\n";
				
			
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void snimiBibliotekare() {
		try {
			File file = new File("fajlovi/bibliotekari.txt" );
			String content = "";
			for (Bibliotekar bibliotekar : this.listaBibliotekara) {
				content +=bibliotekar.getId() + "|" + bibliotekar.getIme() + "|" 
						+ bibliotekar.getPrezime() + "|" + bibliotekar.getJmbg() + "|"
						+ bibliotekar.getAdresa() + "|" + bibliotekar.getPol() + "|"+ bibliotekar.isObrisan()+ "|" + bibliotekar.getPlata() + "|" + bibliotekar.getKorisnickoIme() + "|" 
						+ bibliotekar.getLozinka() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void snimiAdministratore() {
		try {
			File file = new File("fajlovi/administratori.txt" );
			String content = "";
			for (Administrator administrator : this.listaAdministratora) {
				content +=administrator.getId() + "|" + administrator.getIme() + "|" 
						+ administrator.getPrezime() + "|" + administrator.getJmbg() + "|"
						+ administrator.getAdresa() + "|" + administrator.getPol() + "|" + administrator.isObrisan()+ "|"+ administrator.getPlata() + "|" + administrator.getKorisnickoIme() + "|" 
						+ administrator.getLozinka() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) { 
			System.out.println(e);
		}
	}
//	public Zaposleni login(String korisnickoIme, String lozinka) {
//		for(Zaposleni zaposleni : listaZaposlenih) {
//			if(zaposleni.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
//					zaposleni.getLozinka().equals(lozinka) && !zaposleni.isObrisan()) {
//				return zaposleni;
//			}
//		}
//		return null;
//	}
	public Zaposleni login(String korisnickoIme, String lozinka, Biblioteka biblioteka) {
		Zaposleni zaposleni = null;
		
		this.ucitajAdministratore("administratori.txt");
		this.ucitajBibliotekare("bibliotekari.txt");
		for (Administrator a:this.listaAdministratora) {
			
			if (a.getKorisnickoIme().equals(korisnickoIme) && a.getLozinka().equals(lozinka) && !a.isObrisan()) {
				zaposleni = a;
				//System.out.println(zaposleni);
				//GlavniProzor g=new GlavniProzor(biblioteka, a);
				//g.setVisible(true);
				
			}
		}
		if (zaposleni==null) {
			for (Bibliotekar a:this.listaBibliotekara) {
				
				if (a.getKorisnickoIme().equals(korisnickoIme) && a.getLozinka().equals(lozinka) && !a.isObrisan()) {

					zaposleni = a;
//					GlavniProzor g=new GlavniProzor(biblioteka,a);
//					g.setVisible(true);
				}
			}
			
		}
		//System.out.println(zaposleni);
		return zaposleni;
	}


}
