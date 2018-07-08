/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class MechMonitor extends SafetyTst {
    
    private double gasReading=100;
    private boolean testPassed=true;
    public MechMonitor(RUVOS sys, Vehicle v){
        this.sys=sys;
        sys.attach(this);
        sys.attachMech(this);
    }
    
       public void distributeTest(){
           
           if(this.gasReading<23){
            sys.setCritical();
            }
           if(this.gasReading==0){
               testPassed=false;
           }
    }
    
    public boolean collectResults(){
     
        return testPassed;
    }
    
public void update(){
    distributeTest();
    sys.setSafe(collectResults());
}

public void update(double gasReading){
    this.gasReading=gasReading;
    System.out.println("Your gas tank is "+gasReading+"% full.");
    distributeTest();
    
}
    
    
    
    
}
