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
    Spark SparkLeft, SparkRight;



    public void initHardware() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

    }
    public void setSparkLeft(double val){
        SparkLeft.set(val);
    }

    public void setSparkRight(double val){
        SparkRight.set(val);
    }






    public void setMotors(double val){
        SparkLeft.set(val);
        SparkRight.set(val);
    }
    public void updateDashboard() {

    }








}



