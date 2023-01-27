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

    PIDController controller;
    int counter;

    TrapezoidProfile.State start;
    TrapezoidProfile.State end;
    TrapezoidProfile.Constraints constraints;
    TrapezoidProfile profile;
    TrapezoidProfile.State profileOutput;
    Spark sparkRight;
    Spark sparkLeft;
    Encoder encoder;
    double kp, ki, kd;

    public void initHardware() {
        sparkRight = new Spark(0);
        sparkLeft = new Spark(1);
        //initializing sparks

        counter = 0;

        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
        //encoder initialization

        start = new TrapezoidProfile.State(0,0);
        end = new TrapezoidProfile.State(1.0,0);
        constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
        profile = new TrapezoidProfile(constraints, end, start);
        profileOutput = profile.calculate(0.2);
        //initialization of TrapezoidProfile states

        kp = 0;
        ki = 0;
        kd = 0;
        //ki kp kd vals

        controller = new PIDController(kp, ki, kd);
    }

    public void PIDMoveForward(double distance_in_feet) {
        if (encoder.getDistance() <= distance_in_feet * 12 * Constants.TICKS_PER_INCH) {
            //if the desired distance has not been reached yet, use PID
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter);
            controller.setSetpoint(distance_in_feet * 12 * Constants.TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter++;
            //counts number of times function is executed
        }

        if (encoder.getDistance() >= distance_in_feet * 12 * Constants.TICKS_PER_INCH) {
            //if the distance has been reached, lift arm and shoot the ball

            Arm.getInstance().armUp();

        }
    }

}
