package frc.robot.subsystems.tank;

import frc.lib.NinjasLib.controllers.Controller;
import org.littletonrobotics.junction.AutoLog;

public interface TankRightIO {
    @AutoLog
    class TankRightIOInputs extends Controller.ControllerIOInputs {
    }

    default void setup() {
    }

    default void setPercent(double percent) {
    }

    default void updateInputs(TankRightIOInputsAutoLogged inputs) {
    }

    default void periodic() {
    }
}
