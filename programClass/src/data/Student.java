/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author vinhu
 */
public class Student {
    public String code;
    public String name;
    int bYear;
    double mark;

    public Student(String code, String name, int bYear, double mark) {
        this.code = code;
        this.name = name;
        this.bYear = bYear;
        this.mark = mark;
    }
    
    public void output(){
        System.out.println(code +", " +name +", " +bYear +", " +mark);
        
        
    }

    
//    @Override
//    public String toString() {
//        return "Student{" + "code=" + code + ", name=" + name + ", bYear=" + bYear + ", address=" + address + '}';
//    }

    public double getMark() {
        return mark;
    }
    
    
}
