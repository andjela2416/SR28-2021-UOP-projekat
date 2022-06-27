package projekat;

import java.time.LocalDate;
import java.util.ArrayList;

public class IzdavanjeKnjige {

	protected String id;
    protected LocalDate datumIznajmljivanja;
    protected LocalDate datumVracanja;
    protected ArrayList<PrimerakKnjige> primerci;
	protected Zaposleni zaposleni;
    protected ClanBiblioteke clan;
    protected boolean obrisan;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
    public ArrayList<PrimerakKnjige> getPrimerci() {
		return primerci;
	}
	public void setPrimerci(ArrayList<PrimerakKnjige> primerci) {
		this.primerci = primerci;
	}
	public Zaposleni getZaposleni() {
		return zaposleni;
	}
	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}
	public ClanBiblioteke getClan() {
		return clan;
	}
	public void setClan(ClanBiblioteke clan) {
		this.clan = clan;
	}
	public boolean isObrisan() {
		return obrisan;
	}
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	public IzdavanjeKnjige(String id, LocalDate datumIznajmljivanja, LocalDate datumVracanja, ArrayList<PrimerakKnjige> primerci,
			Zaposleni zaposleni, ClanBiblioteke clan, boolean obrisan) {
		super();
		this.id = id;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.primerci = primerci;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.obrisan = obrisan;
	}
	public 	IzdavanjeKnjige() {
		this.id = "";
		this.datumIznajmljivanja = null;
		this.datumVracanja = null;
		this.primerci = new ArrayList<PrimerakKnjige>();
		this.zaposleni = null;
		this.clan = null;
		this.obrisan = false;
	}
	@Override
	public String toString() {
		return "IzdavanjeKnjige [id=" + id + ", datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja="
				+ datumVracanja + ", primerci=" + primerci + ", zaposleni=" + zaposleni + ", clan=" + clan
				+ ", obrisan=" + obrisan + "]";
	}
	
    
    
}