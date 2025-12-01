// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonConfig;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Motors.BaseMotorConfig.Canbus;
import frc.robot.intake.IntakeConstants; 
import frc.demacia.utils.Log.LogManager;

public class RollerSubsystem extends SubsystemBase {
  private final TalonMotor rollerMotor;

  // Roller configuration constants
  private static final int ROLLER_MOTOR_ID;
  private static final double INTAKE_VELOCITY;
  private static final double OUTTAKE_VELOCITY;
  private static final double SLOW_INTAKE_VELOCITY;

  public RollerSubsystem(TalonConfig rollerConfig) {
    
    rollerMotor = new TalonMotor(rollerConfig);
    
    LogManager.log("Roller Subsystem initialized");
  }

  /**
   * Runs rollers to intake game pieces
   */
  public void intake() {
    rollerMotor.setVelocity(INTAKE_VELOCITY);
  }

  /**
   * Runs rollers slowly for controlled intake
   */
  public void intakeSlow() {
    rollerMotor.setVelocity(SLOW_INTAKE_VELOCITY);
  }

  /**
   * Runs rollers to outtake/eject game pieces
   */
  public void outtake() {
    rollerMotor.setVelocity(OUTTAKE_VELOCITY);
  }

  /**
   * Stops the roller motor
   */
  public void stop() {
    rollerMotor.stopMotor();
  }

  /**
   * Sets roller velocity directly
   * @param velocity Target velocity in meters per second
   */
  public void setVelocity(double velocity) {
    rollerMotor.setVelocity(velocity);
  }

  /**
   * Sets roller power directly (for manual control)
   * @param power Power from -1.0 to 1.0
   */
  public void setPower(double power) {
    rollerMotor.setDuty(power);
  }

  /**
   * Gets current roller velocity
   * @return Velocity in meters per second
   */
  public double getVelocity() {
    return rollerMotor.getCurrentVelocity();
  }

  /**
   * Gets current roller motor current
   * @return Current in amps
   */
  public double getCurrent() {
    return rollerMotor.getCurrentCurrent();
  }

  /**
   * Checks if rollers are spinning at target speed
   * @param targetVelocity Target velocity to check against
   * @param tolerance Tolerance in m/s
   * @return True if within tolerance
   */
  public boolean isAtVelocity(double targetVelocity, double tolerance) {
    return Math.abs(getVelocity() - targetVelocity) < tolerance;
  }

  /**
   * Checks if a game piece is detected based on current spike
   * @param currentThreshold Current threshold in amps
   * @return True if current exceeds threshold (indicating game piece)
   */
  public boolean hasGamePiece(double currentThreshold) {
    return getCurrent() > currentThreshold;
  }

  /**
   * Checks if roller motor has any faults
   */
  public void checkElectronics() {
    rollerMotor.checkElectronics();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // Add any periodic checks or logging here if needed
  }
}