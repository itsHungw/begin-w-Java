/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vinhu
 */
public class ReferenceBook extends Book{
   private final double tax;

    public ReferenceBook(String bookCode, Date entryDate, double unitPrice, int quanity, String publisher, double tax) {
        super(bookCode, entryDate, unitPrice, quanity, publisher);
        this.tax = tax;
    }
   
    
    
   @Override
   public double calculateTotalAmount(){
       double total = 0;
       return total = quanity * this.unitPrice + tax;
   } 

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Reference Book {" + "bookCode = " + bookCode 
           + ", entryDate = " +dateFormat.format(entryDate) 
           + ", unitPrice = " + unitPrice 
           + ", quanity = " + quanity 
           + ", publisher = " + publisher 
           +", Tax = " +tax 
           +", TOTAL = " +calculateTotalAmount() +'}';
    
    }
   
   
}
