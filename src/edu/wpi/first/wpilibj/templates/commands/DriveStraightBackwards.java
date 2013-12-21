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
public class DriveStraightBackwards extends CommandBase {
     private int encoderCounts;
    private int ultrasonicDistance;
    public DriveStraightBackwards(double approximateFeet) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        encoderCounts = (int) -(approximateFeet*240-160);
       
        
        requires(subDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       subDriveTrain.resetGyro();
       subDriveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        subDriveTrain.MoveLeftHalf(-RobotMap.LeftAutonomousSpeed);
        subDriveTrain.MoveRightHalf(-RobotMap.rightAuronomousSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (((subDriveTrain.getEncoder(true)+subDriveTrain.getEncoder(false))/2)<(encoderCounts));
               
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
}
