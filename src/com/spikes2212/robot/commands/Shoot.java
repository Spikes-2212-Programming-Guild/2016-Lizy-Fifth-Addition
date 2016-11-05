package com.spikes2212.robot.commands;
import com.spikes2212.robot.commands.spinShooter.*;
import com.spikes2212.robot.commands.load.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Shoot extends CommandGroup {
    
    public  Shoot() {
    	addSequential(new SpinShooter(), 1); 
    	addParallel(new PassToShooter());
    	addSequential(new SpinShooter(),0.4);
       
    }
}
