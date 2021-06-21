package me.SSP.Utils;

import org.bukkit.entity.Player;

public class Prestiges {
	
	public static String getPrestige(Player p){
		
		  String prestige = "§2NewBie";
		  
		  if(Data.getKills(p) >= 70){
		    prestige = "§2NewBie II";
		  }
		  if(Data.getKills(p) >= 140){
		    prestige = "§2NewBie III";
		  }
		  if(Data.getKills(p) >= 500){
		    prestige = "§5Crystal I";
		  }
		  if(Data.getKills(p) >= 1000){
			    prestige = "§5Crystal II";
			  }
		  if(Data.getKills(p) >= 1500){
			    prestige = "§5Crystal III";
			  }
		  if(Data.getKills(p) >= 2000){
			    prestige = "§cMaster I";
			  }
		  if(Data.getKills(p) >= 2500){
			    prestige = "§cMaster II";
			  }
		  if(Data.getKills(p) >= 3000){
			    prestige = "§cMaster III";
			  }
		  if(Data.getKills(p) >= 4000){
			    prestige = "§4Champ I";
			  }
		  if(Data.getKills(p) >= 5000){
			    prestige = "§4Champ II";
			  }
		  if(Data.getKills(p) >= 6000){
			    prestige = "§4Champ III";
			  }
		  if(Data.getKills(p) >= 7000){
			    prestige = "§9Legend I";
			  }
		  if(Data.getKills(p) >= 9000){
			    prestige = "§9Legend II";
			  }
		  if(Data.getKills(p) >= 12000){
			    prestige = "§6§lEpic";
			  }

		  return prestige;
		}

}
