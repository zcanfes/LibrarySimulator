package librarymembers;
import books.Book;
import books.Printed;
import java.util.ArrayList;
/**
 * Represents the library members registered at the library system.
 * @author Zehranaz
 *
 */
public abstract class LibraryMember{
	/**
	 * Stands for the id of the library member.
	 */
	protected int id;
	/**
	 * Represents the maximum number of book that a member can borrow from 
	 * the library.
	 */
	protected int maxNumberOfBooks;
	/**
	 * Represents the time limit the library member has to return the book
	 * after he/she has borrowed it.
	 */
	protected int timeLimit;
	/**
	 * Stands for the number of books the member holds in his/her possession currently.
	 */
	protected int numberOfBooks;
	/**
	 * Represents the ArrayList consisting of the books that the library member has read 
	 * or borrowed.
	 */
	protected ArrayList<Book> theHistory = new ArrayList<Book>();
	/**
	 * Represents the ArrayList consisting of the books that the member has borrowed and 
	 * still has them in his/her possession.
	 */
	private ArrayList <Printed> currentBook = new ArrayList <Printed>();
	/**
	 * Gets the history of books of the library member.
	 * @return The ArrayList consisting of books that the member has read.
	 */
	abstract ArrayList <Book> getTheHistory();
	/**
	 * Creates a library member with id, maximum number of books, time limit and current
	 * number of books equal to 0. 
	 */
	public LibraryMember() {
		this.id = 0;
		this.maxNumberOfBooks = 0;
		this.timeLimit = 0;
		this.numberOfBooks = 0;
	}
	/**
	 * Gets the id of the member.
	 * @return The integer that represents the id of the member.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Sets the id of the member.
	 * @param id The integer that represents the id of the member.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Gets the current books in the possession of the member.
	 * @return The ArrayList consisting of printed books that the member has.
	 */
	public ArrayList <Printed> getCurrentBook() {
		return this.currentBook;
	}
	/**
	 * Sets the current books that the member has.
	 * @param printed The printed book that the member borrows.
	 */
	public void setCurrentBook(Printed printed) {
		this.currentBook.add(printed);
	}
	/**
	 * Gets the maximum number of books that the member can have at the same time.
	 * @return The integer that represents the maximum number of books.
	 */
	public int getMaxNumberOfBooks() {
		return this.maxNumberOfBooks;
	}
	/**
	 * Gets the time limit of a member in which he/she must return a book they have borrowed.
	 * @return The integer that stands for the time limit of the member.
	 */
	public int getTimeLimit() {
		return timeLimit;
	}
	/**
	 * Gets the number of books that the member has at the same time.
	 * @return The integer representing the number of books that the member has in his/her
	 * possession.
	 */
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	/**
	 * Sets the number of books of a member.
	 * @param k Integer representing the number of books that the member has.
	 */
	public void setNumberOfBooks(int k) {
		numberOfBooks = k;
	}
}