package model;

public class items {
	
	private int id;
    private String name;
    private int price;
    private int totalNumber;



    // Parameterized constructor
    public items(int id, String name, int price, int totalNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalNumber=" + totalNumber +
                '}';
    }

}
