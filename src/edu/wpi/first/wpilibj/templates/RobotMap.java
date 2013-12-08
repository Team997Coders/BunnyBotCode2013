package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap { 
    public static final int leftMotorSlot = 9;
    public static final int rightMotorSlot = 10;
    public static final int kickerSolenoid = 1;
    public static final int kickerSolenoid2 = 3;
    public static final int dumperSolenoid = 2;
    public static final int dumperSolenoid2 = 4;
    public static final int myCompressor = 2;
    public static final int myCompressor2 = 1;
    
    
    //constants
    public static final double deadband = .15;  
    
    
    
    
    //Buttons
    public static final int KickerButton = 1;
    public static final String KickerJoystick = "left";
    
    public static final int DumperButton = 1;
    public static final String DumperJoystick = "right";
    public static int solenoidModule = 1;
    
}
