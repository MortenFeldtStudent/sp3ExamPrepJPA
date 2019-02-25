package dbfacades;

import entity.Customer;
import entity.ItemType;
import entity.OrderLine;
import entity.Orders;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
            System.out.println(customer.getId());
            return customer;
        } finally {
            em.close();
        }
  }
  
  //Find a Customer
  public Customer getCustomer(int customerId){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  
  //Get all Customers
  public List<Customer> getAllCustomers(){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  
  //Create an Order
  public Orders createOrder(Orders order){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  
  //Add an Order to a Customer
  public Customer addOrderToCustomer(Customer customer, Orders order){
      throw new UnsupportedOperationException("Method not implemented!");
  }
  
  //Find an Order
  public Orders getOrder(int orderId){
      throw new UnsupportedOperationException("Method not implemented!");
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
