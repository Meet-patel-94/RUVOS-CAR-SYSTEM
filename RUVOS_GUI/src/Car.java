/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class Car extends Vehicle{
   
    protected DrugTst dt;
    protected MechMonitor mm;
    protected Driver currentDriver;
    
    public Car(Driver d){
        
       dt = new DrugTst(d.getAge(),this.sys);
       mm= new MechMonitor(this.sys, this);
       currentDriver=d;
       this.sys.whoIsDriving(currentDriver.whoAmI());
              
    }
    public void start(){
        sys.SafetyCheck();
        
        System.out.println("Safety pass? : "+sys.isSafe());
        if(!sys.isSafe()){
            System.out.println("RUVOS says: The car did not pass the safety inspection... call your dealership.");
            //System.exit(0);
        }
    }
    
    public boolean isOperational(){
        return sys.isSafe();
    }
    public void grabAnswer(String ans){
        dt.grabAnswers(ans);
    }
    
    public void startRadio(){
        sys.startRadio();
    }
    public void stopRadio(){
        sys.stopRadio();
    }
    public String getSong(){
        return sys.getSong();
    }
    
    
}
