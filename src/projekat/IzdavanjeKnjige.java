package projekat;

import java.time.LocalDate;

public class IzdavanjeKnjige {


    protected LocalDate datumIznajmljivanja;
    protected LocalDate datumVracanja;
    protected PrimerakKnjige primerak;
    protected Zaposleni zaposleni;
    protected ClanBiblioteke clan;
    protected boolean obrisan;
	public IzdavanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja, PrimerakKnjige primerak,
			Zaposleni zaposleni, ClanBiblioteke clan, boolean obrisan) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.primerak = primerak;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.obrisan = obrisan;
	}
	

	public IzdavanjeKnjige(LocalDate datum, LocalDate datum2, Zaposleni zaposleni2, ClanBiblioteke clan2,
			PrimerakKnjige primerak2) {
		// TODO Auto-generated constructor stub
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
	public boolean isObrisan() {
		return obrisan;
	}
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	@Override
	public String toString() {
		return "IzdavanjeKnjige [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", primerak=" + primerak + ", zaposleni=" + zaposleni + ", clan=" + clan + ", obrisan=" + obrisan
				+ "]";
	}
    



}