package repository;

import entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetailsEntity, Integer> {
    List<OrderDetailsEntity> findAllByOrderId(int id);

    @Modifying
    @Transactional
    void deleteByOrderId(int id);
}
