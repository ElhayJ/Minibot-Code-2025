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
    public Controller getLeft() {
        return left;
    }

    @Override
    public Controller getRight() {
        return right;
    }

    @Override
    public void updateInputs(TankIOInputsAutoLogged inputs) {
        inputs.LeftOutput = left.getOutput();
        inputs.RightOutput = right.getOutput();
    }

    @Override
    public void periodic() {
        right.periodic();
        left.periodic();
    }
}