package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    private static OI instance;
    public static OI getInstance(){
        if (instance == null){
            instance = new OI();

        }
        return instance;
    }
    private XboxController controller;

}
