package frc.team4909.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4909.robot.drivetrain.Drivetrain;
import frc.team4909.robot.shooter.ShooterLight;
import frc.team4909.robot.shooter.ShooterSubsystem;
import frc.team4909.robot.shooter.commands.LowerShooter;
import frc.team4909.robot.shooter.commands.RaiseShooter;
import frc.team4909.robot.shooter.commands.Shoot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Drivetrain drivetrain;
  public static ShooterSubsystem shooter;
  public static ShooterLight shooterLight;
  public static Compressor c;
  public static PowerDistributionPanel powerDistributionPanel;

  public static BionicF310 driveGamepad;

  @Override
  public void robotInit(){
    drivetrain = new Drivetrain();
    shooter = new ShooterSubsystem();
    shooterLight = new ShooterLight();
    c = new Compressor(0);
    c.setClosedLoopControl(true);
    powerDistributionPanel = new PowerDistributionPanel();

    driveGamepad = new BionicF310(0, 0.2, 0.6);

    driveGamepad.buttonHeld(BionicF310.RB, new RaiseShooter());
    driveGamepad.buttonHeld(BionicF310.LB, new LowerShooter());
    driveGamepad.buttonHeld(BionicF310.RT, 0.2, new Shoot());
  }

  public void robotPeriodic(){ 
    Scheduler.getInstance().run();
  }

  public void autonomousInit(){

  }

  public void autonomousPeriodic(){

  }

  public void teleopInit(){

  }

  public void teleopPeriodic(){

  }

  
}
