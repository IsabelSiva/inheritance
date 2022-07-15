package app;

import product.ImportedProduct;
import product.Product;
import product.UsedProduct;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Aplication {
    public static void main(String[]meh) throws ParseException {
        Locale.setDefault(Locale.US);
        DateFormat format = new SimpleDateFormat ("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        int productsNumber;

        System.out.print("Enter the number of products: ");
        productsNumber = sc.nextInt();
        for (int i = 0; i < productsNumber; i++) {
            System.out.println("Enter #" + (i + 1) + " data: ");
            System.out.println("Common, used or imported? (c,u,i)");
            char c = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (c == 'c'){
                products.add(new Product(name, price));
            }
            if (c == 'i'){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }
            if (c == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                String sdate = sc.nextLine();
                Date date = format.parse(sdate);
                products.add(new UsedProduct(name, price, date));
            }
        }
        System.out.println("  PRICE TAGS  ");
        for (Product product : products){
            System.out.print(product.priceTag() + "\n");
        }

    }
}
