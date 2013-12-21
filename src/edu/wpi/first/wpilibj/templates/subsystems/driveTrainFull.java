/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.tankDrive;

/**
 *
 * @author Team 997
 */
public class driveTrainFull extends Subsystem {
private driveTrainHalf righthalf;
private driveTrainHalf lefthalf;
private Gyro myGyro;
private Ultrasonic myUltrasonic;
private AnalogChannel directVoltageGyro;
    private double CurrentGear = 1;

public driveTrainFull (int leftslot, int rightslot,int leftEslot1,int leftEslot2,int rightEslot1,int rightEslot2,int GSlot){
lefthalf = new driveTrainHalf(leftslot,leftEslot1,leftEslot2);
righthalf = new driveTrainHalf (rightslot,rightEslot1,rightEslot2);
myGyro = new Gyro(GSlot);
myGyro.setSensitivity(RobotMap.gyroSensitivity);
CurrentGear = .5;
resetEncoders();
directVoltageGyro = new AnalogChannel(2);


//myUltrasonic = new Ultrasonic(RobotMap.UltrasonicSlot);

}
public void setGear(double gear){
    CurrentGear = gear;
}

public void MoveLeftHalf(double speed){
lefthalf.setSpeed(deadband(speed)*(CurrentGear));
SmartDashboard.putNumber("left speed", deadband(speed)*CurrentGear);

}
public void MoveRightHalf (double speed){
righthalf.setSpeed(-CurrentGear*deadband(speed));
SmartDashboard.putNumber("right speed",- CurrentGear*deadband(speed));
}

public double deadband(double value) {
    if(Math.abs(value)<RobotMap.deadband){
        return 0; 
    }
    else {
        return value; 
    }
}

public void resetEncoders() {
    lefthalf.resetEncoder();
    righthalf.resetEncoder();
}
public double getEncoder(boolean leftSide){
    if (leftSide){
        return lefthalf.getEncoder();
    } else {
        return 
                -righthalf.getEncoder();
                
    }
   
}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new tankDrive());
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double getGyroAngle() {
        return myGyro.getAngle();
        
    }
    public void resetGyro() {
        myGyro.reset();
    }
    public double getUltrasonic() {
        return myUltrasonic.getRangeMM();
    }
    public void enableUltrasonic() {
        myUltrasonic.setEnabled(true);
    }
    public void disableUltrasonic() {
        myUltrasonic.setEnabled(false);
    }
    public void smartdashboard(){
         SmartDashboard.putNumber("Gyro value", myGyro.getAngle() );
         SmartDashboard.putData("drive train info", this);
         SmartDashboard.putNumber("left Encoder", getEncoder(true));
         SmartDashboard.putNumber("right encoder", getEncoder(false));
         SmartDashboard.putNumber("Gyro direct value",directVoltageGyro.getVoltage());
         //SmartDashboard.putNumber("Ultrasonic", getUltrasonic());
    }
    public void ResetSensers() {
        resetGyro();
        resetEncoders();
    }
}
