package frc.robot.subsystems.outtake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Outtake extends SubsystemBase {
    private OuttakeIO io;
    private final OuttakeIOInputsAutoLogged inputs = new OuttakeIOInputsAutoLogged();
    private static Outtake instance;
    private boolean enabled;

    public static Outtake getInstance() {
        return instance;
    }

    public static void createInstance(Outtake outtake) {
        instance = outtake;
    }

    public Outtake(boolean enabled, OuttakeIO io) {
        if (enabled) {
            this.io = io;
            io.setup();
        }
        this.enabled = enabled;
    }

    public OuttakeIO getIO() {
        if (enabled)
            return io;
        else
            return new OuttakeIO() {};
    }

    public Command setPercent(double percent){
        if (!enabled)
            return Commands.none();
        return Commands.runOnce(() -> {
            io.setPercent(percent);
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