package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsTouchSensor;

@Autonomous(name = "TouchOpMode_Ankit", group = "pushbot")
//@disabled
public class TouchSensorOpMode_Ankit extends LinearOpMode {


    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor arm;
    Servo leftClaw;
    Servo rightClaw;
    ModernRoboticsTouchSensor tSense1;

    @Override
    public void runOpMode ()  throws InterruptedException{
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        arm = hardwareMap.get(DcMotor.class, "arm");
        rightClaw = hardwareMap.get(Servo.class, "right_claw");
        leftClaw = hardwareMap.get(Servo.class, "left_claw");
        tSense1 = hardwareMap.get(ModernRoboticsTouchSensor.class, "Touch_1");

        int motorPower = 1;
        long motorTimeValue = 1000;

        waitForStart();

        leftDrive.setPower(motorPower);
        rightDrive.setPower(motorPower);
        TouchSensorWait();
        leftDrive.setPower(0);
        rightDrive.setPower(0);

}
    public void MoveForward(double motorPower, long motorTimeValue) throws InterruptedException{
        leftDrive.setPower(motorPower);
        rightDrive.setPower(-motorPower);
        Thread.sleep(motorTimeValue);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void TurnRight(double motorPower, long motorTimeValue) throws InterruptedException{
        leftDrive.setPower(motorPower);
        rightDrive.setPower(motorPower);
        Thread.sleep(motorTimeValue);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void TurnLeft(double motorPower, long motorTimeValue) throws InterruptedException{
        leftDrive.setPower(-motorPower);
        rightDrive.setPower(-motorPower);
        Thread.sleep(motorTimeValue);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void MoveBackward(double motorPower, long motorTimeValue) throws InterruptedException{
        leftDrive.setPower(-motorPower);
        rightDrive.setPower(-motorPower);
        Thread.sleep(motorTimeValue);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void ArmUp(double motorPower, long motorTimeValue) throws InterruptedException{
        arm.setPower(motorPower);
        Thread.sleep(motorTimeValue);
        arm.setPower(0);
    }
    //.

    public void ArmDown(double motorPower, long motorTimeValue) throws InterruptedException{
        arm.setPower(-motorPower);
        Thread.sleep(motorTimeValue);
        arm.setPower(0);
    }
    public void ServoOpen(){
        leftClaw.setPosition(1);
        rightClaw.setPosition(0);

    }
    public void ServoClose(){
        leftClaw.setPosition(0.7);
        rightClaw.setPosition(0.3);
        }
    public void TouchSensorWait () {
        while (tSense1.isPressed()){
            telemetry.addData("Status", "Waiting");
        }
    }
}

