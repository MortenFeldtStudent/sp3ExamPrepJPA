package dbfacades;

import entity.Customer;
import entity.ItemType;
import entity.OrderLine;
import entity.Orders;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/*
Simple Facade demo for this start-up project
 Use this in your own project by:
  - Rename this class to reflect your "business logic"
  - Delete the class entity.Car, and add your own entity classes
  - Delete the three public methods below, and replace with your own Facade Logic 
  - Delete all content in the main method

*/
public class DemoFacade {

  EntityManagerFactory emf;

  public DemoFacade(EntityManagerFactory emf) {
    this.emf = emf;
  }

  //Create a Customer
  public Customer createCustomer(Customer customer){
      EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
  }
  
  //Find a Customer
  public Customer getCustomer(int customerId){
      EntityManager em = emf.createEntityManager();

        try {
            Query q = em.createQuery("SELECT c FROM Customer c WHERE c.id = :id");
            q.setParameter("id", customerId);
            return (Customer) q.getSingleResult();
        } finally {
            em.close();
        }
  }
  
  //Get all Customers
  public List<Customer> getAllCustomers(){
      EntityManager em = emf.createEntityManager();

        try {
            List<Customer> customerList = new ArrayList();
            Query q = em.createQuery("SELECT c FROM Customer c");
            customerList = q.getResultList();
            return customerList;
        } finally {
            em.close();
        }
  }
  
  //Create an Order
  public Orders createOrder(Orders order){
      EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
            return order;
        } finally {
            em.close();
        }
  }
  
  //Add an Order to a Customer
  public Customer addOrderToCustomer(Customer customer, Orders order){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  
  //Find an Order
  public Orders getOrder(int orderId){
      EntityManager em = emf.createEntityManager();

        try {
            Query q = em.createQuery("SELECT o FROM Orders o WHERE o.id = :id");
            q.setParameter("id", orderId);
            return (Orders) q.getSingleResult();
        } finally {
            em.close();
        }
  }
  
  //Find all Orders, for a specific Customer
  public List<Orders> getOrdersForCustomer(Customer customer){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  
  //Create an OrderLine, and add it to an Order
  public Orders createOrderLineAddToOrder(OrderLine orderLine, Orders order){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  
  //Create an ItemType, and add it to an OrderLine
  public ItemType createItemTypeAddToOrderLine(ItemType itemType, OrderLine orderLine){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  
  //Find the total price of an order
  public Integer getTotalPriceFromOrder(Orders order){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  

  /*
  This will only work when your have added a persistence.xml file in the folder: 
     src/main/resources/META-INF
  You can use the file: persistence_TEMPLATE.xml (in this folder) as your template
  */
  public static void main(String[] args) {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//    DemoFacade df = new DemoFacade(emf);
//    df.addCar(new Car("Volvo"));
//    df.addCar(new Car("WW"));
//    df.addCar(new Car("Jaguar"));
//    long numbOfCars = df.countCars();
//    System.out.println("Number of cars: "+numbOfCars);
  }

}
