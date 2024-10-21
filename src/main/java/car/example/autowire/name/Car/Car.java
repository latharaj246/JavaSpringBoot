package car.example.autowire.name.Car;

public class Car {
//Step 1
    private Specification specification;

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public void displayDetails(){
        System.out.println("Car Details" + specification.toString());

    }

}
