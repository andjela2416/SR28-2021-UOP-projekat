package projekat;

import java.time.LocalDate;

public class IzdavanjeKnjige {


    protected LocalDate datumIznajmljivanja;

    protected LocalDate datumVracanja;
    protected PrimerakKnjige primerak;
    protected Zaposleni zaposleni;
    protected ClanBiblioteke clan;
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
	public PrimerakKnjige getPrimerak() {
		return primerak;
	}
	public void setPrimerak(PrimerakKnjige primerak) {
		this.primerak = primerak;
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
	public IzdavanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja, PrimerakKnjige primerak,
			Zaposleni zaposleni, ClanBiblioteke clan) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.primerak = primerak;
		this.zaposleni = zaposleni;
		this.clan = clan;
	}
	public IzdavanjeKnjige() {
		super();
		this.datumIznajmljivanja = null;
		this.datumVracanja = null;
		this.primerak = new PrimerakKnjige();
		this.zaposleni = new Zaposleni();
		this.clan = new ClanBiblioteke();
	}
	@Override
	public String toString() {
		return "IzdavanjeKnjige [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", primerak=" + primerak + ", zaposleni=" + zaposleni + ", clan=" + clan + "]";
	}


	


}