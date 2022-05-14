package projekat;

import java.time.LocalDate;

public class ClanBiblioteke extends Osoba {

    protected String brojClanskeKarte;

    protected LocalDate datumPoslUplate;

    protected int brojMeseciClan;

    protected boolean aktivan;
    
    protected Tip tip;






	public ClanBiblioteke(String id, String ime, String prezime, String jmbg, String adresa, Pol pol,
			String brojClanskeKarte, LocalDate datumPoslUplate, int brojMeseciClan, boolean aktivan, Tip tip) {
		super(id, ime, prezime, jmbg, adresa, pol);
		this.brojClanskeKarte = brojClanskeKarte;
		this.datumPoslUplate = datumPoslUplate;
		this.brojMeseciClan = brojMeseciClan;
		this.aktivan = aktivan;
		this.tip = tip;
	}




	public ClanBiblioteke() {
		super();
		this.brojClanskeKarte="";
		this.datumPoslUplate=LocalDate.of(0,0,0);
		this.aktivan=true;
		this.brojMeseciClan=0;
		this.tip = new Tip();
	}




	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}



	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}



	public LocalDate getDatumPoslUplate() {
		return datumPoslUplate;
	}



	public void setDatumPoslUplate(LocalDate datumPoslUplate) {
		this.datumPoslUplate = datumPoslUplate;
	}



	public int getBrojMeseciClan() {
		return brojMeseciClan;
	}



	public void setBrojMeseciClan(int brojMeseciClan) {
		this.brojMeseciClan = brojMeseciClan;
	}



	public boolean isAktivan() {
		return aktivan;
	}



	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}



	public Tip getTip() {
		return tip;
	}



	public void setTip(Tip tip) {
		this.tip = tip;
	}



	@Override
	public String toString() {
		return "ClanBiblioteke [brojClanskeKarte=" + brojClanskeKarte + ", datumPoslUplate=" + datumPoslUplate
				+ ", brojMeseciClan=" + brojMeseciClan + ", aktivan=" + aktivan + ", tip=" + tip + ", id=" + id
				+ ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol=" + pol
				+ "]";
	}






	

}