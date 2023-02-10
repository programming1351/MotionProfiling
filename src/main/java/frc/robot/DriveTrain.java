package frc.robot;
import edu.wpi.first.wpilibj.GenericHID;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{
    public static DriveTrain instance = null;
    public static DriveTrain getInstance(){
        if (instance == null){
            instance = new DriveTrain();
        }
        return instance;
    }

    Spark SparkLeftForward, SparkLeftBack, SparkRightForward, SparkRightBack;

    public void initHardware() {
        SparkLeftForward = new Spark(0);
        SparkLeftBack = new Spark(1);
        SparkRightForward = new Spark(2);
        SparkRightBack = new Spark(3);
        //initializing sparks
    }

    public void setMotors(double rightVal, double leftVal){
        SparkRightForward.set(rightVal);
        SparkRightBack.set(rightVal);
        SparkLeftBack.set(leftVal);
        SparkLeftForward.set(leftVal);
    }
}