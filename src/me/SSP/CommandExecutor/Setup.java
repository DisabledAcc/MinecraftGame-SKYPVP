package me.SSP.CommandExecutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import me.SSP.Main;
import me.SSP.Utils.Data;
import me.SSP.Utils.Lists;
import me.SSP.Utils.TitlesAPI;

public class Setup implements CommandExecutor{
	
	public static File dataYML = new File("plugins/SSP/DATA", "Locations.yml");
	public static FileConfiguration dataCFG = YamlConfiguration.loadConfiguration(dataYML);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("ssp")){
			Player p = (Player)sender;
			if(p.hasPermission("ssp.admin")){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("remove")){
						if(Lists.removeMode.contains(p)){
							Lists.removeMode.remove(p);
							p.sendMessage(Main.C("&e▸ &fYou &cget out &fof removeLoot mode"));
							
						} else {
							Lists.removeMode.add(p);
							p.sendMessage(Main.C("&e▸ &fYou've &aentered &fremoveLoot mode"));
						}
					}
					
					if(args[0].equalsIgnoreCase("reload")){
							try {
								dataCFG.load(dataYML);
								Data.cfg.load(Data.file);
								Data.cfg.save(Data.file);
								dataCFG.save(dataYML);
								p.sendMessage(Main.C("&e▸ &aSuccessfully &freloading."));
							} catch (FileNotFoundException e) {
								p.sendMessage(Main.C("&e&l(!) &fError while loading &eDataYML"));
								e.printStackTrace();
							} catch (IOException e) {
								p.sendMessage(Main.C("&e&l(!) &fError while loading &eDataYML"));
								e.printStackTrace();
							} catch (InvalidConfigurationException e) {
								p.sendMessage(Main.C("&e&l(!) &fError while loading &eDataYML"));
								e.printStackTrace();
							}
					}
					
					if(args[0].equalsIgnoreCase("set")){
						p.sendMessage(Main.C("&8&m&l------------------------"));
						p.sendMessage(Main.C("&8&l» &f/ssp &cremove"));
						p.sendMessage(Main.C("&8&l» &f/ssp reload"));
						p.sendMessage(Main.C("&8&l» &f/ssp &fset &7Common"));
						p.sendMessage(Main.C("&8&l» &f/ssp &fset &eRare"));
						p.sendMessage(Main.C("&8&l» &f/ssp &fset &cEpic"));
						p.sendMessage(Main.C("&8&l» &f/ssp &fset &5EnderChest"));
						p.sendMessage(Main.C("&8&l» &f/ssp &fset &bTrash"));
						p.sendMessage(Main.C("&8&l» &f/ssp &fset &bShop"));
						p.sendMessage(Main.C("&8&l» &f/ssp &fset &bXPDrop"));
						p.sendMessage(Main.C("&8&l» &f/ssp &fset &bItemsDrop"));
						p.sendMessage(Main.C("&8&m&l------------------------"));
					}
							
				} else if(args.length == 2){
					if(args[0].equalsIgnoreCase("set")){
							if(args[1].equalsIgnoreCase("common")){
								ArmorStand common = (ArmorStand)p.getLocation().getWorld().spawn(p.getLocation(), ArmorStand.class);
								common.setBasePlate(false);
		                        common.setArms(false);
		                        common.setVisible(false);
		                        common.setGravity(false);
		                        common.setCanPickupItems(false);
		                        common.setSmall(true);
		                        common.setHelmet(Main.getHead("common"));
		                        common.setCustomName("1");
		                        common.setCustomNameVisible(false);
		                        p.sendMessage(Main.C("&e▸ &fYou've spawned &7Common &fcrate"));
		                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
		                        new BukkitRunnable() {
									
									@Override
									public void run() {

				                        common.setHeadPose(new EulerAngle(common.getHeadPose().getX(), common.getHeadPose().getY() + 0.1 , common.getHeadPose().getZ()));
										
									}
								}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
							}
							
							if(args[1].equalsIgnoreCase("rare")){
								ArmorStand rare = (ArmorStand)p.getLocation().getWorld().spawn(p.getLocation(), ArmorStand.class);
								rare.setBasePlate(false);
		                        rare.setArms(false);
		                        rare.setVisible(false);
		                        rare.setGravity(false);
		                        rare.setCanPickupItems(false);
		                        rare.setSmall(true);
		                        rare.setHelmet(Main.getHead("rare"));
		                        rare.setCustomName("2");
		                        rare.setCustomNameVisible(false);
		                        p.sendMessage(Main.C("&e▸ &fYou've spawned &eRare &fcrate"));
		                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
                                new BukkitRunnable() {
									
									@Override
									public void run() {

				                        rare.setHeadPose(new EulerAngle(rare.getHeadPose().getX(), rare.getHeadPose().getY() + 0.1 , rare.getHeadPose().getZ()));
										
									}
								}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
							}
							
							if(args[1].equalsIgnoreCase("epic")){
								ArmorStand epic = (ArmorStand)p.getLocation().getWorld().spawn(p.getLocation(), ArmorStand.class);
								epic.setBasePlate(false);
		                        epic.setArms(false);
		                        epic.setVisible(false);
		                        epic.setGravity(false);
		                        epic.setCanPickupItems(false);
		                        epic.setSmall(true);
		                        epic.setHelmet(Main.getHead("epic"));
		                        epic.setCustomName("3");
		                        epic.setCustomNameVisible(false);
		                        p.sendMessage(Main.C("&e▸ &fYou've spawned &cEpic &fcrate"));
		                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
                                new BukkitRunnable() {
									
									@Override
									public void run() {

				                        epic.setHeadPose(new EulerAngle(epic.getHeadPose().getX(), epic.getHeadPose().getY() + 0.1 , epic.getHeadPose().getZ()));
										
									}
								}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
							}
							
							if(args[1].equalsIgnoreCase("trash")){
								ArmorStand trash = (ArmorStand)p.getLocation().getWorld().spawn(p.getLocation(), ArmorStand.class);
								trash.setBasePlate(false);
		                        trash.setArms(false);
		                        trash.setVisible(false);
		                        trash.setGravity(false);
		                        trash.setCanPickupItems(false);
		                        trash.setSmall(true);
		                        trash.setHelmet(Main.getHead("trash"));
		                        trash.setCustomName("4");
		                        trash.setCustomNameVisible(false);
		                        p.sendMessage(Main.C("&e▸ &fYou've spawned &bRecycling Bin"));
		                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
							}
							
							if(args[1].equalsIgnoreCase("enderchest")){
								ArmorStand enderchest = (ArmorStand)p.getLocation().getWorld().spawn(p.getLocation(), ArmorStand.class);
								enderchest.setBasePlate(false);
		                        enderchest.setArms(false);
		                        enderchest.setVisible(false);
		                        enderchest.setGravity(false);
		                        enderchest.setCanPickupItems(false);
		                        enderchest.setSmall(true);
		                        enderchest.setHelmet(Main.getHead("enderchest"));
		                        enderchest.setCustomName("5");
		                        enderchest.setCustomNameVisible(false);
		                        p.sendMessage(Main.C("&e▸ &fYou've spawned &5EnderChest"));
		                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
							}
							
							if(args[1].equalsIgnoreCase("shop")){
								EnderCrystal shop = (EnderCrystal) Bukkit.getWorld(p.getWorld().getName()).spawnEntity(p.getLocation(), EntityType.ENDER_CRYSTAL);
								shop.setCustomName(Main.C("&7▸ &e&lSky&6&lPvp"));
								shop.setCustomNameVisible(true);
								p.sendMessage(Main.C("&e▸ &fYou've spawned the &eShop&f."));
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
							}
							
							if(args[1].equalsIgnoreCase("xpdrop")){
								dataCFG.set("XPDROP.x", p.getLocation().getX());
								dataCFG.set("XPDROP.y", p.getLocation().getY());
								dataCFG.set("XPDROP.z", p.getLocation().getZ());
								dataCFG.set("XPDROP.world", p.getLocation().getWorld().getName());
								p.sendMessage(Main.C("&e▸ &fYou've set &aXPDrop &flocation!"));
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
								p.sendMessage(Main.C("&e&l(!) &rSaved to &f(&eplugins/SSP/Locations/DATA.yml&f)"));
								try {
									dataCFG.save(dataYML);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
					}
				} else {
					p.sendMessage(Main.C("&8&m&l------------------------"));
					p.sendMessage(Main.C("&8&l» &f/ssp &cremove"));
					p.sendMessage(Main.C("&8&l» &f/ssp reload"));
					p.sendMessage(Main.C("&8&l» &f/ssp &fset &7Common"));
					p.sendMessage(Main.C("&8&l» &f/ssp &fset &eRare"));
					p.sendMessage(Main.C("&8&l» &f/ssp &fset &cEpic"));
					p.sendMessage(Main.C("&8&l» &f/ssp &fset &5EnderChest"));
					p.sendMessage(Main.C("&8&l» &f/ssp &fset &bTrash"));
					p.sendMessage(Main.C("&8&l» &f/ssp &fset &bShop"));
					p.sendMessage(Main.C("&8&l» &f/ssp &fset &bXPDrop"));
					p.sendMessage(Main.C("&8&l» &f/ssp &fset &bItemsDrop"));
					p.sendMessage(Main.C("&8&m&l------------------------"));
				}
				
			} else {TitlesAPI.sendActionBar(p, Main.C("&4&l» &cPermission (SSP.Admin) Required &4&l«")); p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 10);}

		}
		
		return false;
	}

}
