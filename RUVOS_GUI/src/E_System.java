/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public abstract class E_System {
    
    
    
    public abstract boolean isOn();
    public abstract void turnOn();
    public abstract void turnOff();
    public String toString(){
        return "Now playing: ";
    }
}
