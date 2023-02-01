package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutonomousCommand extends CommandBase {

    public AutonomousCommand() {
        super();
        setName("Autonomous");
        addRequirements(Autonomous.getInstance());
    }

    double time;

    @Override
    public void initialize() {
        time = 0;
        //measures amount of time
    }

    @Override
    public void execute() {
        Autonomous.getInstance().PIDMoveForward(22.5);

        //val of time to be measured when testing
        if (time < 2) {
            //if the amount of time it takes to bring the arm up has not been reached...
            IntakeShooter.getInstance().Intake();
            //keep intake running and...
            Arm.getInstance().armUp();
            //keep raising the arm
        }

        if (Autonomous.getInstance().encoder.getDistance() >= 22.5) {
            //if the distance needed to be moved to get to the goal has been reached...
            if (time >= 2) {
                //and if the time it takes to bring the arm up has been reached...
                Arm.getInstance().armStationary();
                //stop the arm movement and...
                IntakeShooter.getInstance().Shooter();
                //shoot the ball
            }
        }

        time += 0.02;
        //increases the time counter by 0.02 (it cycles through execute() every 0.02 seconds

    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
