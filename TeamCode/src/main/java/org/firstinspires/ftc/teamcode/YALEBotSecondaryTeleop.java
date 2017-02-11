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

@TeleOp(name="YALEBotTeleopNew", group="Linear Opmode")  // @Autonomous(...) is the other common choice
//@Disabled
public class YALEBotSecondaryTeleop extends LinearOpMode {
    YALEBotHardware robot = new YALEBotHardware();
    private ElapsedTime runtime = new ElapsedTime();


    double servoPos = 0;
    String servoPosString;

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

        while (opModeIsActive()) {

            servoPos = robot.release.getPosition();
            servoPosString = Double.toString(servoPos);
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Servo Position:", servoPosString);
            telemetry.update();

            robot.leftDrive.setPower(gamepad1.left_stick_y);
            robot.rightDrive.setPower(gamepad1.right_stick_y);

            if (gamepad1.right_trigger > 0) {
                robot.liftMotor.setPower(1.0);
            } else if (gamepad1.left_trigger > 0) {
                robot.liftMotor.setPower(-1.0);
            } else {
                robot.liftMotor.setPower(0);
            }

            if (gamepad2.right_trigger > 0) {
                robot.leftShoot.setPower(0.6);
                robot.rightShoot.setPower(0.6);
            } else {
                robot.leftShoot.setPower(0);
                robot.rightShoot.setPower(0);
            }

            if (gamepad2.right_bumper) {
                robot.beltMotor.setPower(1.0);
            } else {
                robot.beltMotor.setPower(0);

            }


            if (gamepad2.left_bumper) {
                robot.harvestMotor.setPower(1.0);
            } else {
                robot.harvestMotor.setPower(0);
            }

            }

            if (gamepad1.left_bumper) {
                robot.release.setPosition(0.5);
            } else {
                robot.release.setPosition(0);
            }

        }
    }

