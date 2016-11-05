package com.spikes2212.robot.commands;

import com.spikes2212.robot.Robot;
import com.spikes2212.robot.subsystems.Loader;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PassToShooter extends Command {
	public final static double PICK_SPEED = 0.7;

	public PassToShooter() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.loader);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.loader.pick(PICK_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !Robot.loader.isLoaded() || isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.loader.pick(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
