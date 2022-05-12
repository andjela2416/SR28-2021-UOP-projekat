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
    protected ArrayList<Zaposleni> listaZaposlenih;
    







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

	public ArrayList<PrimerakKnjige> getListaPrimeraka() {
		return listaPrimeraka;
	}

	public void setListaPrimeraka(ArrayList<PrimerakKnjige> listaPrimeraka) {
		this.listaPrimeraka = listaPrimeraka;
	}

	public ArrayList<Knjiga> getListaKnjiga() {
		return listaKnjiga;
	}

	public void setListaKnjiga(ArrayList<Knjiga> listaKnjiga) {
		this.listaKnjiga = listaKnjiga;
	}

	public ArrayList<Zanr> getListaZanrova() {
		return listaZanrova;
	}

	public void setListaZanrova(ArrayList<Zanr> listaZanrova) {
		this.listaZanrova = listaZanrova;
	}

	public ArrayList<ClanBiblioteke> getListaClanova() {
		return listaClanova;
	}

	public void setListaClanova(ArrayList<ClanBiblioteke> listaClanova) {
		this.listaClanova = listaClanova;
	}

	public ArrayList<Tip> getListaTipova() {
		return listaTipova;
	}

	public void setListaTipova(ArrayList<Tip> listaTipova) {
		this.listaTipova = listaTipova;
	}

	public ArrayList<Administrator> getListaAdministratora() {
		return listaAdministratora;
	}

	public void setListaAdministratora(ArrayList<Administrator> listaAdministratora) {
		this.listaAdministratora = listaAdministratora;
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
		this.listaZaposlenih = new ArrayList<Zaposleni>();
	}






	@Override
	public String toString() {
		return "Biblioteka [naziv=" + naziv + ", adresa=" + adresa + ", telefon=" + telefon + ", radnoVreme="
				+ radnoVreme + ", listaIzdavanja=" + listaIzdavanja + ", listaPrimeraka=" + listaPrimeraka
				+ ", listaKnjiga=" + listaKnjiga + ", listaZanrova=" + listaZanrova + ", listaClanova=" + listaClanova
				+ ", listaTipova=" + listaTipova + ", listaAdministratora=" + listaAdministratora
				+ ", listaBibliotekara=" + listaBibliotekara + ", listaZaposlenih=" + listaZaposlenih + "]";
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
	public void ucitajKnjige(String kNJIGE_FAJL) {
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
            if (this.listaZanrova.get(i).getOznaka() == id) {
                trazeni = this.listaZanrova.get(i);
            }
        }
        return trazeni;
        }
	public void ucitajClanove(String cLANOVI_FAJL) {
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
	public void ucitajPrimerkeKnjiga(String pRIMERCIKNJIGA_FAJL) {
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
	public void ucitajTip(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				String id = split[0];
				String naziv = split[1];
				double cena = Double.parseDouble(split[2]);
				
				
				Tip tip = new Tip(id, naziv, cena);
				listaTipova.add(tip);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o tipu clanarine");
			e.printStackTrace();
		}
	}
	public void ucitajZaposlene(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				int id = Integer.parseInt(split[0]);
				String ime = split[1];
				String prezime = split[2];
				String Jmbg = split[3];
				String adresa = split[4];
				Pol pol = Pol.valueOf(split[5]);
				String korisnickoIme = split[6];
				String Lozinka = split[7];
				double plata = Double.parseDouble(split[8]);
				
				
				Zaposleni zaposleni = new Zaposleni(id, ime, prezime, Jmbg, adresa, pol, korisnickoIme, Lozinka, plata);
				listaZaposlenih.add(zaposleni);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o zaposlenom");
			e.printStackTrace();
		}
	}
	public void ucitajIznajmljivanje(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				LocalDate datumIzdavanja = LocalDate.parse(split[0]);
				LocalDate datumVracanja = LocalDate.parse(split[1]);
				
				String ZaposleniId = split[2];
				Zaposleni zaposleni = (Zaposleni) pronadjiZaposlenog(ZaposleniId);
				
				String ClanId = split[3];
				ClanBiblioteke clan = (ClanBiblioteke) nadjiClana(ClanId);
				
				PrimerakKnjige = split[4];
				PrimerakKnjige primerakKnjige = (PrimerakKnjige) pronadjiPrimerak(PrimerakKnjigeId);
				
				
				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(datumIznajmljivanja, datumVracanja, zaposleni, clan, primerakKnjige);
				listaIznajmljivanja.add(iznajmljivanje);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o iznajmljivanju");
			e.printStackTrace();
		}
	}
	public Zaposleni pronadjiZaposlenog(String id) {
		for (Zaposleni zaposleni : listaZaposlenih) {
			if(zaposleni.getId() == id) {
				return zaposleni;
			}
		}
		return null;
	}
	
	public ClanBiblioteke nadjiClana(String id) {
		for (ClanBiblioteke clan : listaClanova) {
			if(clan.getId() == id) {
				return clan;
			}
		}
		return null;
	}
	public PrimerakKnjige pronadjiPrimerak(String id) {
		for (PrimerakKnjige primerak : listaPrimeraka) {
			if(primerak.getId() == id) {
				return primerak;
			}
		}
		return null;
	}

	
	public void ucitajZanrove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				String oznaka = split[0];
				String opis = split[1];
				
				
				Zanr zanr = new Zanr(oznaka, opis);
				listaZanrova.add(zanr);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o zanrovima");
			e.printStackTrace();
		}
	}

}
