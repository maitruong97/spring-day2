package main;

import configuration.JPAConfig;
import entity.BookDetailsEntity;
import entity.BookEntity;
import entity.CategoryEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookEntityRepository;
import repository.BookRepository;
import repository.CategoryRepository;

import java.time.LocalDate;
import java.util.List;

import static main.MainBook.createNewBook;

public class MainTestEntity {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookEntityRepository bookEntityRepository = (BookEntityRepository) context.getBean("bookEntityRepository", BookEntityRepository.class);
    static CategoryRepository categoryRepository = (CategoryRepository) context.getBean("categoryRepository", CategoryRepository.class);

//    public static void main(String[] args) {
////        createNewBookEntryWithNewCategory();
////        createNewBookEntry();
////        findAllUsingQuery();
////        findByAuthor("nguyen thi yen nhi");
////        findBookNameStartWithUsingQuery("PyThon");
////          findBookPriceGreaterThanUsingQuery(100);
//        findByNameContaining("Py");
//    }


    public static void findByAuthor(String author) {
        List<BookEntity> bookEntityList = bookEntityRepository.findByAuthor(author);
        if (bookEntityList != null) {
            System.out.println("Find" + bookEntityList.size() + "books which author = " + author);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }

        }
    }

    public static void findByNameAndAuthor(String name, String author) {
        List<BookEntity> bookEntityList = bookEntityRepository.findByNameAndAuthor(name, author);
        if (bookEntityList != null) {
            System.out.println("Find" + bookEntityList.size() + "books which author = " + author + "AND name = " + name);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }

        }
    }

    public static void findByNameOrAuthor(String name, String author) {
        List<BookEntity> bookEntityList = bookEntityRepository.findByNameOrAuthor(name, author);
        if (bookEntityList != null) {
            System.out.println("Find" + bookEntityList.size() + "books which author = " + author + "OR name = " + name);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }

        }
    }

    public static void findByPriceLessThan(int price) {
        List<BookEntity> bookEntityList = bookEntityRepository.findByBookDetailsPriceLessThan(price);
        if (bookEntityList != null) {
            System.out.println("Find" + bookEntityList.size() + "books price less than = " + price);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }

        }
    }

    public static void findByNameContaining(String name) {
        List<BookEntity> bookEntityList = bookEntityRepository.findByNameContaining(name);
        if (bookEntityList != null) {
            System.out.println("Find" + bookEntityList.size() + "books which name containing = " + name);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }

        }
    }

    public static void findAllUsingQuery() {
        List<BookEntity> bookEntityList = bookEntityRepository.getAll();
        if (bookEntityList != null) {
            System.out.println("Find  " + bookEntityList.size() + "  books");
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }

        }
    }


    public static void findByBookDetailsIsbn(String isbn) {
        BookEntity bookEntity = bookEntityRepository.findByBookDetailsIsbn(isbn);
        if (bookEntity != null) {
            System.out.println("Find books which isbn" + isbn);
            System.out.println(bookEntity.toString());
        }
    }

    public static void createNewBookEntry() {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookEntityRepository.save(bookEntity);
    }

    public static void  createNewBookEntryWithNewCategory(){
        CategoryEntity categoryEntity = createNewCategory();
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookEntityRepository.save(bookEntity);
    }
    private static BookEntity createNewBook() {

        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setIsbn("514236653");
        bookDetailsEntity.setNumberOfPage(16);
        bookDetailsEntity.setPrice(100);
        bookDetailsEntity.setPublishDate(LocalDate.now());

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Java A-Z");
        bookEntity.setAuthor("MaiTruong");
        bookEntity.setBookDetails(bookDetailsEntity);
        bookDetailsEntity.setBook(bookEntity);
        return bookEntity;
    }
    private static CategoryEntity createNewCategory(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("IT");
        categoryEntity.setDescription("It Books");
        return categoryEntity;

    }

    public static void findBookNameStartWithUsingQuery(String name){
        List<BookEntity> bookEntityList = bookEntityRepository.getBookNameStartWith(name);
        if (bookEntityList != null){
            System.out.println("Find " + bookEntityList.size() + "books") ;
            for (BookEntity bookEntity : bookEntityList ){
                System.out.println(bookEntity.toString());
            }
        }




}
    public static void findBookPriceGreaterThanUsingQuery(int price){
        List<BookEntity> bookEntityList = bookEntityRepository.getBookPriceGreaterThan(price);
        if (bookEntityList != null){
            System.out.println("Find " + bookEntityList.size() + "books") ;
            for (BookEntity bookEntity : bookEntityList ){
                System.out.println(bookEntity.toString());
            }
        }

    }

}
