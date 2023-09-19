package service;


import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.OrderRepository;


import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;
@Service("orderEntityService")
public class OrderEntityService {


    private JpaTransactionManager jpaTransactionManager;

    @Autowired
   private OrderRepository orderRepository;

    @Transactional
    public void insertOrder(OrdersEntity order){
        orderRepository.save(order);
    }

    public Optional<OrdersEntity> findById(int id){
        return orderRepository.findById(id);
    }

    public List<OrdersEntity> findAll(){
        return (List<OrdersEntity>) orderRepository.findAll();
    }

    public List<OrdersEntity> findAllByOrderDate_Month(Integer month){
        return orderRepository.findAllByOrderDate_Month(month);
    }

    public List<OrdersEntity> findAllByOrderDetailProductName(String name){
        return orderRepository.findAllByOrderDetailsEntityProductName(name);
    }

    public List<OrdersEntity> findAllByCustomerNameLike(String name){
        return orderRepository.findAllByCustomerNameLike(name);
    }

    public void deleteById(int id){
        orderRepository.deleteById(id);
    }


}