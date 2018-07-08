/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class Driver {
    String name;
    int age;
    
    public Driver(String name, int age){
        if(age<16){
            throw new IllegalArgumentException("This driver is not eligible for driving..");
        }
        
    }
    
    public int getAge(){
        return age;
    }
    
    public String whoAmI(){
        return name;
    }
    
    
    
}
