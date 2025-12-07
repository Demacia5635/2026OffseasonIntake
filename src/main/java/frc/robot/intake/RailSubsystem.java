// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonConfig;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Log.LogManager;

public class RailSubsystem extends SubsystemBase {
  private TalonMotor railMotor;
  // private double EXTEND_SPEED;
  // private double RETRACT_SPEED;
 


  public RailSubsystem (TalonConfig railConfig){
    railMotor = new TalonMotor(railConfig);

    LogManager.log("rail Subsystem initialized");

    
  }
   public void setNeutralMode(boolean isBrake) {
    railMotor.setNeutralMode(isBrake);
  }
  public double getrotation(){
    return railMotor.getCurrentPosition();
  }

  public void setPower(double power){
    railMotor.setDuty(power);
  }
  public double getCurrent() {
    return railMotor.getCurrentCurrent();
  }
  
    // Check motor electronics for faults
   public void checkElectronics() {
    railMotor.checkElectronics();
   }
   
   public double voltage(){
    return railMotor.getCurrentVoltage();
   }
   @Override
   public void periodic() {
       
    
    } 
  }