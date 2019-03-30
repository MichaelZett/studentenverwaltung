package de.feu.studentenverwaltung.kurs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity
public class Kurs {

	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	private String name;

	public Kurs(String name) {
		super();
		this.name = name;
	}

}
