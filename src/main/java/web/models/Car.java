package web.models;

public class Car {
    private String user;
    private String model;
    private int series;

    public Car() {}

    public Car(String user, String model, int series) {
        this.user = user;
        this.model = model;
        this.series = series;
    }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getSeries() { return series; }
    public void setSeries() { this.series = series; }

}
