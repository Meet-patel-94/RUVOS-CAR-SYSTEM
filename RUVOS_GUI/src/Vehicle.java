
import java.awt.event.KeyEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public abstract class Vehicle implements Vehicle_Operation{
    final protected int maxspeed=100;
    final protected int minspeed=0;
    final protected int maxreverse=-30;
    
    protected RUVOS sys= new RUVOS();
    protected Radio radio;
    private double gasMeter = 100;
    private double speed=0;
    private boolean isParked=false;
   
    public void start(){
        
        System.out.println("Starting...");
        
       
    }
    
    public String park(){
        if(speed==0){
        System.out.println("Parking..");
        isParked=true;
        return "Parking...";
        }
        else{
            System.out.println("Please apply brake until you movement stops...");
            return "Please apply brake until you movement stops...";
        }
    }
    public String right(){
        
        System.out.println("Turning Right");
        return "Turning Right";
    }
    
    public String coast(){
        System.out.println("Coasting at: "+speed);
  
        return "Coasting at: "+speed;
    }
    
   
    public String reverse(){
        if(sys.isCritical){
            return braking();
        }
        else
        if(speed>maxreverse&&speed<=0&&!isParked){
        System.out.println("Reversing..."+(-speed));
        speed=speed-1;
        gasMeter=gasMeter-0.1;
        notifyMechMon();
        return "Reversing..."+(-speed);
        }
        else
        if(speed==maxreverse){
            
        return coast();
        }
        else
        return "";
        
    }
    public String left(){
        System.out.println("Turning Left");
        return "Turning Left";
    }
    
    public boolean isParked(){
        return isParked;
    }
    
    public String braking(){
        if(speed<=maxspeed&&speed>0){
        
        speed=speed-1;
        System.out.println("Braking..."+speed);
        return "Braking..."+speed;
        }
        if(speed<0&&speed>=maxreverse){
            
            speed=speed+1;
            System.out.println("Braking..."+speed);
            return "Braking..."+speed;
        }
        if(speed==0){
            System.out.println("Car is not in motion... brake applied.");
            return "Car is not in motion... brake applied.";
        }
        else
            return"";
    }
    
    public String accelerate(){
          if(sys.isCritical()){
            return braking();
        }
          else
        
        if(speed<maxspeed&&speed>=0&&!isParked){
            
        System.out.println("Accelerating");
        gasMeter=gasMeter-0.01;
        speed=speed+1;
        System.out.println(speed+"km/h");
        notifyMechMon();
        return "Accelerating: "+speed+"km/h";
        }
        else
            return coast();
        
        
        
    }
    
    public void shutDown(){
        System.out.println("System shutting down");
    }
   
    public String speed(){
        return ""+speed+"km/h";
    }
    public double doubleSpeed(){
        return speed;
    }
    
    
    public String gasMeter(){
        return ""+String.format("%.2f",gasMeter)+"%";
    }
    protected void notifyMechMon(){
        System.out.println("Going to MechMon");
        sys.CheckMech(gasMeter);
        
        
    }
}
