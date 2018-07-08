
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class RUVOS {
   boolean canDrive=true;
   boolean isCritical=false;
  private ArrayList<SafetyTst> safetytsts= new ArrayList<>();
  String currentDriver;
  private Radio radio= new Radio();
  private MechMonitor m;
  private DrugTst dt;
  public RUVOS(){
      
      System.out.println("RUVOS initialized... "); 
      System.out.println(""+canDrive+"... canDrive");
      System.out.println("Current Driver: "+currentDriver);
      
       
   
}
   public void attach(SafetyTst t){
       safetytsts.add(t);
       
   }
   
  public void attach(Radio r){
      radio=r;
  }
  
  public void whoIsDriving(String driver){
      currentDriver=driver;
  }
   
  public void startRadio(){
      radio.turnOn();
  }
  
  public void stopRadio(){
      radio.turnOff();
  }
  
  public String getSong(){
      
      return radio.toString();
  }
   public void attachMech(MechMonitor m){
       this.m=m;
   }
   public void attachDrugTst(DrugTst dt){
       this.dt=dt;
   }
   
   public void notifyObservers(){
       int i=1;
       System.out.println("UPDATING SYSTEM");
       for(SafetyTst t: safetytsts){
           System.out.println("Loop #..."+i);
           ++i;
           t.update();
       }
   }
   public void notifyMechTest(double gas){
       m.update(gas);
   }
   
   public boolean isCritical(){
       
       return isCritical;
       
   }
   
   public void setCritical(){
       isCritical=true;
   }
   
   public void setSafe(Boolean check){
       canDrive=canDrive&&check;
   }
   
   public boolean isSafe(){
       return canDrive;
   }
  
   public DrugTst getDrug(){
       return dt;
   }
   public void SafetyCheck(){
       
       notifyObservers();
   }
   public void CheckMech(double gas){
      
       notifyMechTest(gas);
   }
   
 
    
    
}
