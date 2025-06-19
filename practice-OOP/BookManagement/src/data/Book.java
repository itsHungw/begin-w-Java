/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Date;

/**
 *
 * @author vinhu
 */
public class Book {
    protected String bookCode;
    protected Date entryDate;
    protected double unitPrice;
    protected int quanity;
    protected String publisher;

    public Book(String bookCode, Date entryDate, double unitPrice, int quanity, String publisher) {
        this.bookCode = bookCode;
        this.entryDate = entryDate;
        this.unitPrice = unitPrice;
        this.quanity = quanity;
        this.publisher = publisher;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
   
   public double calculateTotalAmount(){
       double total = 0;
       return total += this.unitPrice;
   } 

    @Override
    public String toString() {
        return "Book{" + "bookCode=" + bookCode + ", entryDate=" + entryDate + ", unitPrice=" + unitPrice + ", quanity=" + quanity + ", publisher=" + publisher + '}';
    }
   
   
}
