package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutonomousCommand extends CommandBase {

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        Autonomous.getInstance().PIDMoveForward(22.5);
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
