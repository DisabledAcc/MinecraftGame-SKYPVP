package me.SSP.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.SSP.Main;
import me.SSP.Utils.Lists;
import me.SSP.Utils.Prestiges;

public class Chat implements Listener{
	
	@EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
      Player p = e.getPlayer();
      
      if(Lists.Combat.contains(p)){
    	  if(e.getMessage().startsWith("/lobby") || e.getMessage().startsWith("/hub") || e.getMessage().startsWith("/spawn") || e.getMessage().startsWith("/leave")){
    		  e.setCancelled(true);
    		  p.sendMessage(Main.C("&e▸ &fCouldn't Preprocess this Command right now"));
    	  }
      }
    	  
    }
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		 String msg = e.getMessage();
		
		if(p.hasPermission("default")){
			e.setFormat(Main.C("&8┃ "+ Prestiges.getPrestige(p) + " &8┃&7 " + p.getDisplayName() + " &8▸ &r" + msg));
		}
		
		if(p.hasPermission("super")){
			e.setFormat(Main.C("&8┃ "+ Prestiges.getPrestige(p) + " &8┃&7 " + "&eSuper" + " &8┃&6 " + p.getDisplayName() + " &8▸ &r" + msg));
		}
		
		if(p.hasPermission("staff")){
			e.setFormat(Main.C("&8┃ "+ Prestiges.getPrestige(p) + " &8┃&7 " + "&bStaff" + " &8┃&b " + p.getDisplayName() + " &8▸ &r" + msg));
		}
		
		if(p.hasPermission("supervisor")){
			e.setFormat(Main.C("&8┃ "+ Prestiges.getPrestige(p) + " &8┃&7 " + "&3S&8-&3V" + " &8┃&b " + p.getDisplayName() + " &8▸ &r" + msg));
		}
		
		if(p.hasPermission("ceo")){
			e.setFormat(Main.C("&8┃ "+ Prestiges.getPrestige(p) + " &8┃&7 " + "&4CEO" + " &8┃&c " + p.getDisplayName() + " &8▸ &r" + msg));
		}
		
		if(p.isOp() || p.hasPermission("*")){
			e.setFormat(Main.C("&8┃ "+ Prestiges.getPrestige(p) + " &8┃&7 " + "&6Creator" + " &8┃&6 " + p.getDisplayName() + " &8▸ &4&l" + msg));
		} else {e.setFormat(Main.C("&8┃ "+ Prestiges.getPrestige(p) + " &8┃&7 " + p.getDisplayName() + " &8▸ &r" + msg));}
		
	}

}
