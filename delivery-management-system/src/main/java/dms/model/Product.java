package dms.model;

/**
 *
 * @author Javidan
 */
public class Product {

    private int id;
    private byte[] image;
    private String name;
    private float price;

    public Product(int id, byte[] image, String name, float price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", image=" + image + ", name=" + name + ", price=" + price + '}';
    }

}
