package frc.robot.intake;

import frc.demacia.utils.Motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.Motors.TalonConfig;

public class IntakeConstants {
      
    // Roller configuration constants
    private static final int ROLLER_MOTOR_ID = 9;
    public static final double INTAKE_POWER = 0.7;


    TalonConfig rollerConfig = new TalonConfig(ROLLER_MOTOR_ID, Canbus.Rio, "Roller Motor")
        .withMeterMotor(5.0, 0.08) // gear ratio and wheel diameter - adjust for your mechanism
        .withBrake(false) // Coast mode for rollers
        .withCurrent(40) // 40A current limit
        .withPID(0.5, 0.0, 0.0, 0.1, 0.12, 0.0, 0.0); // kP, kI, kD, kS, kV, kA, kG
}
