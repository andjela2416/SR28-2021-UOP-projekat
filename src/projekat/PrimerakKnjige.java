package projekat;

public class PrimerakKnjige {


    protected String id;

    protected int brojStrana;

    protected boolean mekPovez;

    protected int godinaStampanja;

    protected String jezikStampanja;

    protected boolean iznajmljena;
    
    protected Knjiga knjiga;
    




	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public boolean isMekPovez() {
		return mekPovez;
	}

	public void setMekPovez(boolean mekPovez) {
		this.mekPovez = mekPovez;
	}

	public int getGodinaStampanja() {
		return godinaStampanja;
	}

	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}

	public String getJezikStampanja() {
		return jezikStampanja;
	}

	public void setJezikStampanja(String jezikStampanja) {
		this.jezikStampanja = jezikStampanja;
	}

	public boolean isIznajmljena() {
		return iznajmljena;
	}

	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public PrimerakKnjige(String id, int brojStrana, boolean mekPovez, int godinaStampanja, String jezikStampanja,
			boolean iznajmljena, Knjiga knjiga) {
		super();
		this.id = id;
		this.brojStrana = brojStrana;
		this.mekPovez = mekPovez;
		this.godinaStampanja = godinaStampanja;
		this.jezikStampanja = jezikStampanja;
		this.iznajmljena = iznajmljena;
		this.knjiga = knjiga;
	}

	public PrimerakKnjige() {
		super();
		this.id = "";
		this.brojStrana =0;
		this.mekPovez = true;
		this.godinaStampanja = 0;
		this.jezikStampanja = "";
		this.iznajmljena = true;
		this.knjiga= new Knjiga();
	}

	@Override
	public String toString() {
		return "PrimerakKnjige [id=" + id + ", brojStrana=" + brojStrana + ", mekPovez=" + mekPovez
				+ ", godinaStampanja=" + godinaStampanja + ", jezikStampanja=" + jezikStampanja + ", iznajmljena="
				+ iznajmljena + ", knjiga=" + knjiga + "]";
	}



}