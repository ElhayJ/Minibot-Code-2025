package frc.robot;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import frc.lib.NinjasLib.controllers.constants.ControlConstants;
import frc.lib.NinjasLib.controllers.constants.ControllerConstants;
import frc.lib.NinjasLib.controllers.constants.RealControllerConstants;

public class Constants {
    public enum RobotMode {
        /** Running on a real robot */
        REAL,

        /** Running on a simulator */
        SIM,

        /** Replaying from a log file */
        REPLAY
    }

    /* General */
    public static final RobotMode kSimMode = RobotMode.SIM;
    public static final RobotMode kCurrentMode = Robot.isReal() ? RobotMode.REAL : kSimMode;
    public static final int kControllerPort = 0;

    /* Subsystems */
    public static final ControllerConstants kExampleSubsystemControllerConstants = new ControllerConstants();
    static {
        /* Base */
        kExampleSubsystemControllerConstants.real.main.id = 20;
        kExampleSubsystemControllerConstants.real.main.inverted = false;
        kExampleSubsystemControllerConstants.real.currentLimit = 80;
        kExampleSubsystemControllerConstants.real.isBrakeMode = true;

        /* Followers */
        kExampleSubsystemControllerConstants.real.followers = new RealControllerConstants.SimpleControllerConstants[1];
        kExampleSubsystemControllerConstants.real.followers[0] = new RealControllerConstants.SimpleControllerConstants();
        kExampleSubsystemControllerConstants.real.followers[0].id = 21;
        kExampleSubsystemControllerConstants.real.followers[0].inverted = true;

        /* Control */
        kExampleSubsystemControllerConstants.real.controlConstants = ControlConstants.createPID(1, 0, 0, 0);
        kExampleSubsystemControllerConstants.real.gearRatio = 50;
        kExampleSubsystemControllerConstants.real.conversionFactor = 2 * Math.PI;
        kExampleSubsystemControllerConstants.real.homePosition = Units.degreesToRadians(-60);
        kExampleSubsystemControllerConstants.real.positionGoalTolerance = Units.degreesToRadians(1.5);

        /* Soft Limits */
        kExampleSubsystemControllerConstants.real.maxSoftLimit = Units.degreesToRadians(240);

        /* Hard Limit */
        kExampleSubsystemControllerConstants.real.isLimitSwitch = true;
        kExampleSubsystemControllerConstants.real.limitSwitchID = 2;
        kExampleSubsystemControllerConstants.real.limitSwitchDirection = -1;
        kExampleSubsystemControllerConstants.real.limitSwitchAutoStopReset = true;
        kExampleSubsystemControllerConstants.real.limitSwitchInverted = true;

        /* Simulation */
        kExampleSubsystemControllerConstants.motorType = DCMotor.getKrakenX60(2);
    }

    public static final ControllerConstants kIntakeControllerConstants = new ControllerConstants();
    static {
        /* Base */
        kIntakeControllerConstants.real.main.id = 20;
        kIntakeControllerConstants.real.main.inverted = false;
        kIntakeControllerConstants.real.currentLimit = 60;
        kIntakeControllerConstants.real.isBrakeMode = true;

        /* Simulation */
        kIntakeControllerConstants.motorType = DCMotor.getCIM(1);
    }

    public static final ControllerConstants kOuttakeControllerConstants = new ControllerConstants();
    static {
        /* Base */
        kOuttakeControllerConstants.real.main.id = 30;
        kOuttakeControllerConstants.real.main.inverted = false;
        kOuttakeControllerConstants.real.currentLimit = 60;
        kOuttakeControllerConstants.real.isBrakeMode = false;

        /* Simulation */
        kOuttakeControllerConstants.motorType = DCMotor.getKrakenX60(1);
    }


    public static final ControllerConstants kTankLeftControllerConstants = new ControllerConstants();
    static {
        /* Base */
        kTankLeftControllerConstants.real.main.id = 11;
        kTankLeftControllerConstants.real.main.inverted = true;
        kTankLeftControllerConstants.real.currentLimit = 60;
        kTankLeftControllerConstants.real.isBrakeMode = true;

        /* Simulation */
        kTankLeftControllerConstants.motorType = DCMotor.getNEO(1);
    }

    public static final ControllerConstants kTankRightControllerConstants = new ControllerConstants();
    static {
        /* Base */
        kTankRightControllerConstants.real.main.id = 10;
        kTankRightControllerConstants.real.main.inverted = false;
        kTankRightControllerConstants.real.currentLimit = 60;
        kTankRightControllerConstants.real.isBrakeMode = true;

        /* Simulation */
        kTankRightControllerConstants.motorType = DCMotor.getNEO(1);
    }
}
