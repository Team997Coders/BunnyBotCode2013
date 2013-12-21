/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 997
 */
public class DriveStraightWithEncoders extends CommandBase {
    private int encoderCounts;
    private int ultrasonicDistance;
    private boolean useGyro;
    public DriveStraightWithEncoders(double approximateFeet,boolean useingGyro) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        encoderCounts = (int) approximateFeet*240-160;
        useGyro = useingGyro;
       
        
        requires(subDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       subDriveTrain.ResetSensers();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!useGyro){
        subDriveTrain.MoveLeftHalf(RobotMap.LeftAutonomousSpeed);
        subDriveTrain.MoveRightHalf(RobotMap.rightAuronomousSpeed);
        } else {
            subDriveTrain.MoveLeftHalf(.5-GyroAdjustmentSaturation());
            subDriveTrain.MoveRightHalf(.5+GyroAdjustmentSaturation());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (((subDriveTrain.getEncoder(true)+subDriveTrain.getEncoder(false))/2)>(encoderCounts));          
    }

    // Called once after isFinished returns true
    protected void end() {
        subDriveTrain.MoveLeftHalf(0);
        subDriveTrain.MoveRightHalf(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        subDriveTrain.MoveLeftHalf(0);
        subDriveTrain.MoveRightHalf(0);
    }
    
    private double GyroAdjustmentSaturation() {
       if (subDriveTrain.getGyroAngle()*RobotMap.gyroFactor>.1) {
           return .1;
           
       } else if (subDriveTrain.getGyroAngle()*RobotMap.gyroFactor<-.1) {
           return -.1;
       }else {
           return subDriveTrain.getGyroAngle()*RobotMap.gyroFactor;
       }
    }
}
