package de.feu.studentenverwaltung.belegung;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import de.feu.studentenverwaltung.kurs.Kurs;
import de.feu.studentenverwaltung.kurs.KursRepository;
import de.feu.studentenverwaltung.student.Student;
import de.feu.studentenverwaltung.student.StudentRepository;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class BelegungAdapterTest {
	@Mock
	private StudentRepository studentRepository;
	@Mock
	private KursRepository kursRepository;
	@Mock
	private BelegungRepository belegungRepository;

	@InjectMocks
	private BelegungAdapter testee;

	@Test
	public void shouldGetBelegungen() {
		// Given
		List<Belegung> list = new ArrayList<>();
		list.add(createBelegung());
		when(belegungRepository.findAll()).thenReturn(list);

		// when
		List<BelegungTo> belegungen = testee.belegung();

		// then
		assertThat(belegungen).hasSize(1);
		BelegungTo belegungTo = belegungen.get(0);
		assertThat(belegungTo.getKurs()).isEqualTo("Java");
	}

	private Belegung createBelegung() {
		Student student = new Student("1234", "Michael", "Student", LocalDate.of(1990, 2, 1));
		Kurs kurs = new Kurs("Java");
		Belegung belegung = new Belegung(student, kurs);
		return belegung;
	}

}
