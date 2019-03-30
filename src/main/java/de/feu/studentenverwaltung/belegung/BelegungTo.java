package de.feu.studentenverwaltung.belegung;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BelegungTo {

	private Long id;

	private int version;

	private String student;
	private String kurs;

	public BelegungTo(String student, String kurs) {
		super();
		this.student = student;
		this.kurs = kurs;
	}

}
