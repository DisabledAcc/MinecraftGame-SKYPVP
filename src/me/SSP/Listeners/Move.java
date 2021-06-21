package me.SSP.Listeners;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.SSP.Main;
import me.SSP.Utils.Data;
import me.SSP.Utils.ScoreBoard;

public class Move implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		
		double random = Math.random() * 20.0;
        String rndom = String.format("%.0f", random);
		
		if(p.getLocation().getY() < -33){
			p.setHealth(0.0);
			Data.addDeaths(p, 1);
			p.sendMessage(Main.C("&e▸ &fYou've died&e!&f."));
			if(Data.getCoins(p) >= 21){
				Data.removeCoins(p, Integer.parseInt(rndom));
				p.sendMessage(Main.C("&c-" + rndom + "&e$"));
			}
			p.spigot().respawn();
			ScoreBoard.updateSB(p);
		}
		
		if(p.getLocation().getBlock().getType() == Material.GOLD_PLATE && p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() == Material.REDSTONE_BLOCK){
			Vector v = p.getLocation().getDirection().multiply(2.0).setY(0.6);
			p.setVelocity(v);
			p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 10, 10);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, null);
		}
		
		if(p.getLocation().add(0.0, -1.0, 0.0).getBlock().getType() == Material.GOLD_BLOCK && p.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType() == Material.REDSTONE_BLOCK){
			if(p.hasPermission("super")){
				p.performCommand("warp super");
			}
		}
		
	}

}
