package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Tank extends SubsystemBase {
    private TankIO io;
    private final TankIOInputsAutoLogged inputs = new TankIOInputsAutoLogged();
    private boolean enabled;

    public Tank(boolean enabled, TankIO io) {
        if (enabled) {
            this.io = io;
            io.setup();
        }
        this.enabled = enabled;
    }

    public void setPercent(double left, double right) {
        if (!enabled)
            return;

        io.getLeft().setPercent(left);
        io.getRight().setPercent(right);
    }

    @Override
    public void periodic() {
        if (!enabled)
            return;

        io.periodic();

        io.updateInputs(inputs);
        Logger.processInputs("Tank", inputs);
    }
}