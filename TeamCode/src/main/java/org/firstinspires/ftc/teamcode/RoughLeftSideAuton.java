package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@Autonomous(name="RoughLeftSideAuton")
public class RoughLeftSideAuton extends LinearOpMode {

    private Spark robot;

    private ElapsedTime runtime = new ElapsedTime();

    private AprilTagProcessor aprilTagProcessor;
    private VisionPortal visionPortal;

    private List<AprilTagDetection> currentDetections;


    @Override
    public void runOpMode() {
        robot = new Spark(this, Spark.Drivetrain.MECHANUM);
        runtime.reset();

        robot.initAprilTag( visionPortal, aprilTagProcessor );

        waitForStart();
  
        double speed = 0.5;
        int rest = 100;

        
        //Code for auton
        robot.moveForwardInches(12 , speed);   
        //robot.sleep(rest);
        
         //code for scanning spike mark goes here
        //robot.sleep(rest);
                //code for placing purple pixel goes here
        //robot.sleep(rest);
        robot.moveBackwardInches(9, speed);    
        //robot.sleep(rest);
        
        robot.turnLeftDegrees(90, speed * 3/2);         
        //robot.sleep(rest);
            
        robot.moveForwardInches(24 , speed); 
        //robot.sleep(rest);
        
        robot.moveRightInches(24 , speed);  
        //robot.sleep(rest);
        //robot scans for the correct april tag, moves forward to the correct position, and places the yellow pixel
        //more code needed where indicated

        //code for scanning april tags goes here
        //robot.sleep(rest);
        robot.moveForwardInches(6, speed);
        //robot.sleep(rest);
        //code for positioning to place yellow pixel goes here
     
        //robot.sleep(rest);

        robot.moveLeftInches(24 , speed * 3/2);
        //robot.sleep(rest);
        
        robot.moveForwardInches(18, speed);
        //robot.sleep(rest);

        

        if (opModeIsActive()) {
            while (opModeIsActive()) {

                robot.telemetryAprilTag( currentDetections, aprilTagProcessor );

                // Push telemetry to the Driver Station.
                telemetry.update();

                // Share the CPU.
                sleep(20);
            }
        }

        // Save more CPU resources when camera is no longer needed.
        visionPortal.close();

    }

}