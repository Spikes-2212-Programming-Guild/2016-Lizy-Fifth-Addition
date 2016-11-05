package com.spikes2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Loader extends Subsystem {
	private DigitalInput loadingLimit;
	private VictorSP picker;

	public Loader(DigitalInput loadingLimit, VictorSP picker) {
		this.loadingLimit = loadingLimit;
		this.picker = picker;
	}

	public boolean isLoaded() {
		return !loadingLimit.get();
	}

	public void pick(double speed) {
		picker.set(speed);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
