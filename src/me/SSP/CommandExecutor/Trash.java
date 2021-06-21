package me.SSP.CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.SSP.Main;

public class Trash implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("trash")){
			Player p = (Player)sender;
			Inventory i = Bukkit.createInventory(null, 9, Main.C("&f&lTrash"));
			p.openInventory(i);
		}
		
		return false;
	}

}
