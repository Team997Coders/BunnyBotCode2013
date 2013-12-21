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
public class Turn90Degrees extends CommandBase {
    private boolean Clockwise;
    public Turn90Degrees(boolean clockwise) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        Clockwise = clockwise;
        requires(subDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        subDriveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Clockwise){
        subDriveTrain.MoveLeftHalf(RobotMap.LeftAutonomousSpeed*2);
        subDriveTrain.MoveRightHalf(-RobotMap.rightAuronomousSpeed*2);
        } else {
        subDriveTrain.MoveLeftHalf(-RobotMap.LeftAutonomousSpeed*2);
        subDriveTrain.MoveRightHalf(RobotMap.rightAuronomousSpeed*2);
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //280
        if (Clockwise) {
            return ((subDriveTrain.getEncoder(true)>=RobotMap.Turn90Distance)&&(subDriveTrain.getEncoder(false)<=RobotMap.Turn90Distance));
        } else {
            return ((subDriveTrain.getEncoder(true)<=RobotMap.Turn90Distance)&&(subDriveTrain.getEncoder(false)>=RobotMap.Turn90Distance));
        }
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
