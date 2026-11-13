// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix6.controls.MotionMagicVoltage;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PivotSubsystem extends SubsystemBase {
  /** Creates a new PivotSubsystem. */
  public PWMTalonFX pivotMotor;

  public PIDController pidController = new PIDController(Constants.PIVOT_P, Constants.PIVOT_I, Constants.PIVOT_D);
  
  public MotionMagicVoltage requestVoltage = new MotionMagicVoltage(0.0); 
  public double angle;

  public PivotSubsystem() {
    pivotMotor = new PWMTalonFX(Constants.PIVOT_MOTOR_ID);
    angle = pivotMotor.get
  }

  public void pivotCommand(double angle) {
    pivotMotor.setVoltage(pidController.calculate(angle));

  }

  
}
