package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import org.littletonrobotics.junction.Logger;

import java.util.function.DoubleSupplier;

public class Intake extends SubsystemBase {
    private IntakeIO io;
    private final InputIOInputsAutoLogged inputs = new InputIOInputsAutoLogged();
    private boolean enabled;

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

    public Command setPercent(DoubleSupplier percent) {
        if (!enabled)
            return Commands.none();
        return Commands.run(() -> {
            io.setPercent(percent.getAsDouble());
        });
    }

    public Command r2Axis(CommandPS5Controller controller) {
        if (!enabled)
            return Commands.none();
        return Commands.run(() -> {
            io.setPercent((controller.getRawAxis(4) + 1) / 3);
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