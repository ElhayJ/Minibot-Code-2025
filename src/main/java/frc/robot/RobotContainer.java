package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.intake.*;
import frc.robot.subsystems.outtake.*;
import frc.robot.subsystems.tank.*;
import org.littletonrobotics.junction.Logger;

public class RobotContainer {
    private CommandPS5Controller driverController;
    private CommandPS5Controller operatorController;

    public RobotContainer() {
        RobotState.setInstance(new RobotState());

        switch (Constants.kCurrentMode) {
            case REAL, SIM:
                Intake.createInstance(new Intake(false, new IntakeIOController()));
                Outtake.createInstance(new Outtake(false, new OuttakeIOController()));
                TankLeft.createInstance(new TankLeft(false, new TankLeftIOController()));
                TankRight.createInstance(new TankRight(false, new TankRightIOController()));
                break;

            case REPLAY:
                Intake.createInstance(new Intake(false, new IntakeIO() {}));
                Outtake.createInstance(new Outtake(false, new OuttakeIO() {}));
                TankLeft.createInstance(new TankLeft(false, new TankLeftIO() {}));
                TankRight.createInstance(new TankRight(false, new TankRightIO() {}));
                break;
        }

        driverController = new CommandPS5Controller(Constants.kDriverControllerPort);
        operatorController = new CommandPS5Controller(Constants.kOperatorControllerPort);

        configureBindings();
    }

    private void configureBindings() {

    }

    public void periodic() {
        Logger.recordOutput("Output1", 5);
    }

    public Command getAutonomousCommand() {
        return Commands.none();
    }
}
