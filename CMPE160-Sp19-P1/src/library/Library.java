package library;
import books.Book;
import books.Printed;
import books.Handwritten;
import librarymembers.LibraryMember;
import librarymembers.Student;
import librarymembers.Academic;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Represents a library management system consisting of daily operations concerning 
 * books and members registered to the library similar to a library in a university.
 * @author Zehranaz
 *
 */
public class Library{
	/**
	 * Represents the books contained in the library.
	 */
	protected Book[] Books;
	/**
	 * Represents the members registered to the library system.
	 */
	protected LibraryMember[] Members;
	/**
	 * Represents the total fee paid to the library.
	 */
	protected int totalFee;
	/**
	 * Reads the input file that contains the commands for the library simulater.
	 */
	private Scanner sc;
	/**
	 * Represents the Id of the book that is registered in the library system.
	 */
	protected int bookId = 1;
	/**
	 * Represents the Id of the member that is registered to the library.
	 */
	protected int id = 1;
	/**
	 * Creates a library with the specified scanner.
	 * @param sc The scanner that reads the input file.
	 */
	public Library(Scanner sc) {
		this.Members = new LibraryMember[(int)Math.pow(10, 6)];
		this.Books = new Book[(int)Math.pow(10, 6)];
		this.totalFee = 0;
		this.sc = sc;
	}
	/**
	 * Gets the books that are registered in the library. 
	 * @return Book array representing the books in the library
	 */
	public Book[] getBooks() {
		return Books;
	}
	/**
	 * Sets the books in the library.
	 * @param books The Book array that contains the books in the library.
	 */
	public void setBooks(Book[] books) {
		Books = books;
	}
	/**
	 * Gets the library members registered to the system.
	 * @return Member array representing the members in the library system.
	 */
	public LibraryMember[] getMembers() {
		return Members;
	}
	/**
	 * Sets the members registered to the library system.
	 * @param members An array consisting of members that are registered at the library.
	 */
	public void setMembers(LibraryMember[] members) {
		Members = members;
	}
	/**
	 *Gets the total fee paid to the library.  
	 * @return An integer that stands for the total fee paid to the library.
	 */
	public int getTotalFee() {
		return this.totalFee;
	}
	/**
	 * Shows whether the book of the given id is registered to the system. Also it whether 
	 * the given id is less than the size of the books array.
	 * @param m An integer that represents the book id that is read from the input file.
	 * @return The boolean value representing whether the book belongs to the library or not.
	 * Returns false if it is not registered, true if it is.
	 */
	public boolean bookExists(int m) {
		if(m < Books.length) {
			if(Books[m - 1] == null) {
				return false;
			}
			else return true;
		}
		return false;
	}
	/**
	 * Shows whether the member of the given id is registered at the library. Also checks whether 
	 * the given id is less than the size of the members array. 
	 * @param m An integer that represents the member id that is read from the input file.
	 * @return The boolean value representing whether the member is registered at the system or not.
	 * Returns false if it is not registered, true if it is.
	 */
	public boolean memberExists(int m) {
		if(m < Members.length) {
			if(Members[m - 1] == null) {
				return false;
			}
			else return true;
		}
		return false;
	}
	/**
	 * Checks whether the member is allowed to borrow the given printed book from the library.
	 * @param printed The printed book that the member wants to borrow.
	 * @param tick The integer that represents each operation time.
	 * @param member Library member that is registered at the system.
	 * @return The boolean value representing whether the member is allowed to borrow the book. 
	 * Returns false if the member has books whose deadline has passed, true if the member is
	 * allowed to borrow the book.
	 */
	public boolean isAllowed(Printed printed, int tick, LibraryMember member) {
		ArrayList<Printed> currentBook = member.getCurrentBook();
		for(int i = 0; i < currentBook.size(); i++) {
			Printed temp = (Printed) currentBook.get(i);
			if(tick > temp.getDeadLine()) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Adds a book to the library system according to its type given in the input file.
	 * "P" stands for printed, "H" stands for handwritten.
	 * @see books.Printed
	 * @see books.Handwritten
	 */
	public void addBook() {
		String s = sc.next();
		if(bookId < 1000000) {
			if(s.equals("P")) {
				Printed book = new Printed(bookId);
				Books[bookId - 1] = book;
			}
			else if(s.equals("H")) {
				Handwritten book = new Handwritten(bookId);
				Books[bookId - 1] = book;			
			}
			this.bookId++;
		}
	}
	/**
	 * Adds a member to the library system according to its type given in the input file.
	 * "S" stands for student, whereas "A" stands for academic.
	 * @see librarymembers.Academic
	 * @see librarymembers.Student
	 */
	public void addMember() {
		String s = sc.next();
		if(id < 1000000) {
			if(s.equals("S")) {
				Student student = new Student();
				student.setId(id);
				Members[id - 1] = student;
			}
			else if(s.equals("A")) {
				Academic academic =  new Academic(id);
				Members[id - 1] = academic;
			}
			this.id++;
		}
	}
	/**
	 * Lets the member borrow a book according to the input in the file. Operates depending on
	 * the type of the book and the member. Checks whether the book is taken or not and whether
	 * the book is of type Printed. Further, checks whether the member is allowed to borrow 
	 * the book and whether he/she holds maximum number of books in his/her posession. 
	 * Additionally, calls the borrowBook method in Printed class and adds the book in the 
	 * member's history if it is not contained in the History list. Finally, sets the deadline
	 * for the book that the member has borrowed and increments the number of books in 
	 * posession of the member.
	 * @param tick The integer that represents each operation time.
	 * @see books.Printed
	 */
	public void borrowBook(int tick) {
		int bookId = sc.nextInt();
		int id = sc.nextInt();
		if(bookExists(bookId) && memberExists(id)) {
			Book book = Books[bookId - 1];
			LibraryMember member = Members[id - 1];
			int currentBorrowed = member.getNumberOfBooks();
			if(book.getBookType().equals("P") && book.getIsTaken() == false) {
				Printed printed = (Printed) book;
				if(isAllowed(printed, tick, member) && currentBorrowed < member.getMaxNumberOfBooks()) {
					if(member instanceof Student) {
						Student student = (Student) member;
						printed.borrowBook(member, tick);
						if(!student.getTheHistory().contains(book))
							student.getTheHistory().add(book);
					}
					else{
						Academic academic = (Academic) member;
						printed.borrowBook(member, tick);
						if(!academic.getTheHistory().contains(book))
							academic.getTheHistory().add(book);
					}
					printed.setDeadLine(member, tick);
					member.setNumberOfBooks(currentBorrowed + 1); 
					member.setCurrentBook(printed);
				}
			}
		}
	}
	/**
	 * Allows the member to return the book that he/she has borrowed. First, checks
	 * whether the member and the book exist, then whether the book is taken or not.
	 * After that, checks whether the member wanting to return the book has the same
	 * id with the member that has the book. Additionally, checks whether the book
	 * is printed. Then calculates the fee the member has to pay to the library
	 * and allows the member to return the book. If the type of the book is handwritten
	 * the member does not have to pay fee to the library. Finally, removes the book
	 * from the list of the books that the member currently possesses. 
	 * @param tick The integer that represents each operation time.
	 */
	public void returnBook(int tick) {
		int bookId = sc.nextInt();
		int id = sc.nextInt();
		if(bookExists(bookId) && memberExists(id)) { 
			Book book = Books[bookId - 1];
			LibraryMember member = Members[id - 1];
			if(book.getIsTaken()) {
				if(book.getWhoHas().getId() == member.getId()) {
					if(book.getBookType().equals("P")){
						Printed printed = (Printed) book;
						if(tick > printed.getDeadLine() && !book.getIsReadInLibrary()) {
							int fee = tick - printed.getDeadLine();
							totalFee += fee;
						}
						printed.returnBook(member);
					}
					else {
						Handwritten handwritten = (Handwritten) book;
						handwritten.returnBook(member);
					}
					member.getCurrentBook().remove(book);
				}
			}
		}
	}
	/**
	 * Extends the deadline of the book that is borrowed by the library member. First
	 * checks whether the member and the book exists. Then checks whether the book is 
	 * of type Printed and is taken or not. After that checks whether the id of the
	 * member who wants to extend the deadline of the book is the same with the member
	 * who has borrowed the book. Finally, lets the member extend the deadline if the
	 * deadline has not passed yet and the deadline of the book has not been extended
	 * before by the same member.
	 * @param tick The integer that represents each operation time.
	 */
	public void extendBook(int tick) {
		int bookId = sc.nextInt();
		int id = sc.nextInt();
		if(bookExists(bookId) && memberExists(id)) {
			Book book = Books[bookId - 1];
			LibraryMember member = Members[id - 1];
			if(book.getBookType().equals("P") && book.getIsTaken() == true) {
				if(book.getWhoHas().getId() == member.getId()) {
					Printed printed = (Printed) book;
					if(printed.getDeadLine() >= tick && printed.getIsExtended() == false) {
						printed.extend(member, tick);
					}
				}
			}
		}
	}
	/**
	 * Lets the member read the book in the library. If the book is printed every member
	 * can access it. However, if it is Handwritten then only the academics can access it.
	 * Further, adds the book to the history of the member if it is not contained 
	 * in the history list already.
	 */
	public void readInLibrary() {
		int bookId = sc.nextInt();
		int id = sc.nextInt();
		if(bookExists(bookId) && memberExists(id)) { 
			Book book = Books[bookId - 1];
			LibraryMember member = Members[id - 1];
			if(book.getIsTaken() == false) {
				if(member instanceof Academic) {
					if(book.getBookType().equals("P")) {
						Printed printed = (Printed) book;
						printed.readBook(member);
					}
					else {
						Handwritten handwritten = (Handwritten) book;
						handwritten.readBook(member);
					}
					Academic academic = (Academic) member;
					if(!academic.getTheHistory().contains(book))
						academic.getTheHistory().add(book);
				}
				else { 
					if(book.getBookType().equals("P")) {
						Student student =  (Student) member;
						Printed printed = (Printed) book;
						printed.readBook(member);
						if(!student.getTheHistory().contains(book))
							student.getTheHistory().add(book);
					}
				}
			}
		}
	}
}