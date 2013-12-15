/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 997
 */
public class Pneumatics extends Subsystem {
    private Solenoid kickerSolenoid;
    private Solenoid dumperSolenoid;
    private Solenoid kickerSolenoid2;
    private Solenoid dumperSolenoid2;
    private Compressor myCompressor;
    public Pneumatics(
            int moduleNumber,
            int kickerslot1,
            int kickerslot2,
            int dumperslot1, 
            int dumperslot2, 
            int compressorslot1, 
            int compressorslot2){
        kickerSolenoid = new Solenoid(moduleNumber,kickerslot1);
        dumperSolenoid = new Solenoid(moduleNumber,dumperslot1);
        kickerSolenoid2 = new Solenoid(moduleNumber,kickerslot2);
        dumperSolenoid2 = new Solenoid(moduleNumber,dumperslot2);
        myCompressor = new Compressor(compressorslot1,compressorslot2);
       compressorOn();
    }
   
    public void extendkicker(){
    kickerSolenoid.set(true);
    kickerSolenoid2.set(false);
    }
    
    public void retractkicker(){
        kickerSolenoid.set(false);
        kickerSolenoid2.set(true);
    }
    
    public void extenddumper(){
        dumperSolenoid.set(true);
        dumperSolenoid2.set(false);
    }
    
    public void retractdumper(){
        dumperSolenoid.set(false);
        dumperSolenoid2.set(true);
    }
    
    public void CommpressorOff() {
        myCompressor.stop();
    }
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
              
    }
    
    public void smartdashboard(){
        SmartDashboard.putData("pnuematics info", this);
        SmartDashboard.putBoolean("compressor is full", myCompressor.getPressureSwitchValue());
    }

    public void compressorOn() {
        myCompressor.start();
    }
}
