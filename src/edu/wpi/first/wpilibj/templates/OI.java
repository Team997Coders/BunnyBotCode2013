
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.ExtendDumperCommand;
import edu.wpi.first.wpilibj.templates.commands.ExtendKickerCommand;
import edu.wpi.first.wpilibj.templates.commands.RetractDumperCommand;
import edu.wpi.first.wpilibj.templates.commands.RetractKickerCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    
    private Button ExtendKickerButton;
    private Button RetractKickerButton;
    private Button ExtendDumperButton;
    private Button RetractDumperButton;
            
    public OI(){
    leftJoystick = new Joystick(1);
    rightJoystick = new Joystick(2);
    
    ExtendKickerButton = new InternalButton();
    RetractKickerButton = new InternalButton();
    ExtendDumperButton  = new InternalButton();
    RetractDumperButton = new InternalButton();
    
    ExtendKickerButton.whenPressed(new ExtendKickerCommand());
    RetractKickerButton.whenPressed(new RetractKickerCommand());
    ExtendDumperButton.whenPressed(new ExtendDumperCommand());
    RetractDumperButton.whenPressed(new RetractDumperCommand());
    
    SmartDashboard.putData("extend kicker", ExtendKickerButton);
    SmartDashboard.putData("retract kicker", RetractKickerButton);
    SmartDashboard.putData("extend dumper", ExtendDumperButton);
    SmartDashboard.putData("retract dumper", RetractDumperButton);
    }
    
    
    
    
    public double getLeftY(){
        return leftJoystick.getY();
        }
    public double getRightY(){
        return rightJoystick.getY();
    }
}

