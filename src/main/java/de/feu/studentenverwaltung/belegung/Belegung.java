package de.feu.studentenverwaltung.belegung;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import de.feu.studentenverwaltung.kurs.Kurs;
import de.feu.studentenverwaltung.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity
public class Belegung {

	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
	@ManyToOne(fetch = FetchType.LAZY)
	private Kurs kurs;

	public Belegung(Student student, Kurs kurs) {
		super();
		this.student = student;
		this.kurs = kurs;
	}

}
