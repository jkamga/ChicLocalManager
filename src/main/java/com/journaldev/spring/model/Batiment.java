package com.journaldev.spring.model;

public class Batiment {
	
	private String nom;
	
	private String adresse;
	
	private String faculte;
	
	private String campus;
	
	private String universite;

	/**
	 * @param nom
	 * @param addresse
	 * @param faculte
	 * @param campus
	 * @param universite
	 */
	public Batiment(String nom, String addresse, String faculte, String campus, String universite) {
		super();
		this.nom = nom;
		this.adresse = addresse;
		this.faculte = faculte;
		this.campus = campus;
		this.universite = universite;
	}

	/**
	 * 
	 */
	public Batiment() {
		super();
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the addresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param addresse the addresse to set
	 */
	public void setAdresse(String addresse) {
		this.adresse = addresse;
	}

	/**
	 * @return the faculte
	 */
	public String getFaculte() {
		return faculte;
	}

	/**
	 * @param faculte the faculte to set
	 */
	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}

	/**
	 * @return the campus
	 */
	public String getCampus() {
		return campus;
	}

	/**
	 * @param campus the campus to set
	 */
	public void setCampus(String campus) {
		this.campus = campus;
	}

	/**
	 * @return the universite
	 */
	public String getUniversite() {
		return universite;
	}

	/**
	 * @param universite the universite to set
	 */
	public void setUniversite(String universite) {
		this.universite = universite;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Batiment [nom=" + nom + ", addresse=" + adresse + ", faculte=" + faculte + ", campus=" + campus
				+ ", universite=" + universite + "]";
	}
	
	

}
