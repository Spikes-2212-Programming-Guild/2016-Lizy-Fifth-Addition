package com.spikes2212.robot.commands.triz;

import com.spikes2212.robot.Robot;
import com.spikes2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveUp extends Command {

    public MoveUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.triz);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.triz.move(RobotMap.Speed.TRIZ_UP_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.triz.move(0);
    }
}
