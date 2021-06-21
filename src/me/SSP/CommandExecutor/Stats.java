package me.SSP.CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.SSP.Main;
import me.SSP.Utils.Data;
import me.SSP.Utils.Lists;
import me.SSP.Utils.Prestiges;

public class Stats implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("stats")){
			Player p = (Player)sender;
			
			if(args.length == 0){
				p.sendMessage(Main.C("&8&m&l------------------"));
				p.sendMessage(Main.C("&e▸ &fKills &e") + Data.getKills(p));
				p.sendMessage(Main.C("&e▸ &fDeaths &c") + Data.getDeaths(p));
				p.sendMessage(Main.C("&e▸ &fCoins &e") + Data.getCoins(p));
				float KDR = Data.getKills(p) / Data.getDeaths(p);
				p.sendMessage(Main.C("&e▸ &fKDR &e") + KDR);
				p.sendMessage(Main.C("&e▸ &fPrestige &e") + Prestiges.getPrestige(p));
				p.sendMessage(Main.C("&e▸ &fStreaks &e" + Lists.KillStreaks.get(p.getName())));
				p.sendMessage(Main.C("&8&m&l------------------"));
			} else {
				Player t = Bukkit.getPlayerExact(args[0]);
				if(t != null){
						p.sendMessage(Main.C("&8&m&l------------------"));
						p.sendMessage(Main.C("&e▸ &fName &e" + t.getName()));
						p.sendMessage(Main.C("&e▸ &fKills &e") + Data.getKills(t));
						p.sendMessage(Main.C("&e▸ &fDeaths &c") + Data.getDeaths(t));
						p.sendMessage(Main.C("&e▸ &fCoins &e") + Data.getCoins(t));
						float KDR = Data.getKills(t) / Data.getDeaths(t);
						p.sendMessage(Main.C("&e▸ &fKDR &e") + KDR);
						p.sendMessage(Main.C("&e▸ &fPrestige &e") + Prestiges.getPrestige(t));
						p.sendMessage(Main.C("&e▸ &fStreaks &e" + Lists.KillStreaks.get(t.getName())));
						p.sendMessage(Main.C("&8&m&l------------------"));
				} else {p.sendMessage(Main.C("&e▸ &fPlayer &e" + args[0] + " &fis &cOffline"));}
			} 
		}
		
		return false;
	}
	

}
