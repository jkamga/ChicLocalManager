package com.journaldev.spring.model;


public class University {
	
	        private String uuid;
		
			private String status ;
			
			private String capacity ;
			
			private String description ;

			private Address address = new Address();

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
			 * @return the status
			 */
			public String getStatus() {
				return status;
			}

			/**
			 * @param status the status to set
			 */
			public void setStatus(String status) {
				this.status = status;
			}

			/**
			 * @return the capacity
			 */
			public String getCapacity() {
				return capacity;
			}

			/**
			 * @param capacity the capacity to set
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
			 * @param description the description to set
			 */
			public void setDescription(String description) {
				this.description = description;
			}

			/**
			 * @return the address
			 */
			public Address getAddress() {
				return address;
			}

			/**
			 * @param address the address to set
			 */
			public void setAddress(Address address) {
				this.address = address;
			}

}
