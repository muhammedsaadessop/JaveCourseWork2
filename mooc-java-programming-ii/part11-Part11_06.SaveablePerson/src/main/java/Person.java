public class Person implements Saveable {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void save() {
        System.out.println("Saving person: " + name + " at " + address);
    }

    @Override
    public void delete() {
        System.out.println("Deleting person: " + name);
    }

    @Override
    public void load(String address) {
        this.address = address;
        System.out.println("Loading person from address: " + address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
