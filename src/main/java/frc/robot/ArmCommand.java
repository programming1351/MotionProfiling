package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmCommand extends CommandBase {

    public ArmCommand() {
        setName("Arm Command");
        addRequirements(Arm.getInstance());
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        if (OI.getInstance().getController().getAButtonPressed()) {
            Arm.getInstance().armUp();
        }

        if (OI.getInstance().getController().getAButtonReleased()) {
            Arm.getInstance().armStationary();
        }

        if (OI.getInstance().getController().getBButtonPressed()) {
            Arm.getInstance().armDown();
        }

        if (OI.getInstance().getController().getBButtonReleased()) {
            Arm.getInstance().armStationary();
        }
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
