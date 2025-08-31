package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Tank extends SubsystemBase {
    private TankIO io;
    private final TankIOInputsAutoLogged inputs = new TankIOInputsAutoLogged();
    private static Tank instance;
    private boolean enabled;

    public static Tank getInstance() {
        return instance;
    }

    public static void createInstance(Tank tank) {
        instance = tank;
    }

    public Tank(boolean enabled, TankIO io) {
        if (enabled) {
            this.io = io;
            io.setup();
        }
        this.enabled = enabled;
    }

    public TankIO getIO() {
        if (enabled)
            return io;
        else
            return new TankIO() {};
    }

    public Command setPercent(double percentRight, double percentLeft){
        if (!enabled)
            return Commands.none();
        return Commands.runOnce(() -> {
            io.setPercent(percentRight, percentLeft);
        });
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