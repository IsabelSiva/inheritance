package product;

public class ImportedProduct extends Product{
    public Double customsFee;

    public ImportedProduct(){}
    public ImportedProduct(String name, Double price, Double customsFee){
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public Double totalPrice(){
        return price + customsFee;
    }

    @Override
    public String priceTag(){
        StringBuilder st = new StringBuilder();
        st.append(name + " $" + totalPrice() + "(Customs fee: $" + customsFee + ")");

        return st.toString();
    }
}
