package com.spikes2212.robot.subsystems;

import com.spikes2212.utils.Gearbox;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	private Gearbox leftGearbox; 
	private Gearbox rightGearbox;
	
	public Drivetrain(Gearbox leftGearbox, Gearbox rightGearbox){
		this.leftGearbox = leftGearbox;
		this.rightGearbox = rightGearbox;
	}
	
	public void drive(double speed){
		leftGearbox.setSpeed(-speed);
		rightGearbox.setSpeed(speed);
	}
	
	public void turn(double speed){
		leftGearbox.setSpeed(speed);
		rightGearbox.setSpeed(speed);
	}
	
    public void initDefaultCommand() {

    }
    
}

