package com.spikes2212.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.spikes2212.robot.commands.Shoot;
import com.spikes2212.robot.commands.drivetrain.JoystickTurn;
import com.spikes2212.robot.commands.fold.FoldDown;
import com.spikes2212.robot.commands.fold.FoldUp;
import com.spikes2212.robot.commands.load.Load;
import com.spikes2212.robot.commands.triz.MoveDown;
import com.spikes2212.robot.commands.triz.MoveUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* gevald */{
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// // joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public final Joystick rightStick = new Joystick(0);

	public final Button trizUpButton;
	public final Button trizDownButton;

	public final Button folderUpButton;
	public final Button folderDownButton;

	public final Button shootButton;

	public final Button pickButton;

	public final Button turnButton;

	public OI() {
		trizUpButton = new JoystickButton(rightStick, 3);
		trizDownButton = new JoystickButton(rightStick, 2);

		folderUpButton = new JoystickButton(rightStick, 6);
		folderDownButton = new JoystickButton(rightStick, 7);

		shootButton = new JoystickButton(rightStick, 5);

		pickButton = new JoystickButton(rightStick, 4);

		turnButton = new JoystickButton(rightStick, 1);
		trizUpButton.whileHeld(new MoveUp());
		trizDownButton.whileHeld(new MoveDown());

		folderUpButton.whileHeld(new FoldUp());
		folderDownButton.whileHeld(new FoldDown());

		shootButton.whenPressed(new Shoot());

		pickButton.whenPressed(new Load());

		turnButton.whileHeld(new JoystickTurn());

	}

	public double getRightY() {
		return rightStick.getY();
	}

	public double getRightX() {
		return rightStick.getX();
	}
}
