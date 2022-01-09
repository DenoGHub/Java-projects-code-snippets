package com.company;


public class Tank {

    private int x;
    private int y;
    private String direction;
    private int fireNorth;
    private int fireSouth;
    private int fireEast;
    private int fireWest;

    public Tank() {
        direction = "NORTH";
    }

    public void north() {
        y++;
        direction = "NORTH";
        System.out.println("Tank moved towards NORTH: (" + x + ":" + y + ")");
    }
    public void south() {
        y--;
        direction = "SOUTH";
        System.out.println("Tank moved towards SOUTH: (" + x + ":" + y + ")");
    }
    public void east() {
        x++;
        direction = "EAST";
        System.out.println("Tank moved towards EAST: (" + x + ":" + y + ")");
    }
    public void west() {
        x--;
        direction = "WEST";
        System.out.println("Tank moved towards WEST: (" + x + ":" + y + ")");
    }
    public void fire() {
        switch (direction) {
            case "NORTH":
                fireNorth++;
                System.out.println("Fire towards NORTH");
                break;
            case "SOUTH":
                fireSouth++;
                System.out.println("Fire towards SOUTH");
                break;
            case "EAST":
                fireEast++;
                System.out.println("Fire towards EAST");
                break;
            case "WEST":
                fireWest++;
                System.out.println("Fire towards WEST");
                break;
        }
    }
    public void info() {
        System.out.println("INFO: tank coordinates: (" + x + ":" + y + ") direction: " + direction);
        System.out.println("INFO: tank shots: towards North: " + fireNorth + ", towards East: " + fireEast + ", towards South: "
                + fireSouth + ", towards West: " + fireWest + ". Total shots fired: " + (fireSouth + fireWest + fireEast + fireNorth));
    }
}


