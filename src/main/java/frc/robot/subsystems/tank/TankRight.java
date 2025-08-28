package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class TankRight extends SubsystemBase {
    private TankRightIO io;
    private final TankRightIOInputsAutoLogged inputs = new TankRightIOInputsAutoLogged();
    private static TankRight instance;
    private boolean enabled;

    public static TankRight getInstance() {
        return instance;
    }

    public static void createInstance(TankRight tankRight) {
        instance = tankRight;
    }

    public TankRight(boolean enabled, TankRightIO io) {
        if (enabled) {
            this.io = io;
            io.setup();
        }
        this.enabled = enabled;
    }

    public TankRightIO getIO() {
        if (enabled)
            return io;
        else
            return new TankRightIO() {};
    }

    @Override
    public void periodic() {
        if (!enabled)
            return;

        io.periodic();

        io.updateInputs(inputs);
        Logger.processInputs("TankRight", inputs);
    }
}