package me.SSP.Listeners;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.SSP.Main;
import me.SSP.Utils.ItemStackAPI;
import me.SSP.Utils.Lists;
import me.SSP.Utils.ScoreBoard;
import me.SSP.Utils.TitlesAPI;

public class JRQ implements Listener{
	
	public static File SpawnYAML = new File("plugins/Strix/DATA/Locations", "spawn.yml");
    public static FileConfiguration SpawnCfg = (FileConfiguration)YamlConfiguration.loadConfiguration(SpawnYAML);
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		e.setJoinMessage(null);
		ScoreBoard.loadSB(p);
		
		Location loc = p.getLocation();
		loc.setX(SpawnCfg.getDouble("Spawn.x"));
		loc.setY(SpawnCfg.getDouble("Spawn.y"));
		loc.setZ(SpawnCfg.getDouble("Spawn.z"));
		loc.setYaw((float) SpawnCfg.getDouble("Spawn.Yaw"));
		loc.setPitch((float) SpawnCfg.getDouble("Spawn.Pitch"));
		loc.setWorld(Bukkit.getWorld(SpawnCfg.getString("Spawn.World")));
		p.sendMessage(Main.C("&8» &fYou're being sent to the &espawn"));
		p.teleport(loc);
		if(!SpawnYAML.exists()){
			p.sendMessage(Main.C("&4&l» &cSpawn cannot be found!"));
		}
		
		Lists.KillStreaks.put(p.getName(), 0);
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
			
			@Override
			public void run() {
				TitlesAPI.sendActionBar(p, Main.C("&fKillStreaks &8▸ &e" + Lists.KillStreaks.get(p.getName())));
				
			}
		}, 1L, 20L*2L);
		
		
		if(p.hasPermission("default")){
			p.getInventory().setHelmet(ItemStackAPI.DefaultKit_Helmet());
			p.getInventory().setChestplate(ItemStackAPI.DefaultKit_Chestplate());
			p.getInventory().setLeggings(ItemStackAPI.DefaultKit_Leggings());
			p.getInventory().setBoots(ItemStackAPI.DefaultKit_Boots());
			p.getInventory().setItem(0, ItemStackAPI.DefaultKit_Sword());
			p.getInventory().setItem(1, ItemStackAPI.DefaultKit_Bow());
			p.getInventory().setItem(8, ItemStackAPI.DefaultKit_Arrows());
			
		}
		
		if(p.hasPermission("super")){
			p.getInventory().setHelmet(ItemStackAPI.SuperKit_Helmet());
			p.getInventory().setChestplate(ItemStackAPI.SuperKit_Chestplate());
			p.getInventory().setLeggings(ItemStackAPI.SuperKit_Leggings());
			p.getInventory().setBoots(ItemStackAPI.SuperKit_Boots());
			p.getInventory().setItem(0, ItemStackAPI.SuperKit_Sword());
			p.getInventory().setItem(1, ItemStackAPI.SuperKit_Bow());
			p.getInventory().setItem(8, ItemStackAPI.SuperKit_Arrows());
			
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		e.setQuitMessage(null);
		
		if(Lists.Combat.contains(p)){
			p.setHealth(0.0);
			Lists.Combat.remove(p);
			p.sendMessage(Main.C("&e▸ &fYou were killed for &clogout &fwhile in &eCombat&f!."));
		}
		
		Lists.KillStreaks.remove(p.getName());
		
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		
		Lists.KillStreaks.put(p.getName(), 0);
		ScoreBoard.updateSB(p);
		
		Location loc = p.getLocation();
		loc.setX(SpawnCfg.getDouble("Spawn.x"));
		loc.setY(SpawnCfg.getDouble("Spawn.y"));
		loc.setZ(SpawnCfg.getDouble("Spawn.z"));
		loc.setYaw((float) SpawnCfg.getDouble("Spawn.Yaw"));
		loc.setPitch((float) SpawnCfg.getDouble("Spawn.Pitch"));
		loc.setWorld(Bukkit.getWorld(SpawnCfg.getString("Spawn.World")));
		e.setRespawnLocation(loc);
		if(!SpawnYAML.exists()){
			p.sendMessage(Main.C("&4&l» &cSpawn cannot be found!"));
		}
		
		if(p.hasPermission("default")){
			p.getInventory().setHelmet(ItemStackAPI.DefaultKit_Helmet());
			p.getInventory().setChestplate(ItemStackAPI.DefaultKit_Chestplate());
			p.getInventory().setLeggings(ItemStackAPI.DefaultKit_Leggings());
			p.getInventory().setBoots(ItemStackAPI.DefaultKit_Boots());
			p.getInventory().setItem(0, ItemStackAPI.DefaultKit_Sword());
			p.getInventory().setItem(1, ItemStackAPI.DefaultKit_Bow());
			p.getInventory().setItem(8, ItemStackAPI.DefaultKit_Arrows());
			
		}
		
		if(p.hasPermission("super")){
			p.getInventory().setHelmet(ItemStackAPI.SuperKit_Helmet());
			p.getInventory().setChestplate(ItemStackAPI.SuperKit_Chestplate());
			p.getInventory().setLeggings(ItemStackAPI.SuperKit_Leggings());
			p.getInventory().setBoots(ItemStackAPI.SuperKit_Boots());
			p.getInventory().setItem(0, ItemStackAPI.SuperKit_Sword());
			p.getInventory().setItem(1, ItemStackAPI.SuperKit_Bow());
			p.getInventory().setItem(8, ItemStackAPI.SuperKit_Arrows());
			
		}
		
	}

}
