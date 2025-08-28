package frc.robot.subsystems.tank;

import frc.lib.NinjasLib.controllers.Controller;
import frc.robot.Constants;

public class TankLeftIOController implements TankLeftIO {
    private Controller controller;

    @Override
    public void setup() {
        controller = Controller.createController(Controller.ControllerType.SparkMax, Constants.kIntakeControllerConstants);
    }

    @Override
    public void setPercent(double percent) {
        controller.setPercent(percent);
    }

    @Override
    public void updateInputs(TankLeftIOInputsAutoLogged inputs) {
        controller.updateInputs(inputs);
    }

    @Override
    public void periodic() {
        controller.periodic();
    }
}