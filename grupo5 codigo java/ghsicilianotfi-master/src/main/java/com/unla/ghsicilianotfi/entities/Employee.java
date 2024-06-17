package com.unla.ghsicilianotfi.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
public class Employee extends Person {

	public Employee() {
		super();
	}

	private String workFile;
}