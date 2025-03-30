package example.uitis;

import org.example.model.ProductModel;
import org.example.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class PaginationUtils {
    private int recordsPerPage = 5; // Default records per page
    private int currentPage = 1;
    private final ProductService productService;

    public PaginationUtils(ProductService productService) {
        this.productService = productService;
    }

    public int getTotalRecords() throws SQLException {
        return productService.getProductsForPage();
    }

    public int getTotalPages() throws SQLException {
        return (int) Math.ceil((double) getTotalRecords() / recordsPerPage);
    }

    public List<ProductModel> getProductsForCurrentPage() throws SQLException {
        return productService.getProductsForPage(currentPage, recordsPerPage);
    }

    public void goToNextPage() throws SQLException {
        if (currentPage < getTotalPages()) {
            currentPage++;
        }
    }

    public void goToPreviousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
    }

    public void goToFirstPage() {
        currentPage = 1;
    }

    public void goToLastPage() throws SQLException {
        currentPage = getTotalPages();
    }

    public void setRecordsPerPage(int newRecordsPerPage) {
        if (newRecordsPerPage > 0) {
            recordsPerPage = newRecordsPerPage;
            currentPage = 1; // Reset to first page
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }
}
