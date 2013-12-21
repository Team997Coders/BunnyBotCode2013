/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 997
 */
public class Turn90WithGyro extends CommandBase {
    private boolean Clockwise;
    private double FinalGyroValue;
    
    public Turn90WithGyro(boolean clockwise) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        Clockwise = clockwise;
        requires(subDriveTrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        subDriveTrain.ResetSensers();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Clockwise){
        subDriveTrain.MoveLeftHalf(RobotMap.LeftAutonomousSpeed);
        subDriveTrain.MoveRightHalf(-RobotMap.rightAuronomousSpeed);
        } else {
        subDriveTrain.MoveLeftHalf(-RobotMap.LeftAutonomousSpeed);
        subDriveTrain.MoveRightHalf(RobotMap.rightAuronomousSpeed);
        }
        FinalGyroValue = subDriveTrain.getGyroAngle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return subDriveTrain.getGyroAngle()<=-60;
    }

    // Called once after isFinished returns true
    protected void end() {
        subDriveTrain.MoveLeftHalf(0);
        subDriveTrain.MoveRightHalf(0);
        SmartDashboard.putNumber("finalGyroValue", FinalGyroValue);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    subDriveTrain.MoveLeftHalf(0);
        subDriveTrain.MoveRightHalf(0);
        
    }
}
