package me.SSP.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.SSP.Main;

public class DropPickup implements Listener{
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		
		if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(Main.C("&7Default")) || e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(Main.C("&eSuper"))){
			e.setCancelled(true);
			p.sendMessage(Main.C("&e▸ &fUse /trash or of find the nearest Recycle bin"));
		}
		
	}

}
