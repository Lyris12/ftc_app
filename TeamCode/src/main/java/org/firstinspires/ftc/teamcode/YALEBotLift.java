/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="YALEBotlift", group="Linear Opmode")  // @Autonomous(...) is the other common choice
//@Disabled
public class YALEBotLift extends LinearOpMode {
    NussLift robot   = new NussLift();
    private ElapsedTime     runtime = new ElapsedTime();


    //boolean shoot = false;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        robot.init(hardwareMap);
        waitForStart();
        runtime.reset();
        double reversenuss;


        while (opModeIsActive()) {


            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            reversenuss = -gamepad1.left_trigger;

            robot.leftLift.setPower(gamepad1.right_trigger);
            robot.leftLift.setPower(reversenuss);


        //    robot.leftShoot.setPower(gamepad2.right_trigger );
          //  robot.rightShoot.setPower(gamepad2.right_trigger);

//            robot.beltMotor.setPower(gamepad2.left_trigger);

            telemetry.addData("leftLift: ", gamepad1.right_trigger);
            telemetry.addData("leftLift: ", gamepad1.left_trigger);


            /*if (gamepad2.right_bumper)
                robot.harvestMotor.setPower(0.5);

                else
                robot.harvestMotor.setPower(0);
            */


//


         /*   if (gamepad2.left_bumper)
                    robot.harvestMotor.setPower(-0.5);

                 else
                    robot.harvestMotor.setPower(0);
*/
    //

                    }
        }
    }
