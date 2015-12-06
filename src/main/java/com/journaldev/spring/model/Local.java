package com.journaldev.spring.model;

import java.io.Serializable;

public class Local implements Serializable {

	private String uuid;

	private String localId;

	private String capacity;

	private String description;

	private String floor;

	private String buildingId;

	private String numeroSalle;

	private String materials;

	private String status;

	public Local() {

	}

	public Local(String localId, String capacity, String description, String floor, String buildingId,
			String numeroSalle) {
		super();
		this.localId = localId;
		this.capacity = capacity;
		this.description = description;
		this.floor = floor;
		this.buildingId = buildingId;
		this.numeroSalle = numeroSalle;
	}

	/**
	 * @return the localId
	 */
	public String getLocalId() {
		return localId;
	}

	/**
	 * @param localId
	 *            the localId to set
	 */
	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public int compareTo(Object o) {
		if (o instanceof Local) {
			if (this.getLocalId() != null) {
				if (this.getLocalId().equals(((Local) o).getLocalId())) {
					return 0;
				}
			}

		}
		return -1;

	}

	/**
	 * @return the capacity
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity
	 *            the capacity to set
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the floor
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * @param floor
	 *            the floor to set
	 */
	public void setFloor(String floor) {
		this.floor = floor;
	}

	/**
	 * @return the buildingId
	 */
	public String getBuildingId() {
		return buildingId;
	}

	/**
	 * @param buildingId
	 *            the buildingId to set
	 */
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * @return the numeroSalle
	 */
	public String getNumeroSalle() {
		return numeroSalle;
	}

	/**
	 * @param numeroSalle
	 *            the numeroSalle to set
	 */
	public void setNumeroSalle(String numeroSalle) {
		this.numeroSalle = numeroSalle;
	}

	/**
	 * @return the materials
	 */
	public String getMaterials() {
		return materials;
	}

	/**
	 * @param materials
	 *            the materials to set
	 */
	public void setMaterials(String materials) {
		this.materials = materials;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "salle [uuid=" + uuid + ", localId=" + localId + ", capacity=" + capacity + ", description="
				+ description + ", floor=" + floor + ", buildingId=" + buildingId + ", numeroSalle=" + numeroSalle
				+ ", materials=" + materials + ", status=" + status + "]";
	}

}
