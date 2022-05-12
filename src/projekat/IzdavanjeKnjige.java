package projekat;

import java.time.LocalDate;

public class IzdavanjeKnjige {


    protected LocalDate datumIznajmljivanja;

    protected LocalDate datumVracanja;


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

	public IzdavanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
	}

	public IzdavanjeKnjige() {
		super();
		this.datumIznajmljivanja= LocalDate.of(0,0,0);
		this.datumVracanja=LocalDate.of(0,0,0);
		
	}

	@Override
	public String toString() {
		return "IzdavanjeKnjige [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja + "]";
	}



}