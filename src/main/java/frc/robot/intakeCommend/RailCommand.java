// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.intakeCommend;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.intakeSubsystem.RailSubsystem;
import frc.robot.RobotContainer;
import frc.robot.intakeSubsystem.IntakeConstants;

public class RailCommand extends Command {
private RailSubsystem rail;
private Timer timer;



  /** Creates a new TakeOutRails. */
  public RailCommand (RailSubsystem rail) {
    this.rail= rail;
    this.timer = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(rail);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    rail.setIsMovingOut(!rail.getIsMovingOut());
    if(RobotContainer.rollerCommand != null) RobotContainer.rollerCommand.schedule();
    timer.reset();
    timer.start();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rail.setPower(rail.getIsMovingOut() ? IntakeConstants.RAIL_POWER : -IntakeConstants.RAIL_POWER);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rail.setPower(0);
    timer.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    if (rail.getIsMovingOut()) {
      return timer.hasElapsed(IntakeConstants.RAIL_OUT_TIME_SECONDS);
    }
    else {
      return rail.getCurrent() > IntakeConstants.STOPCURRENT;
    }
  }
}
