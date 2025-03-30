package example.controller;

import org.example.service.ProductService;
import org.example.uitis.ProductUtils;
import org.example.view.ProductView;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductController {
    private final ProductService service;
    private final ProductUtils utils;
    private final Scanner sc = new Scanner(System.in);

    public ProductController(ProductService service, ProductUtils utils) throws SQLException {
        this.service = service;
        this.utils = utils;
    }

    public void choice(ProductView view) throws SQLException {
        String input = sc.nextLine().toUpperCase();
        switch (input) {
            case "N": view.setCurrentPage(view.getCurrentPage() + 1); break;
            case "P": view.setCurrentPage(view.getCurrentPage() - 1); break;
            case "F": view.setCurrentPage(1); break;
            case "L": view.setCurrentPage(service.getTotalPages(view.getRecordsPerPage())); break;
            case "G": utils.Goto(); break;
            case "W": utils.Write(); break;
            case "R": utils.ReadID(); break;
            case "U": utils.Update(); break;
            case "D": utils.Delete(); break;
            case "S": utils.SearchName(); break;
            case "SE": utils.SetRow(); break;
            case "SA": utils.Save(); break;
            case "UN": utils.Unsaved(); break;
            case "BA": utils.Backup(); break;
            case "RE": utils.Restore(); break;
            case "E": System.exit(0);
            default: System.out.println("Invalid option");
        }
    }
}