package projekat;

public abstract class Osoba {

    protected String id;

    protected String ime;

    protected String prezime;

    protected String jmbg;

    protected String adresa;
    
    protected Pol pol;



	public Osoba(String id, String ime, String prezime, String jmbg, String adresa, Pol pol) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.pol = pol;
	}


	public Osoba() {
		super();
		this.id="";
		this.adresa="";
		this.ime="";
		this.jmbg="";
		this.prezime="";
		this.pol=Pol.ZENSKI;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getJmbg() {
		return jmbg;
	}


	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public Pol getPol() {
		return pol;
	}


	public void setPol(Pol pol) {
		this.pol = pol;
	}


	@Override
	public String toString() {
		return "Osoba [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa
				+ ", pol=" + pol + "]";
	}


	
}
