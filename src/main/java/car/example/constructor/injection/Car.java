package car.example.constructor.injection;

public class Car {
//Step 1
    private Specification specification;
    // create a obj

    //Constructer
    //look for the bean and create one
    public Car(Specification specification) {
        this.specification = specification;
    }

    public void displayDetails(){
        System.out.println("Car Details" + specification.toString());

    }

}
