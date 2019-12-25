package books;
import librarymembers.LibraryMember;
import librarymembers.Student;
import librarymembers.Academic;
import interfaces.ReadInLibrary;
import interfaces.Borrow;

/**
 * Represents the printed books in the library and the operations defined
 * on this type of books.
 * @author Zehranaz
 *
 */
public class Printed extends Book implements ReadInLibrary, Borrow{
	/**
	 * Stands for the deadline of the book that is in the library.
	 */
	protected int deadLine;
	/**
	 * Represents whether the deadline of the book is extended or not.
	 */
	protected boolean isExtended;
	/**
	 * Created a printed book according to its id. A printed book consists of a book id and
	 * deadline that is set to 0, as well as a boolean value representing that it's deadline
	 * is not extended.
	 * @param bookId An integer value representing the if of the book registered at the system 
	 * of the library.
	 * @see books.Book
	 */
	public Printed(int bookId) {
		super(bookId, "P");
		this.deadLine = 0;
		this.isExtended = false;
	}
	/**
	 * Gets the deadline of the book.
	 * @return An integer, namely the deadline of the book.
	 */
	public int getDeadLine() {
		return this.deadLine;
	}
	/**
	 * Sets the deadline of the book after it is borrowed by a library member.
	 * @param member The library member that wants to borrow the book.
	 * @param tick The integer that represents each operation time.
	 */
	public void setDeadLine(LibraryMember member, int tick) {
		this.deadLine = tick + member.getTimeLimit();
	}
	/**
	 * Checks whether the deadline of the book is extended before or not.
	 * @return The boolean value representing if the book's deadline is extended.
	 */
	public boolean getIsExtended() {
		return this.isExtended;
	}
	/**
	 * Lets the member return the book to the library. After returning, the book
	 * is not taken by anyone and the number of books that the member has in 
	 * possesion is decreased by 1.
	 * @param member The library member that wants to return the book.
	 */
	@Override
	public void returnBook(LibraryMember member) {
		super.setTaken(false);
		super.setWhoHas(null);
		super.setIsReadInLibrary(false);
		if(isReadInLibrary == false) {
			if(member instanceof Student) {
				Student student = (Student) member;
				student.setNumberOfBooks(student.getNumberOfBooks() - 1);
			}
			else {
				Academic academic = (Academic) member;
				academic.setNumberOfBooks(academic.getNumberOfBooks() - 1);
			}
		}
		this.deadLine = 0;
	}
	/**
	 * Allows the member to read a book in the library. So the book is set taken and
	 * the member is the one who has it.
	 * @param member The member who wants to read the book in the library.
	 */
	@Override
	public void readBook(LibraryMember member) {
		super.setTaken(true);
		super.setWhoHas(member);
		super.setIsReadInLibrary(true);
	}
	/**
	 * Lets the member borrow a book from the library. After the process
	 * the book is set taken by the member and the deadline is set according 
	 * to the member's type.
	 * @param member The member who wants to borrow a book.
	 * @param tick The integer that represents each operation time.
	 */
	@Override
	public void borrowBook(LibraryMember member, int tick) {
		if(member instanceof Student) {
			Student student = (Student) member;
			setTaken(true);
			setWhoHas(student);
			setDeadLine(student, tick);
		}
		else {
			Academic academic = (Academic) member;
			setTaken(true);
			setWhoHas(academic);
			setDeadLine(academic, tick);
		}
	}
	/**
	 * Allows the member to extend the deadline of the book he/she has borrowed 
	 * from the library. Adds the time limit of the member to the current deadline.
	 * @param member The member that wants to extend the deadline of the book.
	 * @tick The integer that represents each operation time.
	 */
	@Override
	public void extend(LibraryMember member, int tick) {
		this.deadLine += member.getTimeLimit();
		this.isExtended = true;
	}
}