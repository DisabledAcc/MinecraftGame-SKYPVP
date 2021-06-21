package me.SSP.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explosions implements Listener{
	
	@EventHandler
	public void onExplode(EntityExplodeEvent e){
		Entity b = e.getEntity();
		
		if(b.getType().equals(EntityType.PRIMED_TNT)){
			e.setCancelled(true);
		}
		
	}

}
