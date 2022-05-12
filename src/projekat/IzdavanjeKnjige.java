package projekat;

import java.time.LocalDate;


public class IzdavanjeKnjige {


    protected LocalDate datumIznajmljivanja;

    protected LocalDate datumVracanja;
    
    protected Zaposleni zaposleni;
    
    protected ClanBiblioteke clan;
    
    protected PrimerakKnjige primerak;

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

	public PrimerakKnjige getPrimerak() {
		return primerak;
	}

	public void setPrimerak(PrimerakKnjige primerak) {
		this.primerak = primerak;
	}

	public IzdavanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
			ClanBiblioteke clan, PrimerakKnjige primerak) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerak = primerak;
	}



	public IzdavanjeKnjige() {
		super();
		this.datumIznajmljivanja = null;
		this.datumVracanja = null;
		this.zaposleni = new Zaposleni();
		this.clan = new ClanBiblioteke();
		this.primerak = new PrimerakKnjige();
	}

	@Override
	public String toString() {
		return "IzdavanjeKnjige [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", zaposleni=" + zaposleni + ", clan=" + clan + ", primerak=" + primerak + "]";
	}





}