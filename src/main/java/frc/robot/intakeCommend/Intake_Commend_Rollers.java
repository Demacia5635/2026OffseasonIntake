// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.intakeCommend;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.intakeSubsystem.RailSubsystem;
import frc.robot.intakeSubsystem.RollerSubsystem;

public class Intake_Commend_Rollers extends Command {
  RollerSubsystem rollers;
  RailSubsystem rail;

  public Intake_Commend_Rollers(RollerSubsystem rollers, RailSubsystem rails) {
    this.rollers = rollers;
    this.rail = rails;

  }
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}