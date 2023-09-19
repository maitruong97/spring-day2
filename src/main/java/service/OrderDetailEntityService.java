package service;

import entity.OrderDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import repository.OrderDetailRepository;

@Service("orderDetailEntityService")
public class OrderDetailEntityService {


        private JpaTransactionManager jpaTransactionManager;

        @Autowired
        private OrderDetailRepository orderDetailRepository;

        public void deleteAllByOrderById(int id){
            orderDetailRepository.deleteByOrderId(id);
        }
    }

