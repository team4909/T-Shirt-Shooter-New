package frc.team4909.robot.shooter;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterLight extends Subsystem {

    public static AnalogInput analogSensor;
    
    private AddressableLED leds;
    private AddressableLEDBuffer ledBuffer;
    private final int led_length = 138;
    
    public ShooterLight() {
        analogSensor = new AnalogInput(3);
        
        leds = new AddressableLED(0);
        ledBuffer = new AddressableLEDBuffer(led_length);
        leds.setLength(ledBuffer.getLength());
        leds.start();
    }

    @Override
    public void periodic() {
        double psi = 250.0 * analogSensor.getVoltage() / 5.0 - 25.0;
        SmartDashboard.putNumber("analog Sensor", analogSensor.getVoltage());
        double mapped_psi = map(psi, 25, 51, 0, led_length);
        if (mapped_psi > led_length) {mapped_psi = led_length;}
        if (mapped_psi < 0) {mapped_psi = 0;}
        {
            for (int i = 0; i < mapped_psi; i++) {
                ledBuffer.setRGB(i, 0, 255, 0);
            }
            
            for (int i = (int) mapped_psi; i < ledBuffer.getLength(); i++) {
                ledBuffer.setRGB(i, 255, 0, 0);
            }
            
            leds.setData(ledBuffer);    
        }
        
        //Smart Dashboard outputs
        SmartDashboard.putNumber("PSI", psi);
        if (psi >= 60) {
            SmartDashboard.putBoolean("Ready", true);
        } else {
            SmartDashboard.putBoolean("Ready", false);
        }

        SmartDashboard.putNumber("PSI", 250.0 * analogSensor.getVoltage() / 5.0 - 25.0);
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
    protected void initDefaultCommand() {
        
    }
}
