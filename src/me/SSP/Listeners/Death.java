package me.SSP.Listeners;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.SSP.Main;
import me.SSP.Utils.Data;
import me.SSP.Utils.Lists;
import me.SSP.Utils.ScoreBoard;

public class Death implements Listener{
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity().getPlayer();
		Player k = e.getEntity().getPlayer().getKiller();
		
		e.setDeathMessage(null);
		
        new BukkitRunnable() {
			
			@Override
			public void run() {
				p.spigot().respawn();
				
			}
		}.runTaskLater(Main.getPlugin(Main.class), 20);
		
		double random = Math.random() * 20.0;
        String rndom = String.format("%.0f", random);
        
        DecimalFormat df = new DecimalFormat("##.##");
        String kHealth = df.format(k.getHealth() / 2.0D);
        
        
        Firework Firework = k.getWorld().spawn(k.getLocation(), Firework.class);
        FireworkMeta Meta = Firework.getFireworkMeta();
        Meta.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BURST).build() });
        Meta.setPower(2);
        Firework.setFireworkMeta(Meta);
        
        ArmorStand as = (ArmorStand)Bukkit.getWorld(p.getWorld().getName()).spawnEntity(p.getLocation().add( 0, -1,0), EntityType.ARMOR_STAND);
        as.setGravity(false);
        as.setCanPickupItems(false);
        as.setVisible(false);
        as.setCustomNameVisible(true);
        as.setCustomName(Main.C("&f&l" + p.getName() + "&c&l✖"));
        new BukkitRunnable() {
			
			@Override
			public void run() {
				as.remove();
				
			}
		}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 20*4);
		
		if(Lists.KillStreaks.get(k.getName()) == 100){
			Bukkit.broadcastMessage(Main.C("&e▸ &b" + k.getName() + " &fis a &c&lKING &fof SkyPvp"));
		}
        
        	Data.addKills(k, 1);
        	Data.addCoins(k, Integer.parseInt(rndom));
        	Lists.KillStreaks.put(k.getName(), Lists.KillStreaks.get(k.getName()) + 1);
        	k.sendMessage(Main.C("&e▸ &fYou've killed &e" + p.getName() + " &fwith &c" + kHealth + "❤ &fleft."));
            k.sendMessage(Main.C("&a+" + rndom + "&e$"));
            ScoreBoard.updateSB(k);
            
            Data.addDeaths(p, 1);
            p.sendMessage(Main.C("&e▸ &fYour enemy &e" + k.getName() + " &fStill have &c" + kHealth + "❤ &fleft."));
			if(Data.getCoins(p) >= 21){
				Data.removeCoins(p, Integer.parseInt(rndom));
				p.sendMessage(Main.C("&c-" + rndom + "&e$"));
			}
			ScoreBoard.updateSB(p);
			if(Lists.KillStreaks.containsKey(p.getName()) && Lists.KillStreaks.get(p.getName()) >= 3){
				p.sendMessage(Main.C("&e▸ &fYou've &clost &fyour killstreaks of &e" + Lists.KillStreaks.get(p.getName())));
				Lists.KillStreaks.put(p.getName(), 0);
			}
            
		
	}

}
