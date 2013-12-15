/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Team 997
 */
public class DriveStraightWithGyroAndUltrasonic extends CommandBase {
    private int encoderCounts;
    private int ultrasonicDistance;
    public DriveStraightWithGyroAndUltrasonic(int approximateEncoderCounts, int RangeFromTarget) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        encoderCounts = approximateEncoderCounts;
        ultrasonicDistance = RangeFromTarget;
        
        requires(subDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       subDriveTrain.resetGyro();
       subDriveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        subDriveTrain.MoveLeftHalf(.5);
        subDriveTrain.MoveRightHalf(.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (((subDriveTrain.getEncoder(true)+subDriveTrain.getEncoder(false))/2)>(encoderCounts));
               
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
