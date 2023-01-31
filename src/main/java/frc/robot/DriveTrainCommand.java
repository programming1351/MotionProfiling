package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class DriveTrainCommand extends CommandBase {
    public DriveTrainCommand(){
        super();
        setName("Drivetrain");
        addRequirements(DriveTrain.getInstance());

    }
//    boolean clicked;

    double leftMotor;
    double rightMotor;



    @Override
    public void initialize() {
        leftMotor = OI.getInstance().getController().getLeftY();
        rightMotor = OI.getInstance().getController().getRightX();
    }

    @Override
    public void execute() {

        // -0.1 and 0.1 accounts for deadzone
        // x_val represents the left

        if (leftMotor > -0.1 && leftMotor < 0.1) {
            DriveTrain.getInstance().SparkLeft.set(0);
        }

        else if (rightMotor > -0.1 && leftMotor < 0.1) {
            DriveTrain.getInstance().SparkRight.set(0);
        }

        else {
            DriveTrain.getInstance().setMotors(rightMotor, leftMotor);
        }

//        DriveTrain.getInstance().setSparkLeft(OI.getInstance().getController().getLeftY());
//        DriveTrain.getInstance().setSparkRight(OI.getInstance().getController().getLeftY());

        //starts tank drive
//        if (controller.getAButtonPressed()){
//            clicked = true;
//        }
//        //stops tank drive
//        if (controller.getBButtonPressed()){
//            clicked = false;
//        }
        //tank drive
//        if (clicked){
//            SparkLeft.set(controller.getLeftY());
//            SparkRight.set(controller.getRightY());
//        }

//        if (clicked == true) {
//            SparkLeft.set(0);
//            SparkRight.set(0);

        super.execute();
    }

    @Override
    public boolean isFinished() {
//        return OI.getInstance().getController().getAButton();

        return super.isFinished();

    }
//    public void end;(boolean interrupted) {
//        //  DrivetrainSubsystem.getInstance().setSparkLeft(0);
//        //  DrivetrainSubsystem.getInstance().setSparkRight(0);
//    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

}



