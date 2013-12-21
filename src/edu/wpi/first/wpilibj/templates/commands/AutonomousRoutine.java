/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team 997
 */
public class AutonomousRoutine extends CommandGroup {
    
    public AutonomousRoutine() {
        addSequential(new SetGear(.5));
        addSequential(new DriveStraightWithEncoders(25,true));
        addSequential(new Wait(), .5);
        addSequential(new Turn90WithGyro(false));
        addSequential(new Wait(), .5);
        addSequential(new DriveStraightWithEncoders(4.5,true));
        addSequential(new Wait(), .5);
        addSequential(new DumpWithTimer());
        addSequential(new DriveStraightBackwards(2));
        
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
