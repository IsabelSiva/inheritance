package app;

import product.ImportedProduct;
import product.Product;
import product.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Aplication {
    public static void main(String[]meh) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        int productsNumber;

        System.out.print("Enter the number of products: ");
        productsNumber = sc.nextInt();
        for (int i = 0; i < productsNumber; i++) {
            System.out.println("Enter #" + (i + 1) + " data: ");
            System.out.println("Common, used or imported? (c,u,i)");
            sc.next();
            String c = sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (c.equals("c")){
                products.add(new Product(name, price));
            }
            if (c.equals("i")){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }
            if (c.equals("u")){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String sdate = sc.nextLine();
                Date date = sdf.parse(sdate);
                products.add(new UsedProduct(name, price, date));
            }
        }
        for (Product product : products){
            System.out.print(product.priceTag() + "\n");
        }

    }
}
