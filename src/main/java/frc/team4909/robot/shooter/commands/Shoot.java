package frc.team4909.robot.shooter.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4909.robot.Robot;

public class Shoot extends Command {

    public Shoot(){
        requires(Robot.shooter);
    }

    @Override
    protected void initialize() {
        Robot.shooter.openValve();
    }

    @Override
    protected void end() {
        Robot.shooter.closeValve();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}