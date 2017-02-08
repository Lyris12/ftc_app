package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class NussLift
{
    /* Public OpMode members. */

   // public DcMotor rightShoot = null;
  //  public DcMotor beltMotor = null;
  //  public DcMotor harvestMotor = null;
             public DcMotor leftLift = null;
    //public DcMotor rightLift = null;
  //  public TouchSensor TouchSensorLeft;
    //public TouchSensor TouchSensorRight;
   // public OpticalDistanceSensor DistanceSensor;


    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public NussLift(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Stuff

        leftLift = hwMap.dcMotor.get("leftLift");
       // rightShoot = hwMap.dcMotor.get("rightShoot");
      //  beltMotor = hwMap.dcMotor.get("beltMotor");
   //     harvestMotor = hwMap.dcMotor.get("harvestMotor");
        //TouchSensorLeft = hardwareMap.touchSensor.get("sensor_touch_left");
        //TouchSensorRight = hardwareMap.touchSensor.get("sensor_touch_right");
        //DistanceSensor = hardwareMap.opticalDistanceSensor.get("sensor_optical");

      //  leftShoot.setDirection(DcMotor.Direction.FORWARD);
    //    rightShoot.setDirection(DcMotor.Direction.REVERSE);
  //      beltMotor.setDirection(DcMotor.Direction.REVERSE);
        //leftHarvest.setDirection(DcMotor.Direction.REVERSE);
//        rightHarvest.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power

        leftLift.setPower(0);
       // beltMotor.setPower(0);
        //leftHarvest.setPower(0);
       // rightHarvest.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    //    leftShoot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      //  rightShoot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //beltMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //harvestMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


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

