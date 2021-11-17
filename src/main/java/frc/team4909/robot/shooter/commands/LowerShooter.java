package frc.team4909.robot.shooter.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4909.robot.Robot;

public class LowerShooter extends Command{

    public LowerShooter(){
        requires(Robot.shooter);
    }

@Override
    protected void initialize() {
        Robot.shooter.lowerShooter();
    }

@Override
	protected boolean isFinished() {
		return false;
    }

    @Override
    protected void end() {
        Robot.shooter.AngleMotor.set(0);
    }
}
