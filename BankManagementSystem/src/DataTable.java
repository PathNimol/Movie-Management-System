import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class DataTable {
    public enum BorderSytle{
        SIMPLE, // Simple border style with '+' corners and '-' horizontal/vertical lines
        DOUBLE, // Double border style with '+' corners and '=' horizontal/vertical lines
        PIPE  // Pipe border style with '+' corners and '-' horizontal lines, '|' vertical lines
    }

    ArrayList<String> columns;
    ArrayList<ArrayList<String>> rows;
    BorderSytle borderStyle;


    public DataTable(){
        this.borderStyle = BorderSytle.SIMPLE;
    }

    public void addColumn(String columnName){
        columns.add(columnName);

    }

    public void addRow(ArrayList<String> rowData){
        if(rowData.size() == columns.size()){
            rows.add(rowData);
        }else{
            JOptionPane.showMessageDialog(null, "Error: Row data size does not match the number of columns.");
        }
    }
    public void displayTable(){

        ArrayList<Integer>columnWidths = new ArrayList<>(Collections.nCopies(columns.size(),0));

        //Calculaate column widths based on content
        for(int i=0; i<columns.size(); i++){
            columnWidths.set(i, Math.max(columns.get(i).length(), columnWidths.get(i)));
            for(ArrayList<String>row: rows){
                columnWidths.set(i, Math.max(row.get(i).length(), columnWidths.get(i)));
            }
        }

        char corner, horizontalLine, verticalLine;

        //Set style based on BorderStyle
        switch (borderStyle) {
            case DOUBLE:
                corner = '+'; horizontalLine = '='; verticalLine = '|';
                break;
            case PIPE:
                corner = '+'; horizontalLine = '-'; verticalLine = '|';
                break;
            default:
                corner = '+'; horizontalLine = '-'; verticalLine = '|';
        }

        //Display top border
        System.out.print(corner);
        for(int width : columnWidths){
            for(int i = 0; i < width + 2; i++){
                System.out.print(horizontalLine);
            }
            System.out.print(corner);
        }
        System.out.println();

        //Display column header
        for(int i = 0; i < columns.size(); i++){
            System.out.print(" " + String.format("%-" + columnWidths.get(i) + "s", columns.get(i)) + " " + verticalLine);
        }

        //Display middle border
        System.out.print(corner);
        for(int width : columnWidths){
            for(int i = 0; i < width + 2; i++){
                System.out.print(horizontalLine);
            }
            System.out.print(corner);
        }
        System.out.println();

        // Display rows
        for (ArrayList<String> row : rows) {
            System.out.print(verticalLine);
            for (int i = 0; i < row.size(); i++) {
                System.out.print(" " + String.format("%-" + columnWidths.get(i) + "s", row.get(i)) + " " + verticalLine);
            }
            System.out.println();
        }

        // Display bottom border
        System.out.print(corner);
        for (int width : columnWidths) {
            for (int i = 0; i < width + 2; i++) {
                System.out.print(horizontalLine);
            }
            System.out.print(corner);
        }
        System.out.println();


    }
}
