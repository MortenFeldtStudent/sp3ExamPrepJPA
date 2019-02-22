package dbfacades;

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
