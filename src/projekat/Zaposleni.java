package projekat;

public class Zaposleni extends Osoba {

    protected double plata;

    protected String korisnickoIme;

    protected String lozinka;



	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}





	public Zaposleni(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, boolean obrisan,
			double plata, String korisnickoIme, String lozinka) {
		super(id, ime, prezime, jmbg, adresa, pol, obrisan);
		this.plata = plata;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}


	public Zaposleni(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, boolean obrisan) {
		super(id, ime, prezime, jmbg, adresa, pol, obrisan);
	}

	@Override
	public String toString() {
		return "Zaposleni [plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id=" + id
				+ ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol=" + pol
				+ ", obrisan=" + obrisan + "]";
	}



	



}
