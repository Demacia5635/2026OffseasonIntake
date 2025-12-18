// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intakeSubsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Log.LogManager;

public class RollerSubsystem extends SubsystemBase {
  private final TalonMotor rollerMotor;

  public RollerSubsystem() {
    rollerMotor = new TalonMotor(IntakeConstants.rollerConfig);
    LogManager.log("Roller Subsystem initialized");
  }

  /**
   * Runs rollers to intake game pieces
   */
  public void setPower(double power) {
    rollerMotor.setDuty(power);
  }
  /**
   * Stops the roller motor
   */
  public void stop() {
    rollerMotor.stopMotor();
  }
  /**
   * Checks if roller motor has any faults
   */
  public void checkElectronics() {
    rollerMotor.checkElectronics();
  }
}
