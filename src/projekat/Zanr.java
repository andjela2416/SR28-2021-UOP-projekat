package projekat;

public class Zanr {


    protected String oznaka;

    protected String opis;


	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Zanr(String oznaka, String opis) {
		super();
		this.oznaka = oznaka;
		this.opis = opis;
	}

	public Zanr() {
		super();
		this.oznaka="";
		this.opis="";
		
	}

	@Override
	public String toString() {
		return "Zanr [oznaka=" + oznaka + ", opis=" + opis + "]";
	}


}