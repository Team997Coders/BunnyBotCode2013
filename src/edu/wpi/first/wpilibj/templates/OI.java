
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.DriveStraightWithEncoders;
import edu.wpi.first.wpilibj.templates.commands.ExtendDumperCommand;
import edu.wpi.first.wpilibj.templates.commands.ExtendKickerCommand;
import edu.wpi.first.wpilibj.templates.commands.KickWithTimer;
import edu.wpi.first.wpilibj.templates.commands.ResetSensorsCommand;
import edu.wpi.first.wpilibj.templates.commands.RetractDumperCommand;
import edu.wpi.first.wpilibj.templates.commands.RetractKickerCommand;
import edu.wpi.first.wpilibj.templates.commands.ReverseDrive;
import edu.wpi.first.wpilibj.templates.commands.SetGear;
import edu.wpi.first.wpilibj.templates.commands.Turn90WithGyro;
import edu.wpi.first.wpilibj.templates.commands.TurnOffCommpressor;
import edu.wpi.first.wpilibj.templates.commands.TurnOnCompressor;
import edu.wpi.first.wpilibj.templates.commands.tankDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick GamePad;
    
    private Button ExtendKickerButton;
    private Button RetractKickerButton;
    private Button ExtendDumperButton;
    private Button RetractDumperButton;
    private Button TurnOffCompressor;
    private Button TurnOnCompressor;
    private Button KickButton;
    private Button DumpButton;
    private Button setToFullGear;
    private Button setToHalfGear;
    private Button setToQuarterGear;
    private Button HighGear;
    private Button MidGear;
    private Button  LowGear;
    private Button ResetEncoderButton;
    private Button DriveEncoderCounts;
    private Button Drive90DegreesCounterClockwise;
    private Button ReverseDrive;
    private Button TankDrive;
    private Button thirdGear;
    
    public OI(){
    leftJoystick = new Joystick(1);
    rightJoystick = new Joystick(2);
    GamePad = new Joystick(3);
    
    
    ResetEncoderButton = new InternalButton();
    ExtendKickerButton = new InternalButton();
    RetractKickerButton = new InternalButton();
    ExtendDumperButton  = new InternalButton();
    RetractDumperButton = new InternalButton();
    KickButton = new JoystickButton(leftJoystick, RobotMap.KickerButton);
    DumpButton = new JoystickButton(rightJoystick, RobotMap.DumperButton);
    TurnOffCompressor = new InternalButton();
    TurnOnCompressor = new InternalButton();
    setToFullGear = new InternalButton();
    setToQuarterGear = new InternalButton();
    setToHalfGear = new InternalButton();
    HighGear = new JoystickButton(GamePad, 8);
    MidGear = new JoystickButton(GamePad, 6);
    thirdGear = new JoystickButton(GamePad, 4);
    LowGear = new JoystickButton(GamePad, 2);
    DriveEncoderCounts = new InternalButton();
    Drive90DegreesCounterClockwise = new InternalButton();
    TankDrive = new JoystickButton(GamePad, 5);
    ReverseDrive = new JoystickButton(GamePad, 7); 
    
    thirdGear.whenPressed(new SetGear(.33));
    KickButton.whenPressed(new KickWithTimer());
    DumpButton.whenPressed(new KickWithTimer());
    ExtendKickerButton.whenPressed(new ExtendKickerCommand());
    RetractKickerButton.whenPressed(new RetractKickerCommand());
    ExtendDumperButton.whenPressed(new ExtendDumperCommand());
    RetractDumperButton.whenPressed(new RetractDumperCommand());
    TurnOffCompressor.whenPressed(new TurnOffCommpressor());
    TurnOnCompressor.whenPressed(new TurnOnCompressor());
    setToFullGear.whenPressed(new SetGear(1));
    setToHalfGear.whenPressed(new SetGear(.5));
    setToQuarterGear.whenPressed(new SetGear(.25));
    MidGear.whenPressed(new SetGear(.5));
    HighGear.whenPressed(new SetGear(1));
    LowGear.whenPressed(new SetGear(.25));
    ResetEncoderButton.whenPressed(new ResetSensorsCommand());
    DriveEncoderCounts.whenPressed(new DriveStraightWithEncoders(RobotMap.DistanceToDriveIinFeet,true));
    Drive90DegreesCounterClockwise.whenPressed(new Turn90WithGyro(false));
    TankDrive.whenPressed(new tankDrive());
    ReverseDrive.whenPressed(new ReverseDrive());
    
    SmartDashboard.putData("reset sensers", ResetEncoderButton);
    SmartDashboard.putData("extend kicker", ExtendKickerButton);
    SmartDashboard.putData("retract kicker", RetractKickerButton);
    SmartDashboard.putData("extend dumper", ExtendDumperButton);
    SmartDashboard.putData("retract dumper", RetractDumperButton);
    SmartDashboard.putData("Compressor on",TurnOnCompressor);
    SmartDashboard.putData("compressor off", TurnOffCompressor);
    SmartDashboard.putData("set full gear", setToFullGear);
    SmartDashboard.putData("set to half gear", setToHalfGear);
    SmartDashboard.putData("set to quarter gear",setToQuarterGear);
    SmartDashboard.putData("Autonomous Test",DriveEncoderCounts);
    SmartDashboard.putData("turn 90 degrees counterclosckwise", Drive90DegreesCounterClockwise);
    }
    
    
    
    //negatives to make positive forward
    public double getLeftY(){
        return -leftJoystick.getY();
        }
    public double getRightY(){
        return -rightJoystick.getY();
    }

    public void smartdashboard() {
        SmartDashboard.putNumber("left Joystick y axis" , getLeftY());
        SmartDashboard.putNumber("right Joystick y axis", getRightY());
        SmartDashboard.putNumber("z axis multiplied", getZAxisMultiplied()); 
    }

    private double getZAxisMultiplied() {
        return leftJoystick.getZ()*10*leftJoystick.getZ();
    }
    
    
}

