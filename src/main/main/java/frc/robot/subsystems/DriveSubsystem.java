// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package DriveSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import frc.robot.commands.DriveCommand;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  public PWMTalonFX driveMotor1;
  public PWMTalonFX driveMotor2;

  public DriveSubsystem() {
    driveMotor1 = new PWMTalonFX(DriveConstants.DRIVE_MOTOR_1_ID);
    driveMotor2 = new PWMTalonFX(DriveConstants.DRIVE_MOTOR_2_ID);
    driveMotor2.setInverted(true);
    tankDrive = new DifferentialDrive(driveMotor1, driveMotor2);
  }
  public void Drive(double leftDoubleSupplier, double rightDoubleSupplier) {
    tankDrive.arcadeDrive(leftSpeed, rightSpeed, true);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
