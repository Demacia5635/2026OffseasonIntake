// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intake;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RailSubsystem extends SubsystemBase {
  /** Creates a new Rail. */
  TalonFX railMotor = new TalonFX(10);


  public RailSubsystem(TalonFX motor) {
    this.railMotor = motor;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
