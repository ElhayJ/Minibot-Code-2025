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
        RobotState.setInstance(new RobotState());

        switch (Constants.kCurrentMode) {
            case REAL, SIM:
                intake = new Intake(false, new IntakeIOController());
                outtake = new Outtake(false, new OuttakeIOController());
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

    private void configureBindings() {
        controller.cross().toggleOnTrue(
                Commands.runOnce(() -> StateMachine.getInstance().changeRobotState(States.INTAKE))
        );
        controller.cross().toggleOnFalse(
                Commands.runOnce(() -> StateMachine.getInstance().changeRobotState(States.POWER_CELL_IN_SYSTEM))
        );
        controller.L2().onTrue(Commands.runOnce(() -> StateMachine.getInstance().changeRobotState(States.PREPARE_SHOOT)));
        controller.circle().onTrue(Commands.runOnce(() -> StateMachine.getInstance().changeRobotState(States.CLOSE)));
    }

    public void periodic() {

    }

    public Command getAutonomousCommand() {
        return Commands.none();
    }
}
