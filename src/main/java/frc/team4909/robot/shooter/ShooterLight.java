package frc.team4909.robot.shooter;

import com.revrobotics.CANAnalog;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterLight extends Subsystem {

    public static AnalogInput analogSensor;
    private AddressableLED leds;
    private AddressableLED leds2;
    private AddressableLEDBuffer ledBuffer;
    private AddressableLEDBuffer ledBuffer2;
    private final int led_length = 138;
    
    public ShooterLight() {
        analogSensor = new AnalogInput(3);
        leds = new AddressableLED(0);
        //leds2 = new AddressableLED(2);



        ledBuffer = new AddressableLEDBuffer(led_length);
        // ledBuffer2 = new AddressableLEDBuffer(80);
        leds.setLength(ledBuffer.getLength());
        // leds2.setLength(ledBuffer2.getLength());

        // for (int i = 0; i < ledBuffer2.getLength(); i++) {
        //     ledBuffer2.setRGB(i, 255, 255, 255);
            
        // }

    
        leds.start();

    }

 /**
 * map a number from one range to another
 * @param  {num} value   the value to be mapped
 * @param  {num} old_min the minimum of value
 * @param  {num} old_max the maximum of value
 * @param  {num} new_min the new minimum value
 * @param  {num} new_max the new maximum value
 * @return The value remaped on the range [new_min new_max]
 */
public static double map(double value, double old_min, double old_max, double new_min, double new_max) {
    return (value - old_min) / (old_max - old_min) * (new_max - new_min) + new_min;
}


    @Override
    public void periodic() {
        double psi = 250.0 * analogSensor.getVoltage() / 5.0 - 25.0;
        double mapped_psi = map(psi, 25, 60, 0, led_length);
        if (mapped_psi > led_length) {mapped_psi = led_length;}
        if (mapped_psi < 0) {mapped_psi = 0;}

        {
            
            for (int i = 0; i < mapped_psi; i++) {
                ledBuffer.setRGB(i, 0, 255, 0);
                
            }
            
            
            // SmartDashboard.putBoolean("On", true);

            for (int i = (int) mapped_psi; i < ledBuffer.getLength(); i++) {
                ledBuffer.setRGB(i, 255, 0, 0);
                
            }
            leds.setData(ledBuffer);
            
        }

        SmartDashboard.putNumber("PSI", psi);
        if (psi >= 60) {
            SmartDashboard.putBoolean("On", true);
        } else {
            SmartDashboard.putBoolean("On", false);
        }
    }

    @Override
    protected void initDefaultCommand() {
        
    }
    
}
