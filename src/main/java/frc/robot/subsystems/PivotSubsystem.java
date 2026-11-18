// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;




import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXSConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFXS;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PivotSubsystem extends SubsystemBase {
  /** Creates a new PivotSubsystem. */
  public TalonFXS pivotMotor;

  // public PIDController pidController = new PIDController(Constants.PIVOT_P, Constants.PIVOT_I,
  // Constants.PIVOT_D);

  public MotionMagicVoltage requestVoltage = new MotionMagicVoltage(0.0);
  public StatusSignal<Angle> angle;
  public TalonFXSConfiguration pivotConfig;

  public CANcoderConfiguration encoderConfig;

  public PivotSubsystem() {
    encoderConfig.MagnetSensor.MagnetOffset = 0;
    encoderConfig.MagnetSensor.SensorDirection = SensorDirectionValue.CounterClockwise_Positive;
    pivotConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Math.PI/2;
    pivotConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold = 0;
    pivotConfig.Slot0.kP = Constants.PIVOT_P;
    pivotConfig.Slot0.kP = Constants.PIVOT_I;
    pivotConfig.Slot0.kP = Constants.PIVOT_D;
    pivotMotor = new TalonFXS(Constants.PIVOT_MOTOR_ID);
    angle = pivotMotor.getPosition();

    angle.setUpdateFrequency(100);
  }

  public void pivotCommand(double targetAngle) {
    pivotMotor.setControl(requestVoltage.withPosition(targetAngle));
    SmartDashboard.putNumber("Pivot Angle", angle.getValueAsDouble());
    SmartDashboard.putNumber("Target Angle", targetAngle);
  }
}
