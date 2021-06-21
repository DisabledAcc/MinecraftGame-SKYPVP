package me.SSP.Utils;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class CuboID {
	
	private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private int zMin;
    private int zMax;
    private double xMinCentered;
    private double xMaxCentered;
    private double yMinCentered;
    private double yMaxCentered;
    private double zMinCentered;
    private double zMaxCentered;
    private World world;
    
    public CuboID(Location FirstLocation, Location SecondLocation) {
        this.xMin = Math.min(FirstLocation.getBlockX(), SecondLocation.getBlockX());
        this.xMax = Math.max(FirstLocation.getBlockX(), SecondLocation.getBlockX());
        this.yMin = Math.min(FirstLocation.getBlockY(), SecondLocation.getBlockY());
        this.yMax = Math.max(FirstLocation.getBlockY(), SecondLocation.getBlockY());
        this.zMin = Math.min(FirstLocation.getBlockZ(), SecondLocation.getBlockZ());
        this.zMax = Math.max(FirstLocation.getBlockZ(), SecondLocation.getBlockZ());
        this.world = FirstLocation.getWorld();
        this.xMinCentered = this.xMin + 0.5;
        this.xMaxCentered = this.xMax + 0.5;
        this.yMinCentered = this.yMin + 0.5;
        this.yMaxCentered = this.yMax + 0.5;
        this.zMinCentered = this.zMin + 0.5;
        this.zMaxCentered = this.zMax + 0.5;
    }
    
    public Location getCenter() {
        return new Location(this.world, (double)((this.xMax - this.xMin) / 2 + this.xMin), (double)((this.yMax - this.yMin) / 2 + this.yMin), (double)((this.zMax - this.zMin) / 2 + this.zMin));
    }
    
    public double getDistance() {
        return this.getFirstLocation().distance(this.getSecondLocation());
    }
    
    public double getDistanceSquared() {
        return this.getFirstLocation().distanceSquared(this.getSecondLocation());
    }
    
    public int getHeight() {
        return this.yMax - this.yMin + 1;
    }
    
    public Location getFirstLocation() {
        return new Location(this.world, (double)this.xMin, (double)this.yMin, (double)this.zMin);
    }
    
    public Location getSecondLocation() {
        return new Location(this.world, (double)this.xMax, (double)this.yMax, (double)this.zMax);
    }
    
    public Location getRandomLocation() {
        Random rand = new Random();
        int x = rand.nextInt(Math.abs(this.xMax - this.xMin) + 1) + this.xMin;
        int y = rand.nextInt(Math.abs(this.yMax - this.yMin) + 1) + this.yMin;
        int z = rand.nextInt(Math.abs(this.zMax - this.zMin) + 1) + this.zMin;
        return new Location(this.world, (double)x, (double)y, (double)z);
    }
    
    public int getTotalBlockSize() {
        return this.getHeight() * this.getXWidth() * this.getZWidth();
    }
    
    public int getXWidth() {
        return this.xMax - this.xMin + 1;
    }
    
    public int getZWidth() {
        return this.zMax - this.zMin + 1;
    }
    
    public boolean isIn(Location loc) {
        return loc.getWorld() == this.world && loc.getBlockX() >= this.xMin && loc.getBlockX() <= this.xMax && loc.getBlockY() >= this.yMin && loc.getBlockY() <= this.yMax && loc.getBlockZ() >= this.zMin && loc.getBlockZ() <= this.zMax;
    }
    
    public boolean isPlayerInCuboID(Player player) {
        return this.isIn(player.getLocation());
    }
    
    public boolean isInWithMarge(Location loc, double marge) {
        return loc.getWorld() == this.world && loc.getX() >= this.xMinCentered - marge && loc.getX() <= this.xMaxCentered + marge && loc.getY() >= this.yMinCentered - marge && loc.getY() <= this.yMaxCentered + marge && loc.getZ() >= this.zMinCentered - marge && loc.getZ() <= this.zMaxCentered + marge;
    }

}
