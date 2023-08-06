package com.poly.bean;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Accounts")
public class Account implements Serializable {

	@Id
	String Id;
	String username;
	String Password;
	String Fullname;
	String Email;
	String Photo;
	Boolean Gender;
	String Address;
	String Phone;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date")
	Date date = new Date();

//	@JsonIgnore
//	@OneToMany(mappedBy = "account")
//	List<Orders> orders;

	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Account_roles> accountroles;
}
