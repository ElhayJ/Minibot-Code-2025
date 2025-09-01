package frc.robot.subsystems.intake;

import frc.lib.NinjasLib.controllers.Controller;
import frc.robot.Constants;

public class IntakeIOController implements IntakeIO {
    private Controller controller;

    @Override
    public void setup() {
        controller = Controller.createController(Controller.ControllerType.VictorSPX, Constants.kIntakeControllerConstants);
    }

    @Override
    public void setPercent(double percent) {
        controller.setPercent(percent);
    }

    @Override
    public void updateInputs(InputIOInputsAutoLogged inputs) {
        inputs.Output = controller.getOutput();
    }

    @Override
    public void periodic() {
        controller.periodic();
    }
}