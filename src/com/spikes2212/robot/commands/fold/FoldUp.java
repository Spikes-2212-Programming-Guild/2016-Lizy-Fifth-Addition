package com.spikes2212.robot.commands.fold;

import com.spikes2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FoldUp extends Command {
	public final static double UP_SPEED = 0.7;
    public FoldUp() {
    	requires(Robot.folder);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.folder.turn(UP_SPEED);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.folder.canMove(UP_SPEED)||isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
