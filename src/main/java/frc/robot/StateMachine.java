package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import frc.lib.NinjasLib.statemachine.StateMachineBase;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.outtake.Outtake;
import frc.robot.subsystems.tank.Tank;

import java.util.Set;

public class StateMachine extends StateMachineBase<States> {

    @Override
    protected boolean canChangeRobotState(States currentState, States wantedState) {
        return switch (currentState) {
            case IDLE -> Set.of(
                    States.INTAKE
            ).contains(wantedState);

            case CLOSE -> Set.of(
                    States.IDLE
            ).contains(wantedState);

            case INTAKE -> Set.of(
                    States.POWER_CELL_IN_SYSTEM,
                    States.CLOSE
            ).contains(wantedState);

            case POWER_CELL_IN_SYSTEM -> Set.of(
                    States.PREPARE_SHOOT
            ).contains(wantedState);

            case PREPARE_SHOOT -> Set.of(
                    States.SHOOT,
                    States.CLOSE
            ).contains(wantedState);

            case SHOOT -> Set.of(
                    States.CLOSE
            ).contains(wantedState);

        };
    }

    @Override
    protected void setCommandMap() {
        Intake intake = RobotContainer.getIntake();
        Outtake outtake = RobotContainer.getOuttake();
        Tank tank = RobotContainer.getTank();

        //region IDLE
        addCommand(States.IDLE, Commands.none());
        //endregion

        //region CLOSE
        addCommand(States.CLOSE, Commands.sequence(
                intake.setPercent(0),
                outtake.setPercent(0),
                Commands.runOnce(() -> changeRobotState(States.IDLE))
        ));
        //endregion

        //region INTAKE
        addCommand(States.INTAKE, intake.setPercent(1));
        //endregion

        //region POWER_CELL_IN_SYSTEM
        addCommand(States.POWER_CELL_IN_SYSTEM, intake.setPercent(0));
        //endregion

        //region PREPARE_SHOOT
        addCommand(States.PREPARE_SHOOT, Commands.sequence(
            outtake.setPercent(1),
            Commands.waitSeconds(2),
            Commands.runOnce(() -> {changeRobotState(States.SHOOT);}))
        );
        //endregion

        //region SHOOT
        addCommand(States.SHOOT, Commands.sequence(
        intake.setPercent(1),
        Commands.waitSeconds(1),
        Commands.runOnce(() -> {changeRobotState(States.SHOOT);})
        ));
        //endregion
    }
}
