package me.SSP.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.SSP.Main;

public class ScoreBoard {
	
	public static void loadSB(Player p){
		Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = b.registerNewObjective("Strix", "RunTaskLater");
        
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(Main.C("&e&lStrix"));
        
        
        Team ping = b.registerNewTeam("ping");
        ping.addEntry(ChatColor.RED.toString());
        ping.setPrefix(Main.C("&e▸ &fPing"));
        ping.setSuffix(Main.C("&r ") + Ping.getPing(p));
        
        Team prestige = b.registerNewTeam("prestige");
        prestige.addEntry(ChatColor.BLUE.toString());
        prestige.setPrefix(Main.C("&e▸ &fPrestige"));
        prestige.setSuffix(Main.C("&r ") + Prestiges.getPrestige(p));
        
        Team scoins = b.registerNewTeam("scoins");
        scoins.addEntry(ChatColor.YELLOW.toString());
        scoins.setPrefix(Main.C("&e▸ &fSCoins"));
        scoins.setSuffix(Main.C("&b ") + Data.getCoins(p));
        
        Team kills = b.registerNewTeam("kills");
        kills.addEntry(ChatColor.GREEN.toString());
        kills.setPrefix(Main.C("&e▸ &fKills"));
        kills.setSuffix(Main.C("&b ") + Data.getKills(p));
        
        Team deaths = b.registerNewTeam("deaths");
        deaths.addEntry(ChatColor.DARK_RED.toString());
        deaths.setPrefix(Main.C("&e▸ &fDeaths"));
        deaths.setSuffix(Main.C("&c ") + Data.getDeaths(p));
        
        Team killstreaks = b.registerNewTeam("killstreaks");
        killstreaks.addEntry(ChatColor.AQUA.toString());
        killstreaks.setPrefix(Main.C("&e▸ &fStreaks"));
        killstreaks.setSuffix(Main.C("&b ") + Lists.KillStreaks.get(p.getName()));
        
        Team kdr = b.registerNewTeam("kdr");
        kdr.addEntry(ChatColor.BLACK.toString());
        kdr.setPrefix(Main.C("&e▸ &fKDR"));
        kdr.setSuffix(Main.C("&b ") + Data.getKDR(p));
        
        
        o.getScore(Main.C("&r&8&m&l--------------")).setScore(10);
        o.getScore(ChatColor.BLUE.toString()).setScore(9);
        o.getScore(ChatColor.RED.toString()).setScore(8);
        o.getScore(ChatColor.YELLOW.toString()).setScore(7);
        o.getScore(ChatColor.BLACK.toString()).setScore(6);
        o.getScore(Main.C("&8")).setScore(5);
        o.getScore(ChatColor.GREEN.toString()).setScore(4);
        o.getScore(ChatColor.DARK_RED.toString()).setScore(3);
        o.getScore(ChatColor.AQUA.toString()).setScore(2);
        o.getScore(Main.C("&8&m&l--------------")).setScore(1);
        o.getScore(Main.C("&7welcome to strix")).setScore(0);
        
        p.setScoreboard(b);
	}
	
	static public void updateSB(Player p) {
		  Scoreboard board = p.getScoreboard();
		  Team ping = board.getTeam("ping");
		  Team prestige = board.getTeam("prestige");
		  Team scoins = board.getTeam("scoins");
		  Team kills = board.getTeam("kills");
		  Team deaths = board.getTeam("deaths");
		  Team killstreaks = board.getTeam("killstreaks");
		  Team kdr = board.getTeam("kdr");
		  ping.setPrefix(Main.C("&e▸ &fPing"));
	      ping.setSuffix(Main.C("&r ") + Ping.getPing(p));
	      prestige.setPrefix(Main.C("&e▸ &fPrestige"));
	      prestige.setSuffix(Main.C("&r ") + Prestiges.getPrestige(p));
	      scoins.setPrefix(Main.C("&e▸ &fSCoins"));
	      scoins.setSuffix(Main.C("&b ") + Data.getCoins(p));
	      kills.setPrefix(Main.C("&e▸ &fKills"));
	      kills.setSuffix(Main.C("&b ") + Data.getKills(p));
	      deaths.setPrefix(Main.C("&e▸ &fDeaths"));
	      deaths.setSuffix(Main.C("&c ") + Data.getDeaths(p));
	      killstreaks.setPrefix(Main.C("&e▸ &fStreaks"));
	      killstreaks.setSuffix(Main.C("&b ") + Lists.KillStreaks.get(p.getName()));
	      kdr.setPrefix(Main.C("&e▸ &fKDR"));
	      kdr.setSuffix(Main.C("&b ") + Data.getKDR(p));
		  p.setScoreboard(board);
		}

}
