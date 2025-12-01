// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intake;

import java.util.Set;

import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonConfig;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.Data;
import frc.demacia.utils.Log.LogManager;

public class RailSubsystem extends SubsystemBase {
  
  private final String name_Of_railMotor = "Rail";
  private final int id  = 9;
  private TalonMotor railMotor;
  private double EXTEND_SPEED;
  private double RETRACT_SPEED;

  public RailSubsystem (){
    TalonConfig railConfig = new TalonConfig(id, Canbus.Rio, name_Of_railMotor)
      .withCurrent(40)
      .withPID(0.5,0,0,0.12,0.3,0.3,0)
      .withBrake(false)
      .withMeterMotor(5.0, 0.08); // gear ratio and wheel diameter - adjust for your mechanism
    
      LogManager.log("Roller Subsystem initialized");
      

  }
  public enum RailState {
    IDLE,
    EXTENDING,
    RETRACTING
  }

  public void setPowerToEXTEND(){
    railMotor.setDuty(EXTEND_SPEED);
  }

  public void setPowertoRETRACT(){
    railMotor.setDuty(RETRACT_SPEED);
  } 
    // Check motor electronics for faults
   public void checkElectronics() {
    railMotor.checkElectronics();
   }

   
   public double volte(){
    return railMotor.getCurrentVoltage();
   }
   
  }