/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 *
 * This is a basic project to implement a Mecanum Drive Train using the Spark
 * MAX motor controllers (with brushless motors).
 *
 * UPDATE 1: Added shifter code UPDATE 2: Linked Mecanum and arcade (although
 * this time it's just modified mecanum) to the shifter code. UPDATE 3: Added
 * configurable deadband and fixed ramprate. UPDATE 4: Added lifter, elevator,
 * and herder motors.
 */
public class Robot extends TimedRobot {
  public CANSparkMax m1;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // initialize motors
    m1 = new CANSparkMax(13, MotorType.kBrushless);

    SmartDashboard.putNumber("Motor One" , 0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    /**
     * Logitech Controller ("Joystick") axis map: 0 - Left stick X 1 - Left stick Y
     * 2 - Left analog trigger 3 - Right analog trigger 4 - Right stick X 5 - Right
     * stick Y
     */
    m1.set(0.25);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    m1.set(SmartDashboard.getNumber("Motor One", 0));
  }
}
