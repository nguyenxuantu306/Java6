package com.poly.bean;

import java.io.Serializable;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "roles")
public class Role  implements Serializable{
	@Id
	private String Id;
	private String Name;
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Account_roles> accountroles;
}