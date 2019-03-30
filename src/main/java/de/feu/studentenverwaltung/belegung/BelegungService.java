package de.feu.studentenverwaltung.belegung;

import de.feu.studentenverwaltung.kurs.Kurs;
import de.feu.studentenverwaltung.student.Student;

public interface BelegungService {

	void belegeKurs(Student student, Kurs kurs);

}
