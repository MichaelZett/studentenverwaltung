package de.feu.studentenverwaltung.student;

import java.time.LocalDate;

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
public class Student {
	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	private String matrikelnummer;
	private String vorname;
	private String nachname;
	private LocalDate geburtstag;

	public Student(String matrikelnummer, String vorname, String nachname, LocalDate geburtstag) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtstag = geburtstag;
	}

}
