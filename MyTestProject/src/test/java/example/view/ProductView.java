package org.example.view;

import org.example.controller.ProductController;
import org.example.model.ProductModel;
import org.example.service.ProductService;
import org.example.uitis.rowManager;
import org.nocrala.tools.texttablefmt.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private final ProductService ps;
    private final ProductController pc;
    private int recordsPerPage;
    private int currentPage = 1;
    private int totalPages;

    public ProductView(ProductService ps, ProductController pc) throws SQLException {
        this.ps = ps;
        this.pc = pc;
        this.recordsPerPage = rowManager.getRecordsPerPage();
        this.totalPages = ps.getTotalPages(recordsPerPage);
    }

    public void setRecordsPerPage(int records) throws SQLException {
        this.recordsPerPage = records;
        rowManager.setRecordsPerPage(records);
        this.totalPages = ps.getTotalPages(recordsPerPage);
        this.currentPage = 1;
    }

    public void showMenu() throws SQLException {
        List<ProductModel> products = ps.getProductsByPage(currentPage, recordsPerPage);
        totalPages = ps.getTotalPages(recordsPerPage);

        Table productTable = new Table(5, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
        CellStyle center = new CellStyle(CellStyle.HorizontalAlign.CENTER);

        productTable.setColumnWidth(0, 10, 20);
        productTable.setColumnWidth(1, 20, 20);
        productTable.setColumnWidth(2, 10, 20);
        productTable.setColumnWidth(3, 10, 20);
        productTable.setColumnWidth(4, 20, 20);

        productTable.addCell("ID", center);
        productTable.addCell("Name", center);
        productTable.addCell("Unit Price", center);
        productTable.addCell("Quantity", center);
        productTable.addCell("Import Date", center);

        for (ProductModel product : products) {
            productTable.addCell(String.valueOf(product.getId()), center);
            productTable.addCell(product.getProduct_name(), center);
            productTable.addCell(String.format("%.2f", product.getUnit_price()), center);
            productTable.addCell(String.valueOf(product.getQuantity()), center);
            productTable.addCell(product.getImportdate() != null ? product.getImportdate().toString() : "N/A", center);
        }

        productTable.addCell("Page: " + currentPage + "/" + totalPages, center, 2);
        productTable.addCell("Total Records: " + ps.getTotalRecords(), center, 3);

        System.out.println(productTable.render());
        displayMenu();
    }

    private void displayMenu() {
        System.out.println("________________Menu________________");
        System.out.println("N) Next    P) Previous    F) First    L) Last    G) Goto");
        System.out.println("W) Write    R) Read    U) Update    D) Delete    S) Search");
        System.out.println("Sa) Save    Un) Unsaved    Ba) Backup    Re) Restore    Se) Set Rows    E) Exit");
        System.out.println("-----------------------------------");
    }

    public void setCurrentPage(int page) throws SQLException {
        if (page >= 1 && page <= totalPages) {
            currentPage = page;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }
}
