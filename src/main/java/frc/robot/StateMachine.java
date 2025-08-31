package frc.robot;

import frc.lib.NinjasLib.statemachine.StateMachineBase;

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
                    States.PREPARE_SHOOT,
                    States.CLOSE
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

    }
}
