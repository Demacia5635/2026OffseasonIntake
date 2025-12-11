// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intakeSubsystem;


import frc.demacia.utils.Motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.Motors.TalonConfig;


public class IntakeConstants {
    
    public static final double MAXSPEED = 40;
    public static final double ROTATION = 5;
    //TODO:need to chack what is the currnt to the stoping point
    public static final double STOPCURRENT = 30;

    public static final double EXTEND_SPEED = 0.3;
    public static final double RETRACT_SPEED = -0.3;
    public static final double GEAR_RATIO = -1;
    public static final int id  = 9;
    public static final int ROLLER_MOTOR_ID  = 9;
    private static final String NAME_OF_RAILMOTOR = "Rail";

        public static final TalonConfig RAIL_CONFIG = new TalonConfig(id, Canbus.Rio, NAME_OF_RAILMOTOR)
         .withMeterMotor(-1, -1); // gear ratio and wheel diameter - adjust for your mechanism
    public static final double INTAKE_POWER = 0.7;


    TalonConfig rollerConfig = new TalonConfig(ROLLER_MOTOR_ID, Canbus.Rio, "Roller Motor")
        .withMeterMotor(5.0, 0.08) // gear ratio and wheel diameter - adjust for your mechanism
        .withBrake(false) // Coast mode for rollers
        .withCurrent(40) // 40A current limit
        .withPID(0.5, 0.0, 0.0, 0.1, 0.12, 0.0, 0.0); // kP, kI, kD, kS, kV, kA, kG
     }
      
        
        
    
//   private final String name = "Rail";
    // Rail speeds

            
      

