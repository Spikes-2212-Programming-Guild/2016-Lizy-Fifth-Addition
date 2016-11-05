package com.spikes2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Folder extends Subsystem {

	private VictorSP folderMotor;

	private DigitalInput up;
	private DigitalInput down;

	public Folder(VictorSP folderMotor, DigitalInput up, DigitalInput down) {
		this.folderMotor = folderMotor;
		this.up = up;
		this.down = down;
	}

	public void turn(double speed) {
		folderMotor.set(speed);
	}

	public boolean canMove(double speed) {
		return !(up.get() && speed > 0 || down.get() && speed < 0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
