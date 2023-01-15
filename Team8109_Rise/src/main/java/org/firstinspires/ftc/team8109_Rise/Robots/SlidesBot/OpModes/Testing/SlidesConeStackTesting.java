package org.firstinspires.ftc.team8109_Rise.Robots.SlidesBot.OpModes.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.team8109_Rise.Robots.SlidesBot.Mechanisms.Chassis;
import org.firstinspires.ftc.team8109_Rise.Robots.SlidesBot.Mechanisms.ServoIntakeArm;
import org.firstinspires.ftc.team8109_Rise.Robots.SlidesBot.Mechanisms.ViperSlides;

@TeleOp
public class SlidesConeStackTesting extends LinearOpMode {
    ViperSlides slides;
    @Override
    public void runOpMode() throws InterruptedException {

        slides = new ViperSlides(gamepad1, telemetry, hardwareMap);
        ServoIntakeArm arm = new ServoIntakeArm(gamepad1, telemetry, hardwareMap);

        telemetry.addLine("Waiting For Start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){
            slides.autonLevelsTesting();
            arm.setArmPosition();

            Telemetry();
            telemetry.update();
        }
    }

    public void Telemetry(){
        telemetry.addData("Level", slides.slidesState);
        telemetry.addData("Height", slides.getHeight());
        telemetry.addData("SlidePID Error", slides.slidesPID.error);
        telemetry.addData("SlidePID Proportion", slides.slidesPID.P);
        telemetry.addData("SlidePID Integral", slides.slidesPID.I);
        telemetry.addData("SlidePID Derivative", slides.slidesPID.D);
    }
}
