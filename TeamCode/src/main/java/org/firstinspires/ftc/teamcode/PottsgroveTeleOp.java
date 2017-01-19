package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by jthieme on 11/29/16.
 */

//test edit
@TeleOp(name = "PottsgroveTeleOp")
public class PottsgroveTeleOp extends OpMode{
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    //Drive Motors
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    //Sweeper
    private boolean sweeperOn = false;
    private DcMotor sweeperMotor = null;

    //Conveyor
    private boolean conveyorOn = false;
    private DcMotor conveyorMotor = null;

    //Lift
    private DcMotor liftMotor = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        //drive
        leftMotor  = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");

        //sweeper
        sweeperMotor = hardwareMap.dcMotor.get("sweeper");

        //conveyor
        conveyorMotor = hardwareMap.dcMotor.get("conveyor");

        //lift
        liftMotor = hardwareMap.dcMotor.get("lift");

    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());

        //tank drive forward
        leftMotor.setPower(gamepad1.left_trigger);
        rightMotor.setPower(-gamepad1.right_trigger);

        //tank drive backward
        if(gamepad1.left_bumper)
            leftMotor.setPower(-50);
        if(gamepad1.right_bumper)
            rightMotor.setPower(50);

        //Sweeper control
        if(gamepad1.a)
            sweeperOn = !sweeperOn;

        if(sweeperOn)
            sweeperMotor.setPower(100);
        else
            sweeperMotor.setPower(0);

        //Conveyor
        if(gamepad1.b)
            conveyorOn = !conveyorOn;

        if(conveyorOn)
            conveyorMotor.setPower(100);
        else
            conveyorMotor.setPower(0);

        //Lift
        if(gamepad1.dpad_up)
            liftMotor.setPower(-60);
        else if(gamepad1.dpad_down)
            liftMotor.setPower(60);


    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
