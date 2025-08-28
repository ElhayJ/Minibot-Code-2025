package frc.robot.subsystems.tank;

import frc.lib.NinjasLib.controllers.Controller;

import org.littletonrobotics.junction.AutoLog;

public interface TankLeftIO {
    @AutoLog
    class TankLeftIOInputs extends Controller.ControllerIOInputs {
    }

    default void setup() {
    }

    default void setPercent(double percent) {
    }

    default void updateInputs(TankLeftIOInputsAutoLogged inputs) {
    }

    default void periodic() {
    }
}
