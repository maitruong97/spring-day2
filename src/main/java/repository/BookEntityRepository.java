package repository;

import entity.Book;
import entity.BookEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookEntityRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByNameAndAuthor(String name,String author);
    List<BookEntity> findByNameOrAuthor(String name,String author);

    BookEntity findByBookDetailsIsbn(String isbn);

    List<BookEntity> findByBookDetailsPriceLessThan(int price);
    List<BookEntity> findByBookDetailsPriceLessThanEqual(int price);
    List<BookEntity> findByBookDetailsPriceGreaterThanEqual(int price);

    List<BookEntity> findByNameContaining(String name);


//    List<BookEntity> findAll();
    @Query(value = "select * from book", nativeQuery = true)
    List<BookEntity> getAll();
    @Query("select b from BookEntity b where b.name like ?1%")
    List<BookEntity> getBookNameStartWith(String name);

    @Query("select b from BookEntity b where b.bookDetails.price =?1")
    List<BookEntity> getBookPriceGreaterThan(int price);
}

