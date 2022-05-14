package projekat;

public class Knjiga {

    protected String id;

    protected String naslovKnjige;

    protected String originalNaslovKnjige;

    protected String pisac;

    protected int godinaObjavljivanja;

    protected String jezikOriginala;

    protected String opis;
    
    protected Zanr zanr;

	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaslovKnjige() {
		return naslovKnjige;
	}

	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}

	public String getOriginalNaslovKnjige() {
		return originalNaslovKnjige;
	}

	public void setOriginalNaslovKnjige(String originalNaslovKnjige) {
		this.originalNaslovKnjige = originalNaslovKnjige;
	}

	public String getPisac() {
		return pisac;
	}

	public void setPisac(String pisac) {
		this.pisac = pisac;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public String getJezikOriginala() {
		return jezikOriginala;
	}

	public void setJezikOriginala(String jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}


	public Knjiga(String id, String naslovKnjige, String originalNaslovKnjige, String pisac, int godinaObjavljivanja,
			String jezikOriginala, String opis, Zanr zanr) {
		super();
		this.id = id;
		this.naslovKnjige = naslovKnjige;
		this.originalNaslovKnjige = originalNaslovKnjige;
		this.pisac = pisac;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.jezikOriginala = jezikOriginala;
		this.opis = opis;
		this.zanr = zanr;
	}

	public Knjiga() {
		super();
		this.id = "";
		this.naslovKnjige = "";
		this.godinaObjavljivanja = 0;
		this.jezikOriginala="";
		this.opis = "";
		this.originalNaslovKnjige="";
		this.pisac="";
		this.zanr= new Zanr();
		
	}

	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naslovKnjige=" + naslovKnjige + ", originalNaslovKnjige=" + originalNaslovKnjige
				+ ", pisac=" + pisac + ", godinaObjavljivanja=" + godinaObjavljivanja + ", jezikOriginala="
				+ jezikOriginala + ", opis=" + opis + ", zanr=" + zanr + "]";
	}



	

}
