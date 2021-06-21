package me.SSP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import me.SSP.Main;
import me.SSP.Utils.Lists;
import me.SSP.Utils.TitlesAPI;

public class Pvp implements Listener{
	
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		Entity p = e.getEntity();
		
			if(e.getCause().equals(DamageCause.FIRE_TICK)){
				if(!Lists.Combat.contains(p)){
					Lists.Combat.add((Player) p);
					TitlesAPI.sendActionBar((Player) p, Main.C("&e▸ &fIn combat for 10 seconds."));
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.Instance, new Runnable() {
						
						@Override
						public void run() {
							Lists.Combat.remove(p);
							TitlesAPI.sendActionBar((Player) p, Main.C("&e▸ &fYou're no longer in combat&e!&f."));
						}
					}, 20*10);
				} else {
					Bukkit.getServer().getScheduler().cancelTasks(Main.Instance);
					Lists.Combat.remove(p);
					Lists.Combat.add((Player) p);
					TitlesAPI.sendActionBar((Player) p, Main.C("&e▸ &fIn combat for 10 seconds."));
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.Instance, new Runnable() {
						
						@Override
						public void run() {
							Lists.Combat.remove(p);
							TitlesAPI.sendActionBar((Player) p, Main.C("&e▸ &fYou're no longer in combat&e!&f."));
						}
					}, 20*10);
				}
			}
			
			if(p instanceof EnderCrystal){
				if(p.getCustomName().equalsIgnoreCase(Main.C("&7▸ &e&lSky&6&lPvp"))){
					e.setCancelled(true);
				}
			}
		
	}
	
	@EventHandler
    public void damage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
        }
    }
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		Player p = (Player)e.getEntity();
		Player k = (Player)e.getDamager();
		
			if(p instanceof Player && k instanceof Player){
				if(!Lists.Combat.contains(p) && !Lists.Combat.contains(k)){
					Lists.Combat.add(p);
					Lists.Combat.add(k);
					TitlesAPI.sendActionBar(p, Main.C("&e▸ &fIn combat for 10 seconds."));
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.Instance, new Runnable() {
						
						@Override
						public void run() {
							Lists.Combat.remove(p);
							TitlesAPI.sendActionBar(p, Main.C("&e▸ &fYou're no longer in combat&e!&f."));
							Lists.Combat.remove(k);
							TitlesAPI.sendActionBar(k, Main.C("&e▸ &fYou're no longer in combat&e!&f."));
						}
					}, 20*10);
				} else {
					Bukkit.getServer().getScheduler().cancelTasks(Main.Instance);
					Lists.Combat.remove(p);
					Lists.Combat.remove(k);
					Lists.Combat.add(p);
					Lists.Combat.add(k);
					TitlesAPI.sendActionBar(p, Main.C("&e▸ &fIn combat for 10 seconds."));
					TitlesAPI.sendActionBar(k, Main.C("&e▸ &fIn combat for 10 seconds."));
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.Instance, new Runnable() {
						
						@Override
						public void run() {
							Lists.Combat.remove(p);
							TitlesAPI.sendActionBar(p, Main.C("&e▸ &fYou're no longer in combat&e!&f."));
							Lists.Combat.remove(k);
							TitlesAPI.sendActionBar(k, Main.C("&e▸ &fYou're no longer in combat&e!&f."));
						}
					}, 20*10);
				}
			} else {return;}
		
	}

}
