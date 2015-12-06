package com.journaldev.spring.model;

public class Schedule {

	private String uuid;
	
	private String date;
	
	private String heureDebut;
	
	private String minuteDebut;
	
	private String idPresentation;
	
	
	private String idSalle;
	
	

	private Local local = new Local();
	
	private Presentation conference = new Presentation();
	
	private String statut;

	/**
	 * @return the idPresentation
	 */
	public String getIdPresentation() {
		return idPresentation;
	}

	/**
	 * @param idPresentation the idPresentation to set
	 */
	public void setIdPresentation(String idPresentation) {
		this.idPresentation = idPresentation;
	}

	
	/**
	 * @return the idSalle
	 */
	public String getIdSalle() {
		return idSalle;
	}

	/**
	 * @param idSalle the idSalle to set
	 */
	public void setIdSalle(String idSalle) {
		this.idSalle = idSalle;
	}
	
	
	
	/**
	 * @param uuid
	 * @param date
	 * @param heureDebut
	 * @param minuteDebut
	 * @param idPresentation
	 * @param idSalle
	 * @param local
	 * @param conference
	 * @param statut
	 */
	public Schedule(String uuid, String date, String heureDebut, String minuteDebut, String idPresentation,
			String idSalle, Local local, Presentation conference, String statut) {
		super();
		this.uuid = uuid;
		this.date = date;
		this.heureDebut = heureDebut;
		this.minuteDebut = minuteDebut;
		this.idPresentation = idPresentation;
		this.idSalle = idSalle;
		this.local = local;
		this.conference = conference;
		this.statut = statut;
	}
	

	/**
	 * 
	 */
	public Schedule() {
		super();
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

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the heureDebut
	 */
	public String getHeureDebut() {
		return heureDebut;
	}

	/**
	 * @param heureDebut the heureDebut to set
	 */
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	/**
	 * @return the minuteDebut
	 */
	public String getMinuteDebut() {
		return minuteDebut;
	}

	/**
	 * @param minuteDebut the minuteDebut to set
	 */
	public void setMinuteDebut(String minuteDebut) {
		this.minuteDebut = minuteDebut;
	}

	/**
	 * @return the local
	 */
	public Local getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(Local local) {
		this.local = local;
	}

	/**
	 * @return the conference
	 */
	public Presentation getConference() {
		return conference;
	}

	/**
	 * @param conference the conference to set
	 */
	public void setConference(Presentation conference) {
		this.conference = conference;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "horaie [uuid=" + uuid + ", date=" + date + ", heureDebut=" + heureDebut + ", minuteDebut="
				+ minuteDebut + ", idPresentation=" + idPresentation + ", idSalle=" + idSalle + ", local=" + local
				+ ", conference=" + conference + ", statut=" + statut + "]";
	}
	
}
