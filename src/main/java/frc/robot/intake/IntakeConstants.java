// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intake;

import edu.wpi.first.units.measure.Voltage;
import frc.demacia.utils.Data;
import frc.demacia.utils.Motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.Motors.TalonConfig;


public class IntakeConstants {
    
    public static class OperatorConstants {
        public Data<Voltage> voltageSignal;
    public static final double RETRACTED_POSITION = 0.0;
    public static final double EXTENDED_POSITION = 0.03; // Adjust this value
    public static final double POSITION_TOLERANCE = 0.02;
    public static final double maxCurrent = 40;
    public static final double rotation = 5;

    public static final double EXTEND_SPEED = 0.5;
    public static final double RETRACT_SPEED = -0.5;
    
        public final int id  = 9;
        private final String name_Of_railMotor = "Rail";

        public final TalonConfig railConfig = new TalonConfig(id, Canbus.Rio, name_Of_railMotor)
         .withCurrent(40)
         .withPID(0.5,0,0,0.12,0.3,0.3,0)
         .withBrake(false)
         .withMeterMotor(5.0, 0.08); // gear ratio and wheel diameter - adjust for your mechanism
    
      
        
        
    
//   private final String name = "Rail";
    // Rail speeds
    
    }
            
    
}
