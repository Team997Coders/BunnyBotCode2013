package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap { 
    
    //motor slots
    public static final int leftMotorSlot = 9;
    public static final int rightMotorSlot = 10;
    
    //pnuematics slots
    public static final int solenoidModule = 1;
    //kicker slots
    public static final int kickerSolenoid = 1;
    public static final int kickerSolenoid2 = 3;
    //dumper slots
    public static final int dumperSolenoid = 2;
    public static final int dumperSolenoid2 = 4;
    //compressor slots
    public static final int CompressorPressureSwitch = 2;
    public static final int myCompressor = 1;
    
    //encoder slots
    public static final int leftEncoderSlot1 = 5;
    public static final int leftEncoderSlot2 = 6;
    public static final int rightEncoderSlot1 = 3;
    public static final int rightEncoderSlot2 = 4;
    
    //gyro slots and information
    public static final int GyroSlot = 1;
    public static double gyroSensitivity = .007;
    
    
    //public static final int UltrasonicSlot = ;
    
    //constants
    public static final double deadband = .15;  
    
    
    
    
    //Buttons
    public static final int KickerButton = 1;
    public static final String KickerJoystick = "left";
    
    public static final int DumperButton = 1;
    public static final String DumperJoystick = "right";
    
    static final double DistanceToDriveIinFeet = 14.5;
    public static final double LeftAutonomousSpeed = .5;
    public static final double rightAuronomousSpeed = .53;
    public static double Turn90Distance = 220;
    public static double gyroFactor = .1;
    
    
    
}
