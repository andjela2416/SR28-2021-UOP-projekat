package projekat;

public class Bibliotekar extends Zaposleni {



	@Override
	public String toString() {
		return "Bibliotekar [plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + "]";
	}

	public Bibliotekar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bibliotekar(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, double plata,
			String korisnickoIme, String lozinka) {
		super(id, ime, prezime, jmbg, adresa, pol, plata, korisnickoIme, lozinka);
		// TODO Auto-generated constructor stub
	}


}
