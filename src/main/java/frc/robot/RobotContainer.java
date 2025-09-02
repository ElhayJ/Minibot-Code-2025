package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.IntakeIO;
import frc.robot.subsystems.intake.IntakeIOController;
import frc.robot.subsystems.outtake.Outtake;
import frc.robot.subsystems.outtake.OuttakeIO;
import frc.robot.subsystems.outtake.OuttakeIOController;
import frc.robot.subsystems.tank.Tank;
import frc.robot.subsystems.tank.TankIO;
import frc.robot.subsystems.tank.TankIOController;

public class RobotContainer {
    private CommandPS5Controller controller;
    private static Tank tank;
    private static Intake intake;
    private static Outtake outtake;

    public RobotContainer() {
        switch (Constants.kCurrentMode) {
            case REAL, SIM:
                intake = new Intake(true, new IntakeIOController());
                outtake = new Outtake(true, new OuttakeIOController());
                tank = new Tank(true, new TankIOController());
                break;

            case REPLAY:
                intake = new Intake(false, new IntakeIO() {
                });
                outtake = new Outtake(false, new OuttakeIO() {
                });
                tank = new Tank(false, new TankIO() {
                });
                break;
        }

        controller = new CommandPS5Controller(Constants.kControllerPort);

        configureBindings();
    }

    public static Intake getIntake() {
        return intake;
    }

    public static Outtake getOuttake() {
        return outtake;
    }

    public static Tank getTank() {
        return tank;
    }

    private double r2 = 0;
    private void configureBindings() {
        controller.R2().whileTrue(intake.setPercent(() -> r2));
        controller.R2().onFalse(intake.setPercent(() -> 0));

        controller.L2().onTrue(outtake.setPercent(1));
        controller.L2().onFalse(outtake.setPercent(0));

        controller.circle().onTrue(Commands.runOnce(() -> {
            outtake.setPercent(0);
            intake.setPercent(() -> 0);
        }));
    }

    public void periodic() {
        tank.setPercent(controller.getLeftY() - controller.getRightX(), controller.getLeftY() + controller.getRightX());
        r2 = controller.getRawAxis(4);
    }

    public Command getAutonomousCommand() {
        return Commands.none();
    }
}
