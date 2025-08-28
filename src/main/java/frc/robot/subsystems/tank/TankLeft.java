package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class TankLeft extends SubsystemBase {
    private TankLeftIO io;
    private final TankLeftIOInputsAutoLogged inputs = new TankLeftIOInputsAutoLogged();
    private static TankLeft instance;
    private boolean enabled;

    public static TankLeft getInstance() {
        return instance;
    }

    public static void createInstance(TankLeft tankLeft) {
        instance = tankLeft;
    }

    public TankLeft(boolean enabled, TankLeftIO io) {
        if (enabled) {
            this.io = io;
            io.setup();
        }
        this.enabled = enabled;
    }

    public TankLeftIO getIO() {
        if (enabled)
            return io;
        else
            return new TankLeftIO() {};
    }

    @Override
    public void periodic() {
        if (!enabled)
            return;

        io.periodic();

        io.updateInputs(inputs);
        Logger.processInputs("TankLeft", inputs);
    }
}