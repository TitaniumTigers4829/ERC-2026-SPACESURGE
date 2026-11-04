// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package intakeSubsystem;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class intakeSubsystem extends InstantCommand {
  //Make motors, create status signal objects for stator current
  private final PWMTalonFX intakeMotorOne;
  private final StatusSignal<Current> intakeStatorCurrent;

  private final PWMTalonFXConfiguration intakeConfig = new PWMTalonFXConfiguration();
  public intakeSubsystem() {
    // Add configs for motors, configure stator current status signals
    intakeMotorOne = new TalonFX(Constants.INTAKE_MOTOR_ID_ONE); // Replace num with motor id
    intakeStatorCurrent = intakeMotorOne.getVoltage();    // Use addRequirements() here to declare subsystem dependencies.
    BaseStatusSignal.setUpdateFrequencyForAll(
        Constants.RIO_SIGNAL_FREQUENCY,
        intakeStatorCurrent);
    intakeMotorOne.optimizeBusUtilization();
    // set a value of hertz to get the stator current(higher = faster)

  }

  // Called when the command is initially scheduled.
  // update input, all update methods (intake in and intake out(shoot))
  @Override
  public void updateInputs() {
    intakeStatorCurrent.refresh();

  }
  @Override
  public void setIntakeSpeed(double speed) {
    intakeMotorOne.set(speed);
    if (intakeStatorCurrent.refresh() > Constants.INTAKE_STATOR_LIMIT) {
      intakeMotorOne.set(0);
    }
  }
  
   public void periodic() {
    updateInputs();
   }
   public void Outtake(double speed) {
    intakeMotorOne.set(speed);
   }
}