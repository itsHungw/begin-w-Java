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
public class TextBook extends Book{
    private String condition;

    public TextBook(String bookCode, Date entryDate, double unitPrice, int quanity, String publisher, String condition) {
        super(bookCode, entryDate, unitPrice, quanity, publisher);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    @Override
   public double calculateTotalAmount(){
       double total = 0;
       return total = quanity * this.unitPrice;
   } 

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        
        return "Text Book {" + "bookCode = " + bookCode 
           + ", entryDate = " +dateFormat.format(entryDate)  
           + ", unitPrice = " + unitPrice 
           + ", quanity = " + quanity 
           + ", publisher = " + publisher 
           +", Condittion = " +condition 
           +", TOTAL = " +calculateTotalAmount() +'}';
    
    }

   
}
