package product;

import java.util.Date;

public class UsedProduct extends Product{
    public Date manufactureDate;

    public UsedProduct() {}

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        StringBuilder st = new StringBuilder();
        st.append(name + "(used) $" +
                    price + " " + "(Manufacture date: " + getManufactureDate() + ")");

        return st.toString();
    }
}
