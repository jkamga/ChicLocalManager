package com.journaldev.spring.model;

public class Presentation {
	
	private String uuid;
	
	private String titre;
	
	private String nombreParticipants;
	
	private String equipement;
	
	private String dureeHeure;
	
	private String dureeMinute;
	
	private String presentateur;

	

	/**
	 * @param uuid
	 * @param titre
	 * @param nombreParticipants
	 * @param equipement
	 * @param dureeHeure
	 * @param dureeMinute
	 * @param presentateur
	 */
	public Presentation(String uuid, String titre, String nombreParticipants, String equipement, String dureeHeure,
			String dureeMinute, String presentateur) {
		super();
		this.uuid = uuid;
		this.titre = titre;
		this.nombreParticipants = nombreParticipants;
		this.equipement = equipement;
		this.dureeHeure = dureeHeure;
		this.dureeMinute = dureeMinute;
		this.presentateur = presentateur;
	}

	/**
	 * 
	 */
	public Presentation() {
		super();
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the nombreParticipants
	 */
	public String getNombreParticipants() {
		return nombreParticipants;
	}

	/**
	 * @param nombreParticipants the nombreParticipants to set
	 */
	public void setNombreParticipants(String nombreParticipants) {
		this.nombreParticipants = nombreParticipants;
	}

	/**
	 * @return the equipement
	 */
	public String getEquipement() {
		return equipement;
	}

	/**
	 * @param equipement the equipement to set
	 */
	public void setEquipement(String equipement) {
		this.equipement = equipement;
	}

	/**
	 * @return the dureeHeure
	 */
	public String getDureeHeure() {
		return dureeHeure;
	}

	/**
	 * @param dureeHeure the dureeHeure to set
	 */
	public void setDureeHeure(String dureeHeure) {
		this.dureeHeure = dureeHeure;
	}

	/**
	 * @return the dureeMinute
	 */
	public String getDureeMinute() {
		return dureeMinute;
	}

	/**
	 * @param dureeMinute the dureeMinute to set
	 */
	public void setDureeMinute(String dureeMinute) {
		this.dureeMinute = dureeMinute;
	}

	/**
	 * @return the presentateur
	 */
	public String getPresentateur() {
		return presentateur;
	}

	/**
	 * @param presentateur the presentateur to set
	 */
	public void setPresentateur(String presentateur) {
		this.presentateur = presentateur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "presentation [uuid=" + uuid + ", titre=" + titre + ", nombreParticipants=" + nombreParticipants
				+ ", equipement=" + equipement + ", dureeHeure=" + dureeHeure + ", dureeMinute=" + dureeMinute
				+ ", presentateur=" + presentateur + "]";
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	
}
