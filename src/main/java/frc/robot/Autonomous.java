package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Autonomous extends SubsystemBase {

    private static Autonomous instance;

    //singleton
    public static Autonomous getInstance() {
        if (instance == null) {
            instance = new Autonomous();
        }
        return instance;
    }

    public void initHardware() {

    }

    public void moveForward() {
        DriveTrain.getInstance().SparkRight.set(0.2);
        DriveTrain.getInstance().SparkLeft.set(0.2);
    }


}