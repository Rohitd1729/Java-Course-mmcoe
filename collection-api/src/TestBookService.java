import com.mmcoe.dao.BookDao;
import com.mmcoe.dao.BookDaoCollectionImpl;
import com.mmcoe.pojo.Book;
import com.mmcoe.service.BookNotFoundException;
import com.mmcoe.service.BookService;
import com.mmcoe.service.BookServiceImpl;

public class TestBookService {

	public static void main(String[] args) {
		BookDao dao = new  BookDaoCollectionImpl();
		BookService service = new BookServiceImpl(dao);
		
		service.save(new Book(101, "Java", "Herbert", 650));
		service.save(new Book(102, "Python", "Guido", 500));
		service.save(new Book(103, "C++", "Bjarne", 700));
		service.save(new Book(104, "DBMS", "Korth", 400));
		service.save(new Book(105, "OS", "Galvin", 550));
		
		System.out.println("===== ALL BOOKS =====");
		for (Book b : service.list())
			System.out.println(b);
		
		System.out.println("\n===== FIND BOOK =====");
		try {
			System.out.println(service.find(102));
			
		}catch(BookNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("\n===== BOOKS BETWEEN 400 AND 650 =====");
		for (Book b: service.findByPrice(400, 650)) {
			
			System.out.println(b);
		}
		System.out.println("\n===== DELETE BOOK =====");
		try {
			service.delete(105);
			System.out.println("Book Deleted");
			
		}catch(BookNotFoundException e) {
			e.printStackTrace();
	}
		System.out.println("\n===== BOOKS AFTER DELETE =====");

		for(Book b : service.list()) {
			System.out.println(b);
		}
	}
}

