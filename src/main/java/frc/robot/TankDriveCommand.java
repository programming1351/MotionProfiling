package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class TankDriveCommand extends CommandBase {
    public TankDriveCommand(){
        super();
        setName("Tank Drive");
        addRequirements(DriveTrain.getInstance());

    }
    Spark SparkLeft, SparkRight;
    boolean clicked;


    XboxController controller;
    DigitalInput digitalInput;



    @Override
    public void initialize() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        controller = new XboxController(0);



    }
    public void execute() {


        DriveTrain.getInstance().setSparkLeft(OI.getInstance().getController().getLeftY());
        DriveTrain.getInstance().setSparkRight(OI.getInstance().getController().getLeftY());



        //starts tank drive
        if (controller.getAButtonPressed()){
            clicked = true;
        }
        //stops tank drive
        if (controller.getBButtonPressed()){
            clicked = false;
        }
        //tank drive
        if (clicked){
            SparkLeft.set(controller.getLeftY());
            SparkRight.set(controller.getRightY());
        }

        if (clicked = true)
            SparkLeft.set(0);
        SparkRight.set(0);

        super.execute();
    }
    public boolean isFinished() {
        return OI.getInstance().getController().getAButton();

    }
    public void end(boolean interrupted) {
        //  DrivetrainSubsystem.getInstance().setSparkLeft(0);
        //  DrivetrainSubsystem.getInstance().setSparkRight(0);
    }
}



