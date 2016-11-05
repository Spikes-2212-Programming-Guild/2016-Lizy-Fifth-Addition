package com.spikes2212.robot.commands.drivetrain;

import com.spikes2212.robot.OI;
import com.spikes2212.robot.Robot;
import com.spikes2212.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickMoveFoward extends Command {
    
	
	public JoystickMoveFoward() {
       	requires(Robot.drivetrain);
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(Robot.oi.getRightY());
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
    	Robot.drivetrain.drive(0);
    }
}
