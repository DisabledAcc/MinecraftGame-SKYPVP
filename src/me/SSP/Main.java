package me.SSP;

import java.io.File;
import java.lang.reflect.Field;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import me.SSP.CommandExecutor.Setup;
import me.SSP.CommandExecutor.Prestige;
import me.SSP.CommandExecutor.Stats;
import me.SSP.CommandExecutor.Trash;
import me.SSP.Listeners.Chat;
import me.SSP.Listeners.Death;
import me.SSP.Listeners.DropPickup;
import me.SSP.Listeners.EntitiesSpawn;
import me.SSP.Listeners.Explosions;
import me.SSP.Listeners.Interact;
import me.SSP.Listeners.InvClick;
import me.SSP.Listeners.JRQ;
import me.SSP.Listeners.Move;
import me.SSP.Listeners.Pvp;
import me.SSP.Listeners.TimeWeather;
import me.SSP.Utils.Heads;

public class Main extends JavaPlugin {
	
	public static String C(String G){
		return ChatColor.translateAlternateColorCodes('&', G);
	}
	
	public static Main Instance;
	public static Main Instance1;
	
	public void onEnable(){	
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&8=============================="));
		Bukkit.getServer().getConsoleSender().sendMessage("");
		Bukkit.getServer().getConsoleSender().sendMessage("");
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&7Name: &fS&eSP"));
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&7Status: &aActive!"));
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&7Version: &b0.2.2"));
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&7Developed By &bSyoof_"));
		Bukkit.getServer().getConsoleSender().sendMessage("");
		Bukkit.getServer().getConsoleSender().sendMessage("");
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&8=============================="));
		RegisterListeners();
		RegisterCommands();
		registerConfig();
		XPDrop();
	}
	
	public void onDisable(){
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&8=============================="));
		Bukkit.getServer().getConsoleSender().sendMessage("");
		Bukkit.getServer().getConsoleSender().sendMessage("");
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&7Name: &fS&eSP"));
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&7Status: &cDeActive!"));
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&7Version: &b0.2.2"));
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&7Developed By &bSyoof_"));
		Bukkit.getServer().getConsoleSender().sendMessage("");
		Bukkit.getServer().getConsoleSender().sendMessage("");
		Bukkit.getServer().getConsoleSender().sendMessage(Main.C("&8=============================="));
		RegisterListeners();
		RegisterCommands();
		registerConfig();
		XPDrop();
	}
	
	
	public void RegisterListeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new Pvp(), this);
		pm.registerEvents(new JRQ(), this);
		pm.registerEvents(new Death(), this);
		pm.registerEvents(new Interact(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new Move(), this);
		pm.registerEvents(new DropPickup(), this);
		pm.registerEvents(new Explosions(), this);
		pm.registerEvents(new TimeWeather(), this);
		pm.registerEvents(new InvClick(), this);
		pm.registerEvents(new EntitiesSpawn(), this);
		Instance = this;
		Instance1 = this;
		
	}
	
	public void RegisterCommands(){
		getCommand("stats").setExecutor(new Stats());
		getCommand("prestiges").setExecutor(new Prestige());
		getCommand("trash").setExecutor(new Trash());
		getCommand("ssp").setExecutor(new Setup());
	}
	
	public void registerConfig(){
        File config = new File(this.getDataFolder(), "config.yml");
        //String rutaConfig = config.getPath();
        
        if (!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            this.saveConfig();
        }
    }
	
	public void XPDrop(){
		if(Setup.dataYML.exists()){
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, (Runnable)new BukkitRunnable() {
				
				@Override
				public void run() {
					Location l = new Location(Bukkit.getWorld(Setup.dataCFG.getString("XPDROP.world")), Setup.dataCFG.getDouble("XPDROP.x"), Setup.dataCFG.getDouble("XPDROP.y"), Setup.dataCFG.getDouble("XPDROP.z"));
					if(l.getY() > 0.0){
						l.getWorld().spawnEntity(l, EntityType.THROWN_EXP_BOTTLE);
					}
				}
			}, 0, 5);
		} else {Bukkit.getLogger().warning("XPDrop location hasn't set yet");;}
	}
	
	public static ItemStack getHead(String name) {
        Heads[] arrayOfHeads = Heads.values();
        int i = arrayOfHeads.length;
        for (int b = 0; b < i; b = (int)((byte)(b + 1))) {
            Heads head = arrayOfHeads[b];
            if (!head.getName().equalsIgnoreCase(name)) continue;
            return head.getItemStack();
        }
        return null;
    }

    public static ItemStack createSkull(String url, String name) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        if (url.isEmpty()) {
            return head;
        }
        SkullMeta headMeta = (SkullMeta)head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));
        try {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        }
        catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException error) {
            error.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

}
