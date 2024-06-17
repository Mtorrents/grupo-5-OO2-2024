package com.unla.ghsicilianotfi.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
public class Client extends Person {

	

	public Client() {
		super();
	}

	private String mail;
}
