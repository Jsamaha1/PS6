package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import domain.PersonDomainModel;
import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.text.ParseException;

public class Person_Test {

	@BeforeClass
	// Establishes a person for testing
	public static void setUpBeforeClass() throws Exception {
	Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1995-09-26");
	PersonDomainModel person = new PersonDomainModel();
	person.setFirstName("Jacques");
	person.setLastName("Samaha");
	person.setBirthday(birthday);
	person.setCity("Haddonfield");
	person.setPostalCode(10802);
	person.setStreet("218 Chestnut st");
	person.setPersonID(UUID.randomUUID());
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After 
	public void tearDown() throws Exception {
		PersonDomainModel personForDeleteTest;
		PersonDAL.deletePerson(person.getPersonID());
		// Now check to make sure that the person was actually deleted
		personForDeleteTest = PersonDAL.getPerson(person.getPersonID());
		assertNull(personForDeleteTest);
	}
	
	// Tests the add person function
	@Test
	public void AddPersonTest() {
		PersonDomainModel personForTesting;
		personForTesting = PersonDAL.getPerson(person.getPersonID());
		// Since the test case hsan't been added yet it should be null
		assertNull(personForTesting);
		// Adds the person now
		PersonDAL.addPerson(person);
		personForTesting = PersonDAL.getPerson(person.getPersonID());
		// The person should now have been added to the database
		assertNotNull(personForTesting);
	}
	
	// Test the Update Person 
	@Test
	public void UpdatePersonTest()
	{
		PersonDomainModel updateTester;
		String New_Name = "Neel";
		
		updateTester = PersonDAL.getPerson(person.getPersonID());
		PersonDAL.addPerson(person);
		
		person.setFirstName(New_Name);
		PersonDAL.updatePerson(person);
		updateTester = PersonDAL.getPerson(person.getPersonID());
		assertTrue(updateTester.getFirstName() == New_Name);
	}
	
	//Test the Delete Person 
	@Test
	public void DeletePersonTest()
	{
		PersonDomainModel deleteTester;
		deleteTester = PersonDAL.getPerson(person.getPersonID());
		PersonDAL.addPerson(person);
		// Make sure the person was added before deleting them
		assertNotNull(person);
		
		PersonDAL.deletePerson(person.getPersonID());
		deleteTester = PersonDAL.getPerson(person.getPersonID());
		// Make sure they were deleted
		assertNull(deleteTester);
	}

}
