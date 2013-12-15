/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Team 997
 */
public class driveTrainHalf extends Subsystem {
    private Victor myVictor;
    private Encoder myEncoder;
    public driveTrainHalf (int slot1,int Eslot1,int Eslot2){
        myVictor = new Victor(slot1);
        myEncoder = new Encoder(Eslot1,Eslot2);
        
    }
    public void setSpeed(double speed){
        myVictor.set(speed);
    }
    public double getEncoder() {
        return myEncoder.get();
    }
    public void resetEncoder() {
        myEncoder.start();
        myEncoder.reset();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
