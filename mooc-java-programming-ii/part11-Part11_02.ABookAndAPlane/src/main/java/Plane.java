public class Plane {
    private String ID;
    private String model;
    private int yearOfIntroduction;

    public Plane(String ID, String model, int yearOfIntroduction) {
        this.ID = ID;
        this.model = model;
        this.yearOfIntroduction = yearOfIntroduction;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfIntroduction() {
        return yearOfIntroduction;
    }

    public void setYearOfIntroduction(int yearOfIntroduction) {
        this.yearOfIntroduction = yearOfIntroduction;
    }

    @Override
    public String toString() {
        return "Plane{ID='" + ID + "', model='" + model + "', yearOfIntroduction=" + yearOfIntroduction + "}";
    }
}
