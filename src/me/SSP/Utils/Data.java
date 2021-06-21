package me.SSP.Utils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Data {
	
	public static File file = new File("./plugins/SSP/DATA", "Players.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    public static void addKills(Player p, int amount) {
        int i = cfg.getInt(p.getName() + ".Kills");
        int total = i + amount;
        cfg.set(p.getName() + ".Kills", (Object)total);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Integer getKills(Player p) {
        int total = cfg.getInt(p.getName() + ".Kills");
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }
    
    public static void addDeaths(Player p, int amount) {
        int i = cfg.getInt(p.getName() + ".Deaths");
        int total = i + amount;
        cfg.set(p.getName() + ".Deaths", (Object)total);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Integer getDeaths(Player p) {
        int total = cfg.getInt(p.getName() + ".Deaths");
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }
    
    public static void setCoins(Player p, int amount) {
        cfg.set(p.getUniqueId() + ".Coins", (Object)amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Integer getCoins(Player p) {
        int total = cfg.getInt(p.getName() + ".Coins");
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }
    
    public static void addCoins(Player p, int amount) {
        int i = cfg.getInt(p.getName() + ".Coins");
        int total = i + amount;
        cfg.set(p.getName() + ".Coins", (Object)total);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void removeCoins(Player p, int amount) {
        int i = cfg.getInt(p.getName() + ".Coins");
        int total = i - amount;
        cfg.set(p.getName() + ".Coins", (Object)total);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static double getKDR(Player p) {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        if (getDeaths(p) <= 0) {
            return 1.00D;
        }
        return Double.valueOf(decimalFormat.format(getKills(p) / getDeaths(p))).doubleValue();
    }

}
