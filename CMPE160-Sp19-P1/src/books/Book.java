package books;
import librarymembers.LibraryMember;

/**
 * Represents the books in the library management system.
 * @author Zehranaz
 *
 */
public abstract class Book{
	/**
	 * Stands for the id of the book
	 */
	protected int bookId;
	/**
	 * Stands for the type of the book, either printed or handwritten.
	 */
	protected String bookType;
	/**
	 * Represents whether the book is taken by a member or not.
	 */
	protected boolean isTaken;
	/**
	 * Represents whether the book is read in the library or not.
	 */
	protected boolean isReadInLibrary;
	/**
	 * Represents the member who has the book in his/her possession.
	 */
	private LibraryMember whoHas;
	/**
	 * Lets the member return the book to the library.
	 * @param member The member that wants to return the book that he/she has borrowed.
	 */
	abstract void returnBook(LibraryMember member);
	/**
	 * Creates a book according to its id and type. Initially the book has not been
	 * taken by anyone.
	 * @param bookId The integer value that stands for the id of the book.
	 * @param bookType The string that represents the type of the book. "P" stands for 
	 * Printed, whereas "H" stands for handwritten.
	 */
	public Book(int bookId, String bookType) {
		this.bookId = bookId;
		this.bookType = bookType;
		this.whoHas = null;
		this.isTaken = false;
	}
	/**
	 * Gets the id of the book.
	 * @return The integer that stands for the id of the book.
	 */
	public int getBookId() {
		return bookId;
	}
	/**
	 * Sets the book id.
	 * @param bookId The integer that stands for the id of the book.
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * Gets the book type.
	 * @return The string that represents the type of the book. "P" stands for
	 * Printed, whereas "H" stands for handwritten. 
	 */
	public String getBookType() {
		return this.bookType;
	}
	/**
	 * Sets the type of the book. 
	 * @param bookType String that represents the type of the boook. P" stands for
	 * Printed, whereas "H" stands for handwritten. 
	 */
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	/**
	 * Gets whether the book is taken or not.
	 * @return The boolean value that represents whether the book is taken or not.
	 */
	public boolean getIsTaken() {
		return isTaken;
	}
	/**
	 * Sets the book taken or not taken.
	 * @param isTaken The boolean value that represents whether the book is taken or not.
	 */
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	/**
	 * Gets the member who has the book.
	 * @return The library member that possesses the book.
	 */
	public LibraryMember getWhoHas() {
		return whoHas;
	}
	/**
	 * Sets who has the book.
	 * @param whoHas The library member that will have the book.
	 */
	public void setWhoHas(LibraryMember whoHas) {
		this.whoHas = whoHas;
	}
	/**
	 * Sets whether the book is read in the library or not.
	 * @param x Boolean value that represents whether the book was read in the library or not.
	 */
	public void setIsReadInLibrary(boolean x) {
		this.isReadInLibrary = x;
	}
	/**
	 * Gets whether the book is read in the library or not.
	 * @return The boolean value representing whether the book is read in the library or not.
	 */
	public boolean getIsReadInLibrary() {
		return this.isReadInLibrary;
	}
}