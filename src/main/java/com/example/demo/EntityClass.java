package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "UserDetails")
	public class EntityClass {

		@Id
		@Column
		private Long id;
		@Column
		private String firstname;
		@Column
		private String lastname;
		@Column
		private String age;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "EntityClass [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
					+ "]";
		}
		
		
}
