package com.poly.bean;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report implements Serializable {
	private static final long serialVersionUID = -5885342208000278840L;
	@Id
	Serializable group;
	Double sum;
	Long count;
}
