package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Intake extends SubsystemBase {
    private IntakeIO io;
    private final InputIOInputsAutoLogged inputs = new InputIOInputsAutoLogged();
    private static Intake instance;
    private boolean enabled;

    public static Intake getInstance() {
        return instance;
    }

    public static void createInstance(Intake intake) {
        instance = intake;
    }

    public Intake(boolean enabled, IntakeIO io) {
        if (enabled) {
            this.io = io;
            io.setup();
        }
        this.enabled = enabled;
    }

    public IntakeIO getIO() {
        if (enabled)
            return io;
        else
            return new IntakeIO() {};
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
        Logger.processInputs("Intake", inputs);
    }
}