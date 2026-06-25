//public class Book {
//	private String title;
//	private Member mbr;
//	
//	public Book (String title) {
//		this.title = title ;
//		
//	}
//	@Override
//	public String toString() {
//		return "Book [Title= " +title + "]";
//		
//	}
//	
//	public void status () {
//		if (mbr== null) 
//			System.out.println(title + "not issued by any member ");
//		else 
//			System.out.println((title + "issed by "+ mbr));
//			
//		}
//	}
//	
//
package com.mmcoe.lib;


public class Book {

    private String title;
    private Member issuedTo;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void issueTo(Member member) throws LibraryException {

        if (issuedTo != null) {
            throw new LibraryException(title + " is already issued.");
        }

        issuedTo = member;
        member.setBook(this);

        System.out.println(title + " issued to " + member.getName());
    }

    public void returnBook() throws LibraryException {

        if (issuedTo == null)  {
            throw new LibraryException (title + " is already available.");
            
        }

        issuedTo.setBook(null);
        System.out.println(title + " returned successfully.");

        issuedTo = null;
    }

    public void status() {

        if (issuedTo == null)
            System.out.println(title + " is available.");
        else
            System.out.println(title + " is issued to " + issuedTo.getName());
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + "]";
    }
}