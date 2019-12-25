package librarymembers;
import java.util.ArrayList;
import books.Book;
/**
 * Represents the student registered at the library system.
 * @author Zehranaz
 *
 */
public class Student extends LibraryMember{
	/**
	 * Creates a student that is registered to the library system. Initially, the student
	 * has a right to borrow 10 book at max and the time limit to return them is 20 time units.
	 * Also, initially the student has 0 books.
	 * @see librarymembers.LibraryMember
	 */
	public Student() {
		this.maxNumberOfBooks = 10;
		this.timeLimit = 20;
		this.numberOfBooks = 0;
	}
	/**
	 * Gets the history of books of the student.
	 * @return The ArrayList consisting of books that the student has read or borrowed.
	 */
	@Override
	public ArrayList<Book> getTheHistory(){
		return this.theHistory;
	}
}