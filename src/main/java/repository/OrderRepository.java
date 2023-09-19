package repository;

import entity.OrdersEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface OrderRepository extends CrudRepository<OrdersEntity, Integer> {
//    List<OrdersEntity> findAllByOrderDetailProductName(String name);

    List<OrdersEntity> findAllByCustomerNameLike(String name);
    @Modifying
    @Query("select o FROM OrdersEntity o WHERE FUNCTION('MONTH',o.orderDate) = :month")
    List<OrdersEntity> findAllByOrderDate_Month(@Param("month") Integer month);


    List<OrdersEntity> findAllByOrderDetailsEntityProductName(String name);
}
