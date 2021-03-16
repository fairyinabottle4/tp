package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.FacultyContainsKeywords;
import seedu.address.model.person.SchoolResidenceContainsKeywords;
import seedu.address.model.person.VaccinationStatusContainsKeywords;


/**
 * Contains integration tests (interaction with the Model) for {@code FilterCommand}.
 */
public class FilterCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        VaccinationStatusContainsKeywords vaccinationPredicate =
                new VaccinationStatusContainsKeywords("vaccinated");
        FacultyContainsKeywords facultyPredicate =
                new FacultyContainsKeywords("COM");
        SchoolResidenceContainsKeywords schoolResidencePredicate =
                new SchoolResidenceContainsKeywords("RVRC");

        FilterCommand findByVaccinationStatus = new FilterCommand(vaccinationPredicate);
        FilterCommand findByFaculty = new FilterCommand(facultyPredicate);
        FilterCommand findBySchoolResidence = new FilterCommand(schoolResidencePredicate);

        // same object -> returns true
        assertTrue(findByVaccinationStatus.equals(findByVaccinationStatus));

        // same values -> returns true
        FilterCommand findByVaccinationStatusCopy = new FilterCommand(vaccinationPredicate);
        assertTrue(findByVaccinationStatus.equals(findByVaccinationStatusCopy));

        // different types -> returns false
        assertFalse(findByVaccinationStatus.equals(1));

        // null -> returns false
        assertFalse(findByVaccinationStatus.equals(null));

        // different person -> returns false
        assertFalse(findByVaccinationStatus.equals(findByFaculty));

        // same object -> returns true
        assertTrue(findByFaculty.equals(findByFaculty));

        // same values -> returns true
        FilterCommand findByFacultyCopy = new FilterCommand(facultyPredicate);
        assertTrue(findByFaculty.equals(findByFacultyCopy));

        // different types -> returns false
        assertFalse(findByFaculty.equals(1));

        // null -> returns false
        assertFalse(findByFaculty.equals(null));

        // different person -> returns false
        assertFalse(findByFaculty.equals(findBySchoolResidence));

        // same object -> returns true
        assertTrue(findBySchoolResidence.equals(findBySchoolResidence));

        // same values -> returns true
        FilterCommand findBySchoolResidenceCopy = new FilterCommand(schoolResidencePredicate);
        assertTrue(findBySchoolResidence.equals(findBySchoolResidenceCopy));

        // different types -> returns false
        assertFalse(findBySchoolResidence.equals(1));

        // null -> returns false
        assertFalse(findBySchoolResidence.equals(null));

        // different person -> returns false
        assertFalse(findBySchoolResidence.equals(findByFaculty));

    }

    @Test
    public void execute_zeroKeywords_noPersonFoundFilterByVaccinationStatus() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        VaccinationStatusContainsKeywords vaccinationPredicate = new VaccinationStatusContainsKeywords("");
        FilterCommand command = new FilterCommand(vaccinationPredicate);
        expectedModel.updateFilteredPersonList(vaccinationPredicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_zeroKeywords_noPersonFoundFilterByFaculty() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        FacultyContainsKeywords facultyPredicate = new FacultyContainsKeywords("");
        FilterCommand command = new FilterCommand(facultyPredicate);
        expectedModel.updateFilteredPersonList(facultyPredicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_zeroKeywords_noPersonFoundFilterBySchoolResidence() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        SchoolResidenceContainsKeywords schoolResidencePredicate = new SchoolResidenceContainsKeywords("");
        FilterCommand command = new FilterCommand(schoolResidencePredicate);
        expectedModel.updateFilteredPersonList(schoolResidencePredicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }
}