package com.spikes2212.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Folder extends Subsystem {
    
    private VictorSP folderMotor;
    
    public Folder (VictorSP folderMotor){
    	this.folderMotor = folderMotor;
    }
    public void Turn(double speed){
    	folderMotor.set(speed);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

