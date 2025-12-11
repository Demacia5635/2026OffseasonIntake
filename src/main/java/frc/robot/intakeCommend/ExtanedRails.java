// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intakeCommend;
import frc.robot.intakeSubsystem.IntakeConstants;
import frc.robot.intakeSubsystem.RailSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class ExtanedRails extends Command {
  private RailSubsystem rail;

  /** Creates a new calibration. */
  public ExtanedRails(RailSubsystem rail) {
    this.rail= rail;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(rail);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rail.setPower(IntakeConstants.RETRACT_SPEED);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rail.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return rail.getCurrent() > IntakeConstants.STOPCURRENT;
  }
}
