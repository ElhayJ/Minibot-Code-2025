package frc.robot.subsystems.input;

import frc.lib.NinjasLib.controllers.Controller;
import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
    @AutoLog
    class InputIOInputs extends Controller.ControllerIOInputs {
    }

    default void setup() {
    }

    default void setPercent(double percent) {
    }

    default void updateInputs(InputIOInputsAutoLogged inputs) {
    }

    default void periodic() {
    }
}
