package frc.robot.subsystems.tank;

import frc.lib.NinjasLib.controllers.Controller;
import frc.robot.Constants;

public class TankIOController implements TankIO {
    private Controller left;
    private Controller right;

    @Override
    public void setup() {
        left = Controller.createController(Controller.ControllerType.SparkMax, Constants.kTankLeftControllerConstants);
        right = Controller.createController(Controller.ControllerType.SparkMax, Constants.kTankRightControllerConstants);
    }

    @Override
    public void setPercent(double percentRight, double percentLeft) {
        right.setPercent(percentRight);
        left.setPercent(percentLeft);
    }

    @Override
    public void updateInputs(TankIOInputsAutoLogged inputs) {
        right.updateInputs(inputs);
        left.updateInputs(inputs);
    }

    @Override
    public void periodic() {
        right.periodic();
        left.periodic();
    }
}