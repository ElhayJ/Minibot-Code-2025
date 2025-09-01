package frc.robot.subsystems.tank;

import frc.lib.NinjasLib.controllers.Controller;
import org.littletonrobotics.junction.AutoLog;

public interface TankIO {
    @AutoLog
    class TankIOInputs extends Controller.ControllerIOInputs {
        public double LeftOutput;
        public double RightOutput;
    }

    default void setup() {
    }

    default Controller getLeft() {
        return null;
    }

    default Controller getRight() {
        return null;
    }

    default void updateInputs(TankIOInputsAutoLogged inputs) {
    }

    default void periodic() {
    }
}
