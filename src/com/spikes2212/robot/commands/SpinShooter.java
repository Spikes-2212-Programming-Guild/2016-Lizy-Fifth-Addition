package com.spikes2212.robot.commands;

import com.spikes2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinShooter extends Command {
	public final static double SHOOT_SPEED = 0.7;

	public SpinShooter() {

		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooter.shoot(SHOOT_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !Robot.loader.isLoaded() || isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.shoot(0);
	}

	protected void interrupted() {
		end();
		// TODO Auto-generated method stub
		
	}
}
