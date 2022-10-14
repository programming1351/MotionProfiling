package frc.robot;

public class IntakePistonSubsystem extends SubsystemBase implements IPistonSubsystem {
    private DoubleSolenoid intakePiston;
    intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

}

