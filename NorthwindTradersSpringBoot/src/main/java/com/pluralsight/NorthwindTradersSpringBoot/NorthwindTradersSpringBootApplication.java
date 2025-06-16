package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

        ProductDAO productDAO = context.getBean(SimpleProductDAO.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nProduct Admin Menu:");
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    List<Product> products = productDAO.getAll();
                    products.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    productDAO.add(new Product(id, name, category, price));
                    System.out.println("Product added.");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
