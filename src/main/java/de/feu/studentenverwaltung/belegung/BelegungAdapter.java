package de.feu.studentenverwaltung.belegung;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.feu.studentenverwaltung.kurs.Kurs;
import de.feu.studentenverwaltung.kurs.KursRepository;
import de.feu.studentenverwaltung.student.Student;
import de.feu.studentenverwaltung.student.StudentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Transactional
public class BelegungAdapter {
	private final StudentRepository studentRepository;
	private final KursRepository kursRepository;
	private final BelegungRepository belegungRepository;

	@PostConstruct
	public void setup() {
		Student student = new Student("1234", "Michael", "Student", LocalDate.of(1990, 2, 1));
		student = studentRepository.save(student);
		Kurs kurs = new Kurs("Java");
		kurs = kursRepository.save(kurs);
		Belegung belegung = new Belegung(student, kurs);
		belegungRepository.save(belegung);
	}

	@GetMapping("/belegung")
	public List<BelegungTo> belegung() {
		return belegungRepository.findAll().parallelStream().map(s -> createTo(s)).collect(Collectors.toList());
	}

	private BelegungTo createTo(Belegung s) {
		return new BelegungTo(s.getId(), s.getVersion(), s.getStudent().getMatrikelnummer(), s.getKurs().getName());
	}
}
