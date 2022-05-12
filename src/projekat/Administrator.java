package projekat;

public class Administrator extends Zaposleni {

 



	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, double plata,
			String korisnickoIme, String lozinka) {
		super(id, ime, prezime, jmbg, adresa, pol, plata, korisnickoIme, lozinka);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + "]";
	}



}