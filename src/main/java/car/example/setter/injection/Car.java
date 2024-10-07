package car.example.setter.injection;

public class Car {
//Step 1
    private Specification specification;
    // create a obj

//Setter
    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public void displayDetails(){
        System.out.println("Car Details" + specification.toString());

    }

}
