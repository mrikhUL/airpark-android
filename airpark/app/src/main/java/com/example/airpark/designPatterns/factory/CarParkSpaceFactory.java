package com.example.airpark.designPatterns.factory;
import com.example.airpark.models.CarParkSpace;
import com.example.airpark.models.DisabledSpace;
import com.example.airpark.models.GeneralSpace;
import com.example.airpark.models.MotorbikeSpace;

/**
 * Airpark Application - Group 14
 *
 * CS4125 -> System Analysis & Design
 * CS5721 -> Software Design
 *
 * Car Park  Space Factory -> Returns the car park space type depending on the vehicle
 */
public class CarParkSpaceFactory {

    public enum SpaceType{
        GENERAL,
        DISABLED,
        TWO_WHEELER
    }

    public CarParkSpace getSpace(SpaceType spaceType){

        VehicleFactory vehicle = new VehicleFactory();

        if(spaceType == null){
            return null;
        }

        if(spaceType == SpaceType.GENERAL){
            return new GeneralSpace(vehicle.getVehicle(spaceType));

        } else if(spaceType == SpaceType.DISABLED){
            return new DisabledSpace(vehicle.getVehicle(spaceType));

        } else if(spaceType == SpaceType.TWO_WHEELER){
            return new MotorbikeSpace(vehicle.getVehicle(spaceType));
        }

        return null;
    }
}
