package org.usfirst.frc.team1155.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1155.robot.PortMap;
import org.usfirst.frc.team1155.robot.Robot;
import com.ctre.CANTalon;

public class GlobalPositioningSubsystem extends Subsystem{

	public enum Location {
		Gear, Airship, StartingPos;
	}
	
	public static Location place;
	public CANTalon frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;
	//X and Y coordinates of the various positions
	public double gearX = 10.00;
	public double gearY = 10.00;
	public double airshipX = 5.00;
	public double airshipY = 5.00;
	public double startingPosX = 0.00;
	public double startingPosY = 0.00;
	
	public GlobalPositioningSubsystem() {
		frontLeftMotor = new CANTalon(PortMap.FRONT_LEFT_TALON);
		frontRightMotor = new CANTalon(PortMap.FRONT_RIGHT_TALON);
		backLeftMotor = new CANTalon(PortMap.BACK_LEFT_TALON);
		backRightMotor = new CANTalon(PortMap.BACK_RIGHT_TALON);		
		place = Location.StartingPos;
	}
	
	public void setLocation(Location location) {
		place = location;
	}
	
	public Location getLocation() {
		return place;
	}
	
	public void goSomewhere(Location location) {
		if (location == Location.Gear) {
			while (Robot.Ren�.getX() != gearX && Robot.Ren�.getY() != gearY) {
				double distanceBetweenLocations = Robot.Ren�.distanceBetweenPoints(Robot.Ren�.getX(), Robot.Ren�.getY(), gearX, gearY);
				double angleWeNeedToBeAt = Robot.Ren�.angleRequiredToTurn(gearX-Robot.Ren�.getX(), gearY-Robot.Ren�.getY(), distanceBetweenLocations);
				if (angleWeNeedToBeAt != Robot.Ren�.chicken.getAngle()) {
					if (angleWeNeedToBeAt >= 180) {
						while (angleWeNeedToBeAt != Robot.Ren�.getUsefulAngle()) {
							frontRightMotor.set(1);
							backRightMotor.set(1);
						}
					} else {
						while (angleWeNeedToBeAt != Robot.Ren�.getUsefulAngle()) {
							frontLeftMotor.set(1);
							backLeftMotor.set(1);
					} 
				}
			}
		} 
	}
		else if (location == Location.Airship) {
			while (Robot.Ren�.getX() != 5.00 && Robot.Ren�.getY() != 5.00) {
			
			}
		} else if (location == Location.StartingPos) {
			while (Robot.Ren�.getX() != 0.00 && Robot.Ren�.getY() != 0.00) {				
			
			}
		} else {
			while (Robot.Ren�.getX() != 0.00 && Robot.Ren�.getY() != 0.00) {
			
			}
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
