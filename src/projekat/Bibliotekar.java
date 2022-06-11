package projekat;

public class Bibliotekar extends Zaposleni {



	


	public Bibliotekar(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, boolean obrisan,
			double plata, String korisnickoIme, String lozinka) {
		super(id, ime, prezime, jmbg, adresa, pol, obrisan, plata, korisnickoIme, lozinka);
		// TODO Auto-generated constructor stub
	}

	public Bibliotekar(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, boolean obrisan) {
		super(id, ime, prezime, jmbg, adresa, pol, obrisan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bibliotekar [plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol="
				+ pol + ", obrisan=" + obrisan + "]";
	}









}
