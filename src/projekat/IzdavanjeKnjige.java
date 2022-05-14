package projekat;

import java.time.LocalDate;

public class IzdavanjeKnjige {


    protected LocalDate datumIznajmljivanja;
    protected LocalDate datumVracanja;
    protected PrimerakKnjige primerak;
    protected Bibliotekar bibliotekar;
    protected ClanBiblioteke clan;
	public IzdavanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja, PrimerakKnjige primerak,
			Bibliotekar bibliotekar, ClanBiblioteke clan) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.primerak = primerak;
		this.bibliotekar = bibliotekar;
		this.clan = clan;
	}
	public IzdavanjeKnjige() {
		super();
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
	public Bibliotekar getBibliotekar() {
		return bibliotekar;
	}
	public void setBibliotekar(Bibliotekar bibliotekar) {
		this.bibliotekar = bibliotekar;
	}
	public ClanBiblioteke getClan() {
		return clan;
	}
	public void setClan(ClanBiblioteke clan) {
		this.clan = clan;
	}
	@Override
	public String toString() {
		return "IzdavanjeKnjige [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", primerak=" + primerak + ", bibliotekar=" + bibliotekar + ", clan=" + clan + "]";
	}
    


	


}