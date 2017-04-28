package be.vdab.entities;

public class Persoon {
	private String voornaam;
	private String familienaam;
	private int aantalKinderen;
	private boolean gehuwd;
	
	public Persoon() {
			}

	public Persoon(String voornaam, String familienaam, int aantalKinderen, boolean gehuwd) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.aantalKinderen = aantalKinderen;
		this.gehuwd = gehuwd;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}
	public int getAantalKinderen() {
		return aantalKinderen;
	}
	public void setAantalKinderen(int aantalKinderen) {
		this.aantalKinderen = aantalKinderen;
	}
	public boolean isGehuwd() {
		return gehuwd;
	}
	public void setGehuwd(boolean gehuwd) {
		this.gehuwd = gehuwd;
	}
}
