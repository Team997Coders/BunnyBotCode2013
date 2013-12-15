package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.templates.subsystems.driveTrainFull;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
     public static driveTrainFull subDriveTrain = new driveTrainFull(
             RobotMap.leftMotorSlot,
             RobotMap.rightMotorSlot,
             RobotMap.leftEncoderSlot1,
             RobotMap.leftEncoderSlot2,
             RobotMap.rightEncoderSlot1,
             RobotMap.rightEncoderSlot2,
             RobotMap.GyroSlot);
     public static Pneumatics myPnumatics = new Pneumatics(
             RobotMap.solenoidModule,
             RobotMap.kickerSolenoid, 
             RobotMap.kickerSolenoid2, 
             RobotMap.dumperSolenoid, 
             RobotMap.dumperSolenoid2,
             RobotMap.CompressorPressureSwitch, 
             RobotMap.myCompressor);
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
