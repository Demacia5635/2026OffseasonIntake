// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intakeCommend;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.intakeSubsystem.RailSubsystem;
import frc.robot.intakeSubsystem.IntakeConstants.OperatorConstants;

public class TakeOutRails extends Command {
private RailSubsystem rail;
private double startingRotaion;

  /** Creates a new TakeOutRails. */
  public TakeOutRails (RailSubsystem rail) {
    this.rail= rail;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(rail);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startingRotaion = rail.getrotation();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rail.setPower(OperatorConstants.EXTEND_SPEED );

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rail.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return rail.getrotation() > OperatorConstants.ROTATION+startingRotaion;
  }
}
