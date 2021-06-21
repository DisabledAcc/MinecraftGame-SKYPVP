package me.SSP.CommandExecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.SSP.Main;
import me.SSP.Utils.Prestiges;

public class Prestige implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("Prestiges")){
			
			Player p = (Player)sender;
			
			p.sendMessage(Main.C("&8&l&m---------------------"));
			p.sendMessage("");
			p.sendMessage(Main.C("&2NewBie II &8» &b70"));
			p.sendMessage(Main.C("&2NewBie III &8» &b140"));
			p.sendMessage(Main.C("&5Crystal I&8» &b500"));
			p.sendMessage(Main.C("&5Crystal II&8» &b1000"));
			p.sendMessage(Main.C("&5Crystal III&8» &b1500"));
			p.sendMessage(Main.C("&cMaster I&8» &b2000"));
			p.sendMessage(Main.C("&cMaster II&8» &b2500"));
			p.sendMessage(Main.C("&cMaster III&8» &b3000"));
			p.sendMessage(Main.C("&4Champ I&8» &b4000"));
			p.sendMessage(Main.C("&4Champ II&8» &b5000"));
			p.sendMessage(Main.C("&4Champ III&8» &b6000"));
			p.sendMessage(Main.C("&9Legend I&8» &b7000"));
			p.sendMessage(Main.C("&9Legend II&8» &b9000"));
			p.sendMessage(Main.C("&6&lEpic&8» &b12000"));
			p.sendMessage(Main.C("&e▸ &fYour currently rank&r " + Prestiges.getPrestige(p)));
			p.sendMessage("");
			p.sendMessage(Main.C("&8&l&m---------------------"));
		}
		
		return false;
	}

}
