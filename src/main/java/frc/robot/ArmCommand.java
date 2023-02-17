package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmCommand extends CommandBase {

    public ArmCommand() {
        setName("Arm Command");
        addRequirements(Arm.getInstance());
    }

    boolean AButton;
    boolean BButton;

    @Override
    public void initialize() {
        AButton = OI.getInstance().getController().getAButtonPressed();
        BButton = OI.getInstance().getController().getBButtonPressed();
    }

    @Override
    public void execute() {

        if (AButton && BButton) {
            Arm.getInstance().armStationary();
        }

        if (AButton) {
            Arm.getInstance().armUp();
        }

        if (BButton) {
            Arm.getInstance().armDown();
        }

        else {
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
