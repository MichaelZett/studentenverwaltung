package de.feu.studentenverwaltung.belegung;

import org.springframework.stereotype.Service;

import de.feu.studentenverwaltung.kurs.Kurs;
import de.feu.studentenverwaltung.kurs.KursRepository;
import de.feu.studentenverwaltung.student.Student;
import de.feu.studentenverwaltung.student.StudentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BelegungServiceImpl implements BelegungService {
	private final StudentRepository studentRepository;
	private final KursRepository kursRepository;

	@Override
	public void belegeKurs(Student student, Kurs kurs) {
		// TODO Auto-generated method stub

	}

}
