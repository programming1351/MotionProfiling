package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot<counter> extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  PIDController controller;

  TrapezoidProfile.State start;
  TrapezoidProfile.State end;
  TrapezoidProfile.Constraints constraints;
  TrapezoidProfile profile;
  TrapezoidProfile.State profileOutput;
  Spark sparkRight;
  Spark sparkLeft;
  Encoder encoder;
  double kp, ki, kd;


  @Override
  public void robotInit() {

      OI.getInstance().setupControls();
      Arm.getInstance().initHardware();
      Autonomous.getInstance().initHardware();
      DriveTrain.getInstance().initHardware();
      IntakeShooter.getInstance().initHardware();

  }

  @Override
  public void robotPeriodic() {}


  @Override
  public void autonomousInit() {

    CommandScheduler.getInstance().schedule(new AutonomousCommand());

  }


  @Override
  public void autonomousPeriodic() {


  }


  @Override
  public void teleopInit() {

      CommandScheduler.getInstance().schedule(new ArmCommand());
      CommandScheduler.getInstance().schedule(new AutonomousCommand());
      CommandScheduler.getInstance().schedule(new IntakeShooterCommand());
      CommandScheduler.getInstance().schedule(new TankDriveCommand());

  }



  @Override
  public void teleopPeriodic() {



  }



  @Override
  public void disabledInit() {}


  @Override
  public void disabledPeriodic() {}


  @Override
  public void testInit() {}


  @Override
  public void testPeriodic() {}
}
