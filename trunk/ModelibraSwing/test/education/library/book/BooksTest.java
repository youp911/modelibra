/*
 * Modelibra
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package education.library.book;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import education.EducationTest;

/**
 * JUnit tests for Books.
 * 
 * @author Dzenan Ridjanovic
 * @version 2009-03-04
 */
public class BooksTest {

	private static Books books;

	@BeforeClass
	public static void beforeTests() throws Exception {
		// If the concept is not an entry into the model, first find a
		// collection of entities.
		// For an entry point the following code is correct.
		// books =
		// EducationTest.getSingleton().getEducation().getLibrary().getBooks();
	}

	@Before
	public void beforeTest() throws Exception {
		books.getErrors().empty();
	}

	@Test
	public void testName() throws Exception {
		// to do
	}

	@After
	public void afterTest() throws Exception {
		for (Book book : books.getList()) {
			books.remove(book);
		}
	}

	@AfterClass
	public static void afterTests() throws Exception {
		EducationTest.getSingleton().close();
	}

}