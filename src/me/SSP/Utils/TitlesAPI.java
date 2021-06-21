package me.SSP.Utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class TitlesAPI {
	
	public static void sendActionBar(Player P, String Msg) {
        CraftPlayer CraftPlayer2 = (CraftPlayer)P;
        IChatBaseComponent ChatComponent = ChatSerializer.a((String)("{\"text\": \"" + Msg.replaceAll("&", "\u00a7") + "\"}"));
        PacketPlayOutChat Packet2 = new PacketPlayOutChat(ChatComponent, (byte) 2);
        CraftPlayer2.getHandle().playerConnection.sendPacket(Packet2);
    }
	
	public static void sendTitle(Player p, String Msg){
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\": \"" + Msg.replaceAll("&", "\u00a7") + "\"}"),100,20,20);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
	}

}
