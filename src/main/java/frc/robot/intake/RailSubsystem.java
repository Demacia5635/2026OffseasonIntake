// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonConfig;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.Log.LogManager;

public class RailSubsystem extends SubsystemBase {
  
  private final TalonMotor railMotor;
  private final String name = "Rail";
  
  // Rail positions (in meters or rotations - adjust based on your mechanism)
  private static final double RETRACTED_POSITION = 0.0;
  private static final double EXTENDED_POSITION = 0.5; // Adjust this value
  private static final double POSITION_TOLERANCE = 0.02;
  
  // Rail speeds
  private static final double EXTEND_SPEED = 0.5;
  private static final double RETRACT_SPEED = -0.5;

  public RailSubsystem() {
    // Configure the rail motor
    TalonConfig railConfig = new TalonConfig(10, Canbus.Rio, "Rail Motor")
        .withBrake(true)
        .withInvert(false)
        .withCurrent(30)
        .withRampTime(0.1)
        .withMeterMotor(1.0, 0.05) // Adjust gear ratio and diameter for your mechanism
        .withPID(2.0, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0) // Tune these PID values
        .withMotionParam(1.5, 2.0, 0.0); // Max velocity, acceleration, jerk
    
    railMotor = new TalonMotor(railConfig);
    //railMotor.setEncoderPosition(0); // Start at retracted position
    
    LogManager.log(name + " subsystem initialized");
  }

  /**
   * Extend the rail to the extended position using Motion Magic
   */
  public void extend() {
    railMotor.setMotion(EXTENDED_POSITION);
  }

  /**
   * Retract the rail to the retracted position using Motion Magic
   */
  public void retract() {
    railMotor.setMotion(RETRACTED_POSITION);
  }

  /**
   * Move the rail to a specific position
   * @param position Target position in meters
   */
  public void setPosition(double position) {
    railMotor.setMotion(position);
  }

  /**
   * Manually control the rail with a power value
   * @param power Power from -1.0 to 1.0
   */
  public void setPower(double power) {
    railMotor.setDuty(power);
  }

  /**
   * Stop the rail motor
   */
  public void stop() {
    railMotor.setDuty(0);
  }

  /**
   * Check if the rail is at the extended position
   * @return true if extended
   */
  public boolean isExtended() {
    return Math.abs(getCurrentPosition() - EXTENDED_POSITION) < POSITION_TOLERANCE;
  }

  /**
   * Check if the rail is at the retracted position
   * @return true if retracted
   */
  public boolean isRetracted() {
    return Math.abs(getCurrentPosition() - RETRACTED_POSITION) < POSITION_TOLERANCE;
  }

  /**
   * Check if the rail is at the target position
   * @return true if at target
   */
  public boolean atTarget() {
    return Math.abs(railMotor.getCurrentClosedLoopError()) < POSITION_TOLERANCE;
  }

  /**
   * Get the current position of the rail
   * @return Current position in meters
   */
  public double getCurrentPosition() {
    return railMotor.getCurrentPosition();
  }

  /**
   * Get the current velocity of the rail
   * @return Current velocity in meters per second
   */
  public double getCurrentVelocity() {
    return railMotor.getCurrentVelocity();
  }

  /**
   * Get the current draw of the motor
   * @return Current in amps
   */
  public double getCurrent() {
    return railMotor.getCurrentCurrent();
  }

  /**
   * Reset the encoder position to zero
   */
  //public void resetEncoder() {
    //railMotor.setEncoderPosition(0);
  //}

  /**
   * Set brake mode
   * @param brake true for brake, false for coast
   */
  public void setBrakeMode(boolean brake) {
    railMotor.setNeutralMode(brake);
  }

  /**
   * Check motor electronics for faults
   */
  public void checkElectronics() {
    railMotor.checkElectronics();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // Add any periodic checks or telemetry here if needed
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}