
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class DrugTst extends SafetyTst{
 
    private String answers="";
    private String tstAnswers="yesnoyesracecar";
    private String questions="";
    private int tstSelc;
    private boolean DTPass;
  
    int age;
    public DrugTst(int age, RUVOS sys){
        this.sys=sys;
        this.sys.attach(this);
        
        
    }
    
    
    @Override
   public void distributeTest(){
    
       
   }
 public boolean collectResults(){
  
   
           if(tstAnswers.equalsIgnoreCase(this.answers)){
                    DTPass=true;
                  return DTPass;
              }
         
        
           else {
               DTPass=false;
               
               return DTPass;
                  }
          
 }
 
 public void grabAnswers(String input){
     answers=input;
 }

public void update(){
    //distributeTest();
    if(age<25){
    sys.setSafe(collectResults());
    }
    else{
        sys.setSafe(true);
    }
}

 
}
