package projekat;

public class Zanr {


    protected String oznaka;

    protected String opis;
    
    protected boolean obrisan;

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

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public Zanr(String oznaka, String opis, boolean obrisan) {
		super();
		this.oznaka = oznaka;
		this.opis = opis;
		this.obrisan = obrisan;
	}

	public Zanr() {
		super();
	}

	@Override
	public String toString() {
		return "Zanr [oznaka=" + oznaka + ", opis=" + opis + ", obrisan=" + obrisan + "]";
	}




}