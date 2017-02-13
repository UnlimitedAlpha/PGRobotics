package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

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

    //Launcher
    private DcMotor launcherMotor = null;
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

        //launcher
        launcherMotor = hardwareMap.dcMotor.get("launcher");

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

        //tank drive backward
        leftMotor.setPower(gamepad1.left_trigger);
        rightMotor.setPower(-gamepad1.right_trigger);

        //tank drive forward
        if(gamepad1.left_bumper)
            leftMotor.setPower(-1);
        if(gamepad1.right_bumper)
            rightMotor.setPower(1);

        //Sweeper control
        if(gamepad1.a)
            sweeperMotor.setPower(1);
        else
            sweeperMotor.setPower(0);

        //Conveyor
        if(gamepad1.b)
            conveyorMotor.setPower(1);
        else
            conveyorMotor.setPower(0);

        //Launcher
        float launchSpeed = gamepad1.left_stick_y;
        launchSpeed = Range.clip(launchSpeed, -1, 1);
        launcherMotor.setPower((launchSpeed));


    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
