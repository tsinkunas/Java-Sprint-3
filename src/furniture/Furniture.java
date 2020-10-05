package furniture;

import java.util.ArrayList;

public class Furniture {
    private String type;
    private String name;
    private double price;
    private String description;

    public Furniture() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Furniture: " + type + ", name: " + name + ", price: " + price +
                "eur, description: " + description + "\n";
    }
}
