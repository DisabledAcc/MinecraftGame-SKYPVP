package me.SSP.Listeners;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitiesSpawn implements Listener{
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e){
		if(!(e.getEntity() instanceof Player) && !(e.getEntity() instanceof Villager) && !(e.getEntity() instanceof ArmorStand) && !(e.getEntity() instanceof Item)){
			e.setCancelled(true);
		}
	}

}
