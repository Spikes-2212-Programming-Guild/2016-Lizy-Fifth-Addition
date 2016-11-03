package com.spikes2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Triz extends Subsystem {

	private DigitalInput up;
	private DigitalInput down;

	private VictorSP motor;

	public Triz(DigitalInput up, DigitalInput down, VictorSP motor) {
		this.up = up;
		this.down = down;

		this.motor = motor;
	}

	public Triz(int portUp, int portDown, int portMotor) {
		up = new DigitalInput(portUp);
		down = new DigitalInput(portDown);

		motor = new VictorSP(portMotor);

	}

	public void move(double speed) {
		if (canMove(speed)) {
			motor.set(speed);
		}
	}

	public boolean canMove(double speed) {
		return !(up.get() && speed > 0 || down.get() && speed < 0);
	}

	public void initDefaultCommand() {

	}
}
