/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

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

public driveTrainFull (int leftslot, int rightslot){
lefthalf = new driveTrainHalf(leftslot);
righthalf = new driveTrainHalf (rightslot);
}

public void MoveLeftHalf(double speed){
lefthalf.setSpeed(deadband(speed));
SmartDashboard.putNumber("left speed", speed);

}
public void MoveRightHalf (double speed){
righthalf.setSpeed(deadband(-speed));
SmartDashboard.putNumber("right speed", speed);
}

public double deadband(double value) {
    if(Math.abs(value)<RobotMap.deadband){
        return 0; 
    }
    else {
        return value; 
    }
}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new tankDrive());
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void smartdashboard(){
         SmartDashboard.putData("drive train info", this);
    }
}
