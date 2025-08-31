package frc.robot.subsystems.tank;

import frc.lib.NinjasLib.controllers.Controller;
import org.littletonrobotics.junction.AutoLog;

public interface TankIO {
    @AutoLog
    class TankIOInputs extends Controller.ControllerIOInputs {
    }

    default void setup() {
    }

    default void setPercent(double percentRight, double precentLeft) {
    }

    default void updateInputs(TankIOInputsAutoLogged inputs) {
    }

    default void periodic() {
    }
}
