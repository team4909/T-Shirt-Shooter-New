package frc.team4909.robot.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4909.robot.BionicF310;
import frc.team4909.robot.Robot;

public class Drive extends Command {
    
    public Drive(){
        requires(Robot.drivetrain);
    }

    @Override
    public void execute() {
        Robot.drivetrain.arcadeDrive(-Robot.driveGamepad.getThresholdAxis(BionicF310.LY), 
        Robot.driveGamepad.getThresholdAxis(BionicF310.RX));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    
}