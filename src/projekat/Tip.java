package projekat;

public class Tip {

    protected String id;

    protected String naziv;

    protected double cena;


	

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

	public Tip(String id, String naziv, double cena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
	}

	public Tip() {
		super();
		this.id="";
		this.cena=0;
		this.naziv="";
	}

	@Override
	public String toString() {
		return "Tip [id=" + id + ", naziv=" + naziv + ", cena=" + cena + "]";
	}


}
