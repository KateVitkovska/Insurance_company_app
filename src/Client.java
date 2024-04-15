
public class Client extends ClientInput{
     private String fullName;
    private int age;

    public Client(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }
    public Client() {

    }

    public void getClientInfo() {
        System.out.println(this.fullName + ", " + this.age);
    }

}


