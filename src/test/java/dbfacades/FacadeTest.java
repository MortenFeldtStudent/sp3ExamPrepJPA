package dbfacades;

import entity.Customer;
import entity.ItemType;
import entity.OrderLine;
import entity.Orders;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * UNIT TEST example that mocks away the database with an in-memory database See
 * Persistence unit in persistence.xml in the test packages
 *
 * Use this in your own project by: - Delete everything inside the setUp method,
 * but first, observe how test data is created - Delete the single test method,
 * and replace with your own tests
 *
 */
public class FacadeTest {

    EntityManagerFactory emf;
    EntityManager em;
    DemoFacade facade;

    /**
     * Setup test data in the database to a known state BEFORE Each test
     */
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("pu-test", null);
        facade = new DemoFacade(emf);
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            //Delete all, since some future test cases might add/change data
            //em.createQuery("DELETE FROM Car").executeUpdate();
            //Add our test data
            Customer customer1 = new Customer("Morten1", "Feldt1");
            Customer customer2 = new Customer("Morten2", "Feldt2");
            
            Orders order = new Orders();
            
            OrderLine orderLine1 = new OrderLine(5);
            OrderLine orderLine2 = new OrderLine(10);
            
            ItemType itemType1 = new ItemType("Name1", "Description1", 10);
            ItemType itemType2 = new ItemType("Name2", "Description2", 20);
            ItemType itemType3 = new ItemType("Name3", "Description3", 30);
            
            em.persist(customer1);
            em.flush();
            em.persist(customer2);
            em.flush();
            
            em.persist(order);
            
            customer2.addOrder(order);
            em.merge(customer2);
            
            em.persist(orderLine1);
            em.flush();
            em.persist(orderLine2);
            em.flush();
            
            order.addOrderLine(orderLine1);
            em.merge(order);
       
            orderLine1.setItemType(itemType1);
            orderLine1.setItemType(itemType2);
            orderLine1.setItemType(itemType3);
            em.merge(orderLine1);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @After
    public void tearDown() {
        emf.close();
    }
  
  //Create a Customer
  @Test
  public void createCustomer(){
      Customer customer = new Customer("Morten3", "Feldt3");
      Customer customerPersist = facade.createCustomer(customer);
      int actual = customerPersist.getId();
      int expected = 3;
      Assert.assertEquals(expected, actual);
  }
  
  //Find a Customer
  @Test
  public void getCustomer(){
      int customerId = 1;
      Customer customer = facade.getCustomer(customerId);
      int actual = customer.getId();
      int expected = 1;
      Assert.assertEquals(expected, actual);
  }
  
  //Get all Customers
  @Test
  public void getAllCustomer(){
      int actual = facade.getAllCustomers().size();
      int expected = 2;
      Assert.assertEquals(expected, actual);
  }
  
  //Create an Order
  @Test
  public void createOrder(){
      Orders order = new Orders();
      Orders orderPersist = facade.createOrder(order);
      int actual = orderPersist.getId();
      int expected = 2;
      Assert.assertEquals(expected, actual);
  }
  
  //Add an Order to a Customer
  @Test
  public void addOrderToCustomer(){
      Customer customer = em.find(Customer.class, 1);
      Orders order = em.find(Orders.class, 1);
      Customer customerMerged = facade.addOrderToCustomer(customer, order);
      int actual = customerMerged.getOrders().get(0).getId();
      int expected = 1;
      Assert.assertEquals(expected, actual);
  }
  
  //Find an Order
  @Test
  public void getOrder(){
      int orderId = 1;
      Orders order = facade.getOrder(orderId);
      int actual = order.getId();
      int expected = 1;
      Assert.assertEquals(expected, actual);
  }
  
  //Find all Orders, for a specific Customer
  @Test
  public void getOrdersForCustomer(){
      Customer customer = em.find(Customer.class, 2);
      int actual = facade.getOrdersForCustomer(customer).size();
      int expected = 1;
      Assert.assertEquals(expected, actual);
  }
  
  //Create an OrderLine, and add it to an Order
  @Test
  public void createOrderLineAddToOrder(){
      OrderLine orderLine = new OrderLine(2);
      Orders order = em.find(Orders.class, 1);
      //order.addOrderLine(orderLine);
      int actual = facade.createOrderLineAddToOrder(orderLine, order).getOrderLines().size();
      int expected = 2;
      Assert.assertEquals(expected, actual);
  }
  
  //Create an ItemType, and add it to an OrderLine
  @Test
  public void createItemTypeAddToOrderLine(){
      ItemType itemType = new ItemType("Name1", "Description1", 10);
      OrderLine orderLine = em.find(OrderLine.class, 2);
      //orderLine.setItemType(itemType);
      int actual = facade.createItemTypeAddToOrderLine(itemType, orderLine).getId();
      int expected = 4;
      Assert.assertEquals(expected, actual);
  }
  
  //Find the total price of an order
  @Test
  public void getTotalPriceFromOrder(){
      Orders order = em.find(Orders.class, 1);
      int actual = facade.getTotalPriceFromOrder(order);
      int expected = 300;
      Assert.assertEquals(expected, actual);      
  }

  /**
   * Setup test data in the database to a known state BEFORE Each test
   */
//  @Before
//  public void setUp() {
//    EntityManager em = emf.createEntityManager();
//    try {
//      em.getTransaction().begin();
//      //Delete all, since some future test cases might add/change data
//      em.createQuery("delete from Car").executeUpdate();
//      //Add our test data
//      Car e1 = new Car("Volve");
//      Car e2 = new Car("WW");
//      em.persist(e1);
//      em.persist(e2);
//      em.getTransaction().commit();
//    } finally {
//      em.close();
//    }
//  }

  // Test the single method in the Facade
//  @Test
//  public void countEntities() {
//    long count = facade.countCars();
//    Assert.assertEquals(2, count);
//  }

}
