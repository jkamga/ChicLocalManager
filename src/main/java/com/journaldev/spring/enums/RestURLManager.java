package com.journaldev.spring.enums;

public enum RestURLManager {
	

	GET_SCHEDULE_LIST_URL("http://104.197.34.24:5000/SCSproject/api/gethoraire"),
	ADD_SCHEDULE("http://104.197.34.24:5000/SCSproject/api/sethoraire"),
	UPDATE_SCHEDULE("http://104.197.34.24:5000/SCSproject/api/updatehoraire"),
	DELETE_SCHEDULE("http://104.197.34.24:5000/SCSproject/api/detelehoraire"),
	
	//local end points
	GET_LOCAL_LIST("http://104.197.34.24:5000/SCSproject/api/getsalle"),
	GET_LOCAL_BY_ID_URL("http://104.197.34.24:5000/SCSproject/api/getsalleid/"),
	ADD_LOCAL("http://104.197.34.24:5000/SCSproject/api/setsalle"),
	UPDATE_LOCAL("http://104.197.34.24:5000/SCSproject/api/updatesalle"),
	DELETE_LOCAL("http://104.197.34.24:5000/SCSproject/api/deletesalle"),
		
		
	//building end points
	GET_BUILDING_LIST_URL("http://104.197.34.24:5000/SCSproject/api/getbatiment"),
	GET_BUILDING_BY_ID_URL("http://104.197.34.24:5000/SCSproject/api/getbatimentid/"),
	ADD_BUILDING("http://104.197.34.24:5000/SCSproject/api/setbatiment"),
	UPDATE_BUILDING("http://104.197.34.24:5000/SCSproject/api/updatebatiment"),
	DELETE_BUILDING("http://104.197.34.24:5000/SCSproject/api/deletebatiment"),
		
    //user
	GET_USER_LIST_URL("http://104.197.34.24:5000/SCSproject/api/getuser"),
	GET_USERBY_ID_URL("http://104.197.34.24:5000/SCSproject/api/getuserid/"),
	POST_USER_URL("http://104.197.34.24:5000/SCSproject/api/setuser"),
	UPDATE_USER("http://104.197.34.24:5000/SCSproject/api/updateuser"),
	
	//Presentation
	GET_PRESENTATION_LIST("http://104.197.34.24:5000/SCSproject/api/getpresentation"),
	GET_PRESENTATION_BY_IDT("http://104.197.34.24:5000/SCSproject/api/getpresentationid"),
	ADD_PRESENTATION("http://104.197.34.24:5000/SCSproject/api/setpresentation"),
	UPDATE_PRESENTATION("http://104.197.34.24:5000/SCSproject/api/updatepresentation"),
	DELETE_PRESENTATION("http://104.197.34.24:5000/SCSproject/api/detelepresentation"),
	
		
	;
	
	/**
	 * 
	 */
	private String URLValue;
    
	/**
	 * 
	 * @param uRLValue
	 */
	private RestURLManager(String uRLValue) {
		URLValue = uRLValue;
	}

	/**
	 * @return the uRLValue
	 */
	public String getURLValue() {
		return URLValue;
	}

	/**
	 * @param uRLValue the uRLValue to set
	 */
	public void setURLValue(String uRLValue) {
		URLValue = uRLValue;
	}
	
	}
