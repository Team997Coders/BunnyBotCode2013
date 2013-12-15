/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonalClasses;

import edu.wpi.first.wpilibj.AnalogChannel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Team 997
 */
public class Gyro {
    private AnalogChannel gyroAnalogChannel;
    private double zeroValue = 0;
    private Timer myTimer = new Timer();
    private TimerTask updateGyro = new TimerTask() {

        public void run() {
       callContinuosly(); 
        }
    };
    public Gyro(){
      myTimer.scheduleAtFixedRate(updateGyro, 1, 1);
    }
    
    int i;
    double accumulatedValue;
    private double currentHeading;
    
    private double getAnalogValue() {
        i = 0;
        accumulatedValue = 0;
        while(i<3) {
           accumulatedValue = gyroAnalogChannel.getVoltage() + accumulatedValue;
        i++;
        }
        return accumulatedValue / 3;
    }
    
    public void reset() {
      i = 0;
      accumulatedValue = 0;
        while(i < 40){
            accumulatedValue = getAnalogValue() + accumulatedValue;
            i++;
        }
   zeroValue = accumulatedValue / 40;
    }
    public double getRate() {
        return getAnalogValue() - zeroValue;
    }
    public void callContinuosly() {
        currentHeading = currentHeading + getRate(); 
    }
    
    public double getHeading() {
     return currentHeading; 
    }
    }
    

