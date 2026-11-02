// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PivotSubsystem extends SubsystemBase {
  /** Creates a new PivotSubsystem. */

  public PWMTalonFX pivotMotor;
  
  public PivotSubsystem() {

    pivotMotor = new PWMTalonFX(Constants.PIVOT_MOTOR_ID_3);
  }
  @Override
  public void pivotCommand(double speed) {
    pivotMotor.set(speed);
  }
}