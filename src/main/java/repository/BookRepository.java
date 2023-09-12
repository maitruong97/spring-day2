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
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByAuthor(String author);
    List<Book> findByNameNotLike(String searchWords);

    List<Book> findByAuthorAndPrice(String author, double price);
    List<Book> findByPriceOrNumberOfPage(double price, int numberOfPage);
    List<Book> findByPriceLessThan(double price);
    List<Book> findByPriceGreaterThanEqual(double price);
    List<Book> findByNameContaining(String searchWords);
    Book findByIsbn(String isbn);
    List<Book> findByPublishDateAfter(LocalDate date);
    List<Book> findByPublishDateBefore(LocalDate date);



    @Modifying
    @Query("update Book b set b.price = ?1")
    List<Book> updateALlPrice(double price);

    List<Book> deleteByNameAndAuthor(String name, String author);




    @NoRepositoryBean
    public interface BaseRepository<T, ID extends Serializable> extends Repository {
        List<T> findAll( );
        Optional<T> findById(ID id);
        @Query("SELECT t FROM #{#entityName} t WHERE t.id IN :ids")
        List<T> findByIdsIn(@Param("ids") List<ID> ids);
    }
}
