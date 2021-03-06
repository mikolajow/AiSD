package pakiet_1;

import java.util.ArrayList;

public class trasa {
	
	private int liczbaPrzesiadek;
	private int dlugoscTrasy;
	private String poczatek;
	private String aktualnaTrasa;
	private ArrayList<String> stacje;
	
	public trasa(String p) {
		this.stacje = new ArrayList<>();
		this.liczbaPrzesiadek = 0;
		this.dlugoscTrasy = 0;
		this.poczatek = p;
		this.aktualnaTrasa = p;
	}//koniec konstruktora
	
	public trasa(trasa t) {
		this.stacje = new ArrayList<>();
		for ( String s : t.getStacje() ) {
			this.stacje.add(s);
		}//koniec for
		this.liczbaPrzesiadek = t.getLiczbaPrzesiadek();
		this.dlugoscTrasy = t.getDlugoscTrasy();
		this.poczatek = t.getPoczatek();
		this.aktualnaTrasa = t.getAktualnaTrasa();
	}//koniec kopiujacego
	
	
	// GETTERY I SETTERY

	public ArrayList<String> getStacje() {
		return stacje;
	}

	public void setStacje(ArrayList<String> stacje) {
		this.stacje = stacje;
	}

	public int getLiczbaPrzesiadek() {
		return liczbaPrzesiadek;
	}

	public void setLiczbaPrzesiadek(int liczbaPrzesiadek) {
		this.liczbaPrzesiadek = liczbaPrzesiadek;
	}

	public int getDlugoscTrasy() {
		return dlugoscTrasy;
	}

	public void setDlugoscTrasy(int dlugoscTrasy) {
		this.dlugoscTrasy = dlugoscTrasy;
	}

	public String getPoczatek() {
		return poczatek;
	}

	public void setPoczatek(String poczatek) {
		this.poczatek = poczatek;
	}

	public String getAktualnaTrasa() {
		return aktualnaTrasa;
	}

	public void setAktualnaTrasa(String aktualnaTrasa) {
		this.aktualnaTrasa = aktualnaTrasa;
	}
	
	
}//koniec klasy


















