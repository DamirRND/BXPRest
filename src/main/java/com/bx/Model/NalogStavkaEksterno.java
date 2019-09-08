package com.bx.Model;

public class NalogStavkaEksterno {

	private String kolicina;
	private String vrednost;
	private String robasifraext;
	private String robanazivext;
	private String kupacsifraext;
	private String kupacnazivext;
	
	public NalogStavkaEksterno() {
	}

	
	public NalogStavkaEksterno(String kolicina, String vrednost, String robasifraext, String robanazivext,
			String kupacsifraext, String kupacnazivext) {
		super();
		this.kolicina = kolicina;
		this.vrednost = vrednost;
		this.robasifraext = robasifraext;
		this.robanazivext = robanazivext;
		this.kupacsifraext = kupacsifraext;
		this.kupacnazivext = kupacnazivext;
	}


	public String getKolicina() {
		return kolicina;
	}

	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}

	public String getRobasifraext() {
		return robasifraext;
	}

	public void setRobasifraext(String robasifraext) {
		this.robasifraext = robasifraext;
	}

	public String getRobanazivext() {
		return robanazivext;
	}

	public void setRobanazivext(String robanazivext) {
		this.robanazivext = robanazivext;
	}

	public String getKupacsifraext() {
		return kupacsifraext;
	}

	public void setKupacsifraext(String kupacsifraext) {
		this.kupacsifraext = kupacsifraext;
	}

	public String getKupacnazivext() {
		return kupacnazivext;
	}

	public void setKupacnazivext(String kupacnazivext) {
		this.kupacnazivext = kupacnazivext;
	}
	
	
}
