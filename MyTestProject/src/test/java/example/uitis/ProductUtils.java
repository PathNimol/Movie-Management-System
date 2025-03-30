package org.example.uitis;

import org.example.model.ProductModel;
import org.example.service.ProductService;
import org.example.view.ProductView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductUtils {
    private final Scanner sc = new Scanner(System.in);
    private final ProductService productService;
    private final ProductView view;

    public ProductUtils(ProductService productService, ProductView view) {
        this.productService = productService;
        this.view = view;
    }

    public void Next() throws SQLException {
        view.setCurrentPage(view.getCurrentPage() + 1);
    }

    public void Previous() throws SQLException {
        view.setCurrentPage(view.getCurrentPage() - 1);
    }

    public void First() throws SQLException {
        view.setCurrentPage(1);
    }

    public void Last() throws SQLException {
        view.setCurrentPage(productService.getTotalPages(view.getRecordsPerPage()));
    }

    public void Goto() throws SQLException {
        System.out.print("Enter page number: ");
        int page = ValidationUtils.validateNumber();
        view.setCurrentPage(page);
    }

    public void Write() {
        productService.create();
    }

    public void ReadID() throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = ValidationUtils.validateNumber();
        ProductModel product = productService.getProductById(id);
        if (product != null) {
            System.out.printf("ID: %d, Name: %s, Price: %.2f, Quantity: %d, Date: %s%n",
                    product.getId(), product.getProduct_name(), product.getUnit_price(),
                    product.getQuantity(), product.getImportdate());
        } else {
            System.out.println("Product not found.");
        }
    }

    public void Update() throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = ValidationUtils.validateNumber();
        ProductModel product = productService.getProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Current: " + product);
        System.out.println("1) Name\n2) Price\n3) Quantity");
        System.out.print("Choose field to update (1-3): ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.print("New Name: ");
                product.setProduct_name(sc.nextLine());
                break;
            case 2:
                System.out.print("New Price: ");
                product.setUnit_price(Double.parseDouble(sc.nextLine()));
                break;
            case 3:
                System.out.print("New Quantity: ");
                product.setQuantity(Integer.parseInt(sc.nextLine()));
                break;
            default:
                System.out.println("Invalid option");
                return;
        }
        productService.addUnsavedUpdatedProduct(product);
        System.out.println("Update queued. Use 'Sa' to save.");
    }

    public void Delete() throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = ValidationUtils.validateNumber();
        productService.delete(id);
    }

    public void SearchName() throws SQLException {
        System.out.print("Enter product name to search: ");
        String name = sc.nextLine();
        List<ProductModel> results = productService.searchByName(name);
        if (results.isEmpty()) {
            System.out.println("No products found.");
        } else {
            results.forEach(p -> System.out.printf("ID: %d, Name: %s, Price: %.2f, Quantity: %d%n",
                    p.getId(), p.getProduct_name(), p.getUnit_price(), p.getQuantity()));
        }
    }

    public void SetRow() throws SQLException {
        System.out.print("Enter records per page: ");
        int records = ValidationUtils.validateNumber();
        view.setRecordsPerPage(records);
    }

    public void Save() throws SQLException {
        productService.saveToDatabase();
    }

    public void Unsaved() {
        System.out.println("UI) Unsaved Insert\nUU) Unsaved Update");
        String choice = sc.nextLine().toUpperCase();
        if ("UI".equals(choice)) {
            productService.displayUnsavedInsertedProducts();
        } else if ("UU".equals(choice)) {
            productService.displayUnsavedUpdatedProducts();
        } else {
            System.out.println("Invalid option");
        }
    }

    public void Backup() throws SQLException {
        productService.backup();
    }

    public void Restore() throws SQLException {
        productService.restore();
    }
}
