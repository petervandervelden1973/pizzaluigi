package be.vdab.entities;

public class Persoon {
	private String voornaam;
	private String familienaam;
	private int aantalKinderen;
	private boolean gehuwd;
	
	public String getVoornaam() {
		return voornaam;
	}
		
	public String getFamilienaam() {
		return familienaam;
	}
	
	public int getAantalKinderen() {
		return aantalKinderen;
	}
	
	public boolean isGehuwd() {
		return gehuwd;
	}
}
