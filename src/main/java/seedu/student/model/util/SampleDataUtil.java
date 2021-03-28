package seedu.student.model.util;

import java.time.LocalDate;
import java.time.LocalTime;

import seedu.student.model.ReadOnlyStudentBook;
import seedu.student.model.StudentBook;
import seedu.student.model.appointment.Appointment;
import seedu.student.model.student.Address;
import seedu.student.model.student.Email;
import seedu.student.model.student.Faculty;
import seedu.student.model.student.MatriculationNumber;
import seedu.student.model.student.MedicalDetails;
import seedu.student.model.student.Name;
import seedu.student.model.student.Phone;
import seedu.student.model.student.SchoolResidence;
import seedu.student.model.student.Student;
import seedu.student.model.student.VaccinationStatus;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static Student[] getSampleStudents() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new MatriculationNumber("A0182345T"), new Faculty("COM"),
                    new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new Address("Blk 30 Geylang Street 29, #06-40"), new VaccinationStatus("vaccinated"),
                    new MedicalDetails("none"), new SchoolResidence("PGPH")),
            new Student(new Name("Bernice Yu"), new MatriculationNumber("A0175678U"), new Faculty("COM"),
                    new Phone("99272758"), new Email("berniceyu@example.com"),
                    new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    new VaccinationStatus("not vaccinated"), new MedicalDetails("shellfish allergy"),
                    new SchoolResidence("PGPH")),
            new Student(new Name("Charlotte Oliveiro"), new MatriculationNumber("A0164567V"), new Faculty("COM"),
                    new Phone("93210283"), new Email("charlotte@example.com"),
                    new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new VaccinationStatus("vaccinated"),
                    new MedicalDetails("none"), new SchoolResidence("PGPH")),
            new Student(new Name("David Li"), new MatriculationNumber("A0209875D"), new Faculty("COM"),
                    new Phone("91031282"), new Email("lidavid@example.com"),
                    new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new VaccinationStatus("not vaccinated"),
                    new MedicalDetails("history of anaphylaxis"), new SchoolResidence("PGPH")),
            new Student(new Name("Irfan Ibrahim"), new MatriculationNumber("A0214432E"), new Faculty("COM"),
                    new Phone("92492021"), new Email("irfan@example.com"),
                    new Address("Blk 47 Tampines Street 20, #17-35"), new VaccinationStatus("vaccinated"),
                    new MedicalDetails("none"), new SchoolResidence("PGPH")),
            new Student(new Name("Roy Balakrishnan"), new MatriculationNumber("A0221234N"), new Faculty("COM"),
                    new Phone("92624417"), new Email("royb@example.com"),
                    new Address("Blk 45 Aljunied Street 85, #11-31"), new VaccinationStatus("not vaccinated"),
                    new MedicalDetails("penicillin allergy"), new SchoolResidence("PGPH"))
        };
    }

    public static Appointment[] getSampleAppointments() {
        return new Appointment[] {
            new Appointment(new MatriculationNumber("A0182345T"), LocalDate.parse("2021-01-01"),
                    LocalTime.parse("10:00"), LocalTime.parse("10:30"))
        };
    }

    public static ReadOnlyStudentBook getSampleStudentBook() {
        StudentBook sampleAb = new StudentBook();
        for (Student sampleStudent : getSampleStudents()) {
            sampleAb.addStudent(sampleStudent);
        }
        for (Appointment sampleAppointment : getSampleAppointments()) {
            sampleAb.addAppointment(sampleAppointment);
        }
        return sampleAb;
    }
}