package main;

import configuration.JPAConfig;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrderDetailRepository;
import repository.OrderRepository;
import service.OrderDetailEntityService;
import service.OrderEntityService;

import java.time.LocalDate;
import java.util.*;

public class MainTestOrder {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository =  context.getBean("orderRepository", OrderRepository.class);
    static OrderDetailRepository orderDetailRepository =  context.getBean("orderDetailRepository", OrderDetailRepository.class);
    static OrderEntityService orderEntityService = context.getBean("orderEntityService", OrderEntityService.class);
    static OrderDetailEntityService orderDetailEntityService = context.getBean("orderDetailEntityService", OrderDetailEntityService.class);
    private static OrdersEntity createNewOrders(){
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setOrderDate(LocalDate.now());
        ordersEntity.setCustomerName("Mai Truong");
        ordersEntity.setCustomerAddress("Da Nang City");
        return ordersEntity;

    }
   private static OrderDetailsEntity  createNewOrderDetails(){
       OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
       orderDetailsEntity.setQuantity(10);
       orderDetailsEntity.setProductName("abc");
       orderDetailsEntity.setUnitPrice(12.5);
       return orderDetailsEntity;
    }

    public static void createNewOrderWithOrderDetails(){
        OrdersEntity ordersEntity = createNewOrders();
        orderRepository.save(ordersEntity);

        OrderDetailsEntity orderDetailsEntity = createNewOrderDetails();
        orderDetailsEntity.setOrderId(ordersEntity);
        orderDetailRepository.save(orderDetailsEntity);

    }
    public static void findAll(){
        List<OrdersEntity> ordersEntityList = orderEntityService.findAll();
        for(OrdersEntity order:ordersEntityList){
            System.out.println(order);
            order.getOrderDetailsEntity();
        }
    }

    public static void findAllById(int id){
        Optional<OrdersEntity> optionalOrder = orderEntityService.findById(id);
        if (optionalOrder.isPresent()) {
            OrdersEntity ordersEntity = optionalOrder.get();
            System.out.println(ordersEntity);
            ordersEntity.getOrderDetailsEntity();
        } else {
            System.out.println("Not found order with id = " + id);
        }
    }

    private static void findAllWithCurrentMonth(){
        LocalDate currentDate = LocalDate.now();
        Integer month = currentDate.getMonthValue();
        List<OrdersEntity> orders = orderEntityService.findAllByOrderDate_Month(month);
        if(!orders.isEmpty()){
            System.out.println("List all the orders in the current month "+month);
            for(OrdersEntity order:orders){
                System.out.println(order);
                order.getOrderDetailsEntity();
            }
        } else {
            System.out.println("Not found order in the current month "+month);
        }
    }

    public static void findAllByPriceGreaterThan(double price){
        List<OrdersEntity> ordersEntityList = orderEntityService.findAll();
        Map<OrdersEntity,Double> map=new HashMap<>();
        for (OrdersEntity order: ordersEntityList){
            List<OrderDetailsEntity> orderDetails = (List<OrderDetailsEntity>) order.getOrderDetailsEntity();
            double total= orderDetails.stream().mapToDouble(orderDetail->orderDetail.getUnitPrice()*orderDetail.getQuantity()).sum();
            if(total>price) map.put(order,total);
        }
        if(!map.isEmpty()){
            System.out.println("List all orders which have total amount more than 1,000USD");
            map.forEach((order,total)->
                    System.out.println(order + " with total "+ total));
        } else {
            System.out.println("Not found list all orders which have total amount more than 1,000USD");
        }
    }

    public static void findAllByProductName(String name){
        List<OrdersEntity> orders=orderEntityService.findAllByOrderDetailProductName(name);
        if(!orders.isEmpty()){
            System.out.println(String.format("List all orders buy %s book", name));
            System.out.println(orders);
        } else {
            System.out.println(String.format("Not found list all orders buy %s book", name));
        }
    }
//    public static void getAll(){
//        List<OrdersEntity> ordersEntityList =  orderRepository.getAll();
//        if (ordersEntityList != null) {
//            System.out.println("Find  " + ordersEntityList.size() + "  orders");
//            for (OrdersEntity orders : ordersEntityList) {
//                System.out.println(orders.toString());
//            }
//
//        }
//    }
//    public static void main(String[] args) {
////        createNewOrderWithOrderDetails();
//        findAll();
////        findAllById(1);
////        findAllWithCurrentMonth();
////        findAllByPriceGreaterThan(1000);
////        findAllByProductName("hihi");
//
//
//
//
//
//    }

}
