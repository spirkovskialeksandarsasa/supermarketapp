public class Product implements Comparable<Product> {

    private String name;
    private boolean domestic;
    private double price;
    private double weight = 0;
    private String description;

    public Product(String name, boolean domestic, double price, double weight, String description) {
        this.name = name;
        this.domestic = domestic;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }

    public Product(String name, boolean domestic, double price, String description) {
        this.name = name;
        this.domestic = domestic;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDomestic() {
        return domestic;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {

        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        if (description.length() > 10) {
            return description.substring(0, 10) + "...";
        } else return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "\n" +
                price + "\n"
                + weight + "\n " +
                description + "\n"
                + domestic
                + "\n";
    }

    @Override
    public int compareTo(Product o) {
        return name.compareTo(o.name);
    }
}

