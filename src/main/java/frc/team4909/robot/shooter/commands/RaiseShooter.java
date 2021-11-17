package frc.team4909.robot.shooter.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4909.robot.Robot;

public class RaiseShooter extends Command{

    public RaiseShooter(){
        requires(Robot.shooter);
    }

@Override
    protected void initialize() {
        Robot.shooter.raiseShooter();
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
