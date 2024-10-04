package car.example.bean;

public class MyBean {
    //this is a bean which has message in it
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
