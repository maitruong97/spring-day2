package main;

import configuration.JPAConfig;
import entity.Book;
import entity.BookEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;
import service.AccountService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MainBook {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = applicationContext.getBean("bookRepository", BookRepository.class);
    static AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

    // create new book
   public  static BookEntity createNewBook(){
        Book book = new Book();
        book.setName("Java A-Z");
        book.setAuthor("truong");
        book.setCategory("IT Books");
        book.setIsbn("jhakscadkaud66516161");
        book.setNumberOfPage(123);
        book.setPrice(100);
        book.setPublishDate(LocalDate.parse("2023-08-09"));

        Book result = bookRepository.save(book);

        if (result != null){
            System.out.println("A new book saved successfully, book ID = " + book.getId());
        }
        return null;
    }
    //read booklist
    private static void readBook() {
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        System.out.println("Found" + bookList.size()+ "book(s) in the table book");
        System.out.println("They are : ");
        for(Book book: bookList){
            System.out.println(bookList.toString());
        }
    }

    // update book
    private static void updateBook() {

        Optional<Book> book = bookRepository.findById(1);
        System.out.println("Book date before updating");
        System.out.println(book.toString());
        if (book.isPresent()){
            Book book1 = book.get();// dung get() de lay gia tri ra
            book1.setAuthor("maitruong");
            book1.setPrice(500);
            book1.setNumberOfPage(10);
            book1.setCategory("abc");
            bookRepository.save(book1);

        }
        System.out.println("Book data after updating");
        System.out.println(book.toString());

    }
    private static void updateBookPrice() {

        Iterable<Book> book = bookRepository.findAll();
        System.out.println("Book date before updating");
        System.out.println(book.toString());


    }



    // delete book
    private static void deleteBook(){
        bookRepository.deleteById(1);

        Optional<Book> book = bookRepository.findById(2);

        if (book.isPresent()){
            Book book1 = book.get();
            bookRepository.delete(book1);
        }
        //delete All
        bookRepository.deleteAll();

    }

    public static void main(String[] args) throws Exception {
//        createNewBook();
//        readBook();
        //updateBook();
//        deleteBook();
//    List<Book> bookList = bookRepository.findByPriceGreaterThanEqual(90);
        //Hiển thị các sách không có tên là Java
//    List<Book> bookList = bookRepository.findByNameNotLike("%Java%");
        //  Hiển thị danh sách các Sách có ngày publishDate bé hơn ngày hiện tại
//   List<Book> bookList = bookRepository.findByPublishDateBefore(LocalDate.now());

//   List<Book> bookList = bookRepository.findByPublishDateBefore(LocalDate.now());
        List<Book> bookList = bookRepository.updateALlPrice(50);


//    if (bookList.size() != 0){
//        System.out.println("Found " + bookList.size() + "book(s) of Roger");
//        System.out.println("They are: ");
//        for (Book book: bookList ) {
//            System.out.println(book.toString());
//        }
//    }

    }
}
