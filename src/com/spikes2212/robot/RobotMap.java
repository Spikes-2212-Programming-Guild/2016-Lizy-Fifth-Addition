package com.spikes2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public interface CAN {
		public static final int SHOOTER_MOTOR_PORT = 1;
	}

	public interface PWM {
		public static final int DRIVETRAIN_RIGHT_FRONT_PORT = 8;
		public static final int DRIVETRAIN_RIGHT_REAR_PORT = 9;
		public static final int DRIVETRAIN_LEFT_FRONT_PORT = 2;
		public static final int DRIVETRAIN_LEFT_REAR_PORT = 1;

		public static final int TRIZ_MOTOR_PORT = 4;

		public static final int FOLDER_MOTOR_PORT = 5;

		public static final int PICKER_MOTOR_PORT = 3;

	}

	public interface DIO {
		public static final int TRIZ_UP_PORT = 4;
		public static final int TRIZ_DOWN_PORT = 5;

		public static final int FOLDER_UP_PORT = 1;
		public static final int FOLDER_DOWN_PORT = 2;

		public static final int PICKER_LIMIT_PORT = 0;
	}

}
