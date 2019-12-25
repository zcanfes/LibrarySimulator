package books;
import librarymembers.LibraryMember;
import interfaces.ReadInLibrary;

/**
 * Represents the Handwritten books in the library.
 * @author Zehranaz
 *
 */
public class Handwritten extends Book implements ReadInLibrary {
	/**
	 * Creates handwritten bookos with the given id.
	 * @param bookId An integer that stands for the books id in the library.
	 * @see books.Book
	 */
	public Handwritten(int bookId) {
		super(bookId, "H");
	}
	/**
	 * Lets the member return the handwritten book to the library. The book is
	 * not taken by anyone after the return.
	 * @param member The member that wants to return the book to the library. 
	 */
	@Override
	public void returnBook(LibraryMember member) {
		super.setTaken(false);
		super.setWhoHas(null);
		super.setIsReadInLibrary(false);
	}
	/**
	 * Lets the member read the book in the library. The book is taken by the 
	 * member.
	 * @param member The member that wants to read the book in the library.
	 */
	@Override
	public void readBook(LibraryMember member) {
		super.setTaken(true);
		super.setWhoHas(member);
		super.setIsReadInLibrary(true);
	}
}