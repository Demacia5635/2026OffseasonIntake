// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intakeSubsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Log.LogManager;
import frc.robot.intakeSubsystem.IntakeConstants;


public class RailSubsystem extends SubsystemBase {
  private boolean isMovingOut = false;
  private TalonMotor railMotor;

  public RailSubsystem (){
    railMotor = new TalonMotor(IntakeConstants.railConfig);
    LogManager.log("rail Subsystem initialized");
  }



  public boolean getIsMovingOut(){
    return isMovingOut;
  }

  public void setIsMovingOut(boolean state){
    isMovingOut = state;
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

   @Override
   public void periodic() {
    } 
  }