package com.spikes2212.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon shootingMotor;
	
	public Shooter(CANTalon shootingMotor) {
		this.shootingMotor = shootingMotor;
	}
	public void shoot(double speed){
		shootingMotor.set(speed);
	}

    public void initDefaultCommand() {
       
    }
}

