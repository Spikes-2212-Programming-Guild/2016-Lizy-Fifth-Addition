
package com.spikes2212.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.spikes2212.robot.subsystems.Drivetrain;
import com.spikes2212.robot.subsystems.Folder;
import com.spikes2212.robot.subsystems.Loader;
import com.spikes2212.robot.subsystems.Triz;
import com.spikes2212.robot.subsystems.Shooter;
import com.spikes2212.utils.Gearbox;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Loader loader;
	private Gearbox leftGearbox, rightGearbox;
	public static Drivetrain drivetrain;
	public static Triz triz;
	public static Shooter shooter;
	public static Folder folder;

	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		
		// chooser.addObject("My Auto", new MyAutoCommand());

		rightGearbox = new Gearbox(RobotMap.PWM.DRIVETRAIN_RIGHT_FRONT_PORT, RobotMap.PWM.DRIVETRAIN_RIGHT_REAR_PORT);
		leftGearbox = new Gearbox(RobotMap.PWM.DRIVETRAIN_LEFT_FRONT_PORT, RobotMap.PWM.DRIVETRAIN_LEFT_REAR_PORT);
		triz = new Triz(RobotMap.DIO.TRIZ_UP_PORT, RobotMap.DIO.TRIZ_DOWN_PORT, RobotMap.PWM.TRIZ_MOTOR_PORT);
		loader = new Loader(new DigitalInput(RobotMap.DIO.PICKER_LIMIT_PORT),new VictorSP(RobotMap.PWM.PICKER_MOTOR_PORT));
		shooter = new Shooter(new CANTalon(RobotMap.CAN.SHOOTER_MOTOR_PORT));
		folder = new Folder(new VictorSP(RobotMap.PWM.FOLDER_MOTOR_PORT), new DigitalInput(RobotMap.DIO.FOLDER_UP_PORT),new DigitalInput(RobotMap.DIO.FOLDER_DOWN_PORT));

		drivetrain = new Drivetrain(leftGearbox, rightGearbox);
//		
//		oi = new OI();
		
		System.out.println("INIT DONE");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();

		/*	
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
