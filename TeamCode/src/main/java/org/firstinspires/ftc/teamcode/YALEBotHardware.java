package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

public class YALEBotHardware
{
    /* Public OpMode members. */
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
   public DcMotor leftShoot = null;
    public DcMotor rightShoot = null;
    public DcMotor beltMotor = null;
    public DcMotor harvestMotor = null;
  //  public DcMotor leftLift = null;
   // public DcMotor rightLift = null;
    //public TouchSensor leftTouch;
    //public TouchSensor rightTouch;
    //public OpticalDistanceSensor distanceSensor;


    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public YALEBotHardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Stuff
        leftDrive  = hwMap.dcMotor.get("leftDrive");
        rightDrive = hwMap.dcMotor.get("rightDrive");
        leftShoot = hwMap.dcMotor.get("leftShoot");
        rightShoot = hwMap.dcMotor.get("rightShoot");
        beltMotor = hwMap.dcMotor.get("beltMotor");
      harvestMotor = hwMap.dcMotor.get("harvestMotor");
        //leftLift = hwMap.dcMotor.get("leftLift");
       // rightLift = hwMap.dcMotor.get("rightLift");
        //leftTouch = hwMap.touchSensor.get("leftTouch");
        //rightTouch = hwMap.touchSensor.get("rightTouch");
        //distanceSensor = hardwareMap.opticalDistanceSensor.get("distanceSensor");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftShoot.setDirection(DcMotor.Direction.FORWARD);
        rightShoot.setDirection(DcMotor.Direction.REVERSE);
       beltMotor.setDirection(DcMotor.Direction.REVERSE);
       harvestMotor.setDirection(DcMotor.Direction.REVERSE);
  //      leftLift.setDirection(DcMotor.Direction.REVERSE);
//        rightLift.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftShoot.setPower(0);
        rightShoot.setPower(0);
        beltMotor.setPower(0);
        harvestMotor.setPower(0);
        //leftHarvest.setPower(0);
        //harvestMotor.setPower(0);
      //  leftLift.setPower(0);
    //    rightLift.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftShoot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightShoot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        beltMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       harvestMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       // leftLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //rightLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

