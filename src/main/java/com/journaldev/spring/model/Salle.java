package com.journaldev.spring.model;

public class Salle {
	
	private String capacite;
	
	private String equipement;
	
	private String etage;
	
	private String numero;
	
	private String statut;
	
	private String description;
	
	
	
	public Salle() {
		super();
	}

	public Salle(String capacite, String equipement, String etage, String numero, String statut, String description) {
		super();
		this.capacite = capacite;
		this.equipement = equipement;
		this.etage = etage;
		this.numero = numero;
		this.statut = statut;
		this.description = description;
	}

	/**
	 * @return the capacite
	 */
	public String getCapacite() {
		return capacite;
	}

	/**
	 * @param capacite the capacite to set
	 */
	public void setCapacite(String capacite) {
		this.capacite = capacite;
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
	 * @return the etage
	 */
	public String getEtage() {
		return etage;
	}

	/**
	 * @param etage the etage to set
	 */
	public void setEtage(String etage) {
		this.etage = etage;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "salle [capacite=" + capacite + ", equipement=" + equipement + ", etage=" + etage + ", numero=" + numero
				+ ", statut=" + statut + ", description=" + description + "]";
	}



}
