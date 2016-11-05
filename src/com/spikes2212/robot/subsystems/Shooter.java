package com.spikes2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private VictorSP shootingMotor;
	
	public Shooter(DigitalInput loadingLimit, VictorSP picker,VictorSP shootingMotor) {
		this.shootingMotor = shootingMotor;
	}
	public void shoot(double speed){
		shootingMotor.set(speed);
	}

    public void initDefaultCommand() {
       
    }
}

