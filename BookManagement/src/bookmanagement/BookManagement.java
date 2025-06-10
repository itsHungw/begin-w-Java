/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookmanagement;

import data.Book;
import data.ReferenceBook;
import data.TextBook;
import java.util.Date;

/**
 *
 * @author vinhu
 */
public class BookManagement {

    public static void main(String[] args) {
        TextBook nerd = new TextBook("TX123", new Date(), 100, 10, "ABC Publishing", "new");
        ReferenceBook haha = new ReferenceBook("RB456", new Date(), 200, 5, "XYZ Publishing", 50);
        
        Book[] books = {nerd, haha};
        for (Book x : books) {
            System.out.println(x.toString());
        }
    }
    
}
