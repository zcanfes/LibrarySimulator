package librarymembers;
import java.util.ArrayList;
import books.Book;

/**
 * Represents the academics registered at the library system.
 * @author Zehranaz
 *
 */
public class Academic extends LibraryMember{
	/**
	 * Creates an academic member that has an id. An academic can have 20 books at most,
	 * must return those books in 50 time units and initially he/she has 0 books in his/her
	 * possession.
	 * @param id The integer that stands for the id of the academic.
	 * @see librarymembers.LibraryMember
	 */
	public Academic(int id) {
		this.id = id;
		this.maxNumberOfBooks = 20;
		this.timeLimit = 50;
		this.numberOfBooks = 0;
	}
	/**
	 * Gets the history of books that the member has read or borrowed.
	 * @return The ArrayList consisting of books that the academic has read or borrowed.
	 */
	@Override
	public ArrayList<Book> getTheHistory(){
		return this.theHistory;
	}
}