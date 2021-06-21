package me.SSP.Utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping {
	
	public static String getPing(final Player p) {
        String msg = "0";
        int ping = ((CraftPlayer)p).getHandle().ping;
        if (ping >= 105) {
            msg = "§2" + ping;
        }
        else if (ping >= 220) {
            msg = "§e" + ping;
        }
        else if (ping >= 400) {
            msg = "§4" + ping;
        }
        else {
            msg = "§a" + ping;
        }
        return msg;
    }

}
