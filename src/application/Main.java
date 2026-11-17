package application;

import entities.Department;
import entities.Seller;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        new Date() ;

        Department dp = new Department(1, "RH");

        Seller sl = new Seller(1,"Thiago", "thiago@gmail.com",  new Date(), 1.000, dp);

        System.out.println(sl);
    }
}