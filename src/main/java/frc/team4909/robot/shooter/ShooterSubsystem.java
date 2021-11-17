package frc.team4909.robot.shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANAnalog;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem{
    
    public static WPI_TalonSRX AngleMotor;
    public static WPI_TalonSRX solenoid;

    

    public ShooterSubsystem(){
        AngleMotor = new WPI_TalonSRX(5);
        solenoid = new WPI_TalonSRX(6);

    }

    public void openValve() {
        solenoid.set(1);
    }

    public void closeValve(){
        solenoid.set(0);
    }

    public void raiseShooter(){
        AngleMotor.set(1);
    }

    public void lowerShooter(){
        AngleMotor.set(-1);
    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new FillTank(60.0));
    }

}