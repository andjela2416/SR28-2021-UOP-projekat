package projekat;

public class Tip {

    protected String id;

    protected String naziv;

    protected double cena;
    
    protected boolean obrisan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public Tip(String id, String naziv, double cena, boolean obrisan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.obrisan = obrisan;
	}

	public Tip() {
		super();
	}

	@Override
	public String toString() {
		return "Tip [id=" + id + ", naziv=" + naziv + ", cena=" + cena + ", obrisan=" + obrisan + "]";
	}


	

	

}
