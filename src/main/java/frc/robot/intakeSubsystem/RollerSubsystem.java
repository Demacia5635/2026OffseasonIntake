package frc.robot.intakeSubsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonConfig;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.Log.LogManager;

public class RollerSubsystem extends SubsystemBase{
  private final TalonMotor rollerMotor;
  private final double INTAKE_POWER;

  
  public RollerSubsystem(TalonConfig rollerConfig, double INTAKE_POWER) {

    rollerMotor = new TalonMotor(rollerConfig);

    this.INTAKE_POWER = INTAKE_POWER;
    LogManager.log("Roller Subsystem initialized");
  }

  /**
   * Runs rollers to intake game pieces
   */
  public void intake_() {
    rollerMotor.setDuty(INTAKE_POWER);
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