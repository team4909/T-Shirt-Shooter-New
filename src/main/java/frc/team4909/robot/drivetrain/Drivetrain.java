package frc.team4909.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {
    
    WPI_TalonSRX f_left;
    WPI_VictorSPX f_right;
    WPI_VictorSPX b_right;
    WPI_VictorSPX b_left;
    DifferentialDrive bionicDrive;
    SpeedControllerGroup left;
    SpeedControllerGroup right;

    public Drivetrain() {
        f_left= new WPI_TalonSRX(1);
        f_right = new WPI_VictorSPX(2);
        b_left = new WPI_VictorSPX(3);
        b_right = new WPI_VictorSPX(4);
        
        left = new SpeedControllerGroup(f_left,b_left);

        right = new SpeedControllerGroup(f_right, b_right);

        bionicDrive = new DifferentialDrive(left, right);
    }

    public void tankDrive(double left, double right){
        bionicDrive.tankDrive(left, right);
    }

    public void arcadeDrive(double speed, double rotation){
        bionicDrive.arcadeDrive(speed, rotation);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

}
