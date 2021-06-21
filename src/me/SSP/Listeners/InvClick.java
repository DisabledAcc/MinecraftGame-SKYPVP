package me.SSP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.SSP.Main;
import me.SSP.Utils.Data;
import me.SSP.Utils.ItemStackAPI;

public class InvClick implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		
		if(e.getClickedInventory().getTitle().equalsIgnoreCase(Main.C("&e&lSky&6&lPvp"))){
			if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Main_Food())){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 10, 10);
				
				Inventory inv = Bukkit.createInventory(null, 27, Main.C("&eFood"));
				inv.setItem(10, ItemStackAPI.skypvpMenu_Food_GAPPLE());
				inv.setItem(13, ItemStackAPI.skypvpMenu_Food_GAPPLE1());
				inv.setItem(16, ItemStackAPI.skypvpMenu_Food_GAPPLE2());
				inv.setItem(26, ItemStackAPI.skypvpMenu_Back());
				
				p.openInventory(inv);
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Main_Armors())){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 10, 10);
				
				Inventory inv = Bukkit.createInventory(null, 54, Main.C("&eArmors"));
				inv.setItem(10, ItemStackAPI.skypvpMenu_Armors_Helmet());
				inv.setItem(19, ItemStackAPI.skypvpMenu_Armors_Chestplate());
				inv.setItem(28, ItemStackAPI.skypvpMenu_Armors_Leggings());
				inv.setItem(37, ItemStackAPI.skypvpMenu_Armors_Boots());
				inv.setItem(53, ItemStackAPI.skypvpMenu_Back());
				
				p.openInventory(inv);
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Main_Swords())){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 10, 10);
				
				Inventory inv = Bukkit.createInventory(null, 27, Main.C("&eSwords"));
				inv.setItem(10, ItemStackAPI.skypvpMenu_Swords_Sword());
				inv.setItem(26, ItemStackAPI.skypvpMenu_Back());
				
				p.openInventory(inv);
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Main_Perks())){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 10, 10);
			}
		}
		
		if(e.getClickedInventory().getTitle().equalsIgnoreCase(Main.C("&eFood"))){
			if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Food_GAPPLE())){
				e.setCancelled(true);
				p.closeInventory();
				if(Data.getCoins(p) >= 60){
					p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.C("&e▸ &fThe purchase was completed &asuccessfully"));
					p.sendMessage(Main.C("&c-60&e$"));
					Data.removeCoins(p, 60);
				} else {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 5);
					p.sendMessage(Main.C("&cYou do not have enough coins yet to buy it"));
				}
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Food_GAPPLE1())){
				e.setCancelled(true);
				p.closeInventory();
				if(Data.getCoins(p) >= 360){
					p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 32));
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.C("&e▸ &fThe purchase was completed &asuccessfully"));
					p.sendMessage(Main.C("&c-360&e$"));
					Data.removeCoins(p, 360);
				} else {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 5);
					p.sendMessage(Main.C("&cYou do not have enough coins yet to buy it"));
				}
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Food_GAPPLE2())){
				e.setCancelled(true);
				p.closeInventory();
				if(Data.getCoins(p) >= 560){
					p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short)1));
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.C("&e▸ &fThe purchase was completed &asuccessfully"));
					p.sendMessage(Main.C("&c-560&e$"));
					Data.removeCoins(p, 560);
				} else {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 5);
					p.sendMessage(Main.C("&cYou do not have enough coins yet to buy it"));
				}
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Back())){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 10, 10);
				
				Inventory inv = Bukkit.createInventory(null, 27, Main.C("&e&lSky&6&lPvp"));
				inv.setItem(10, ItemStackAPI.skypvpMenu_Main_Food());
				inv.setItem(13, ItemStackAPI.skypvpMenu_Main_Armors());
				inv.setItem(16, ItemStackAPI.skypvpMenu_Main_Swords());
				inv.setItem(4, ItemStackAPI.skypvpMenu_Main_Perks());
				p.openInventory(inv);
			}
		}
		
		if(e.getClickedInventory().getTitle().equalsIgnoreCase(Main.C("&eArmors"))){
			if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Armors_Helmet())){
				e.setCancelled(true);
				p.closeInventory();
				if(Data.getCoins(p) >= 760){
					ItemStack s = new ItemStack(Material.DIAMOND_HELMET);
					ItemMeta m = s.getItemMeta();
					m.addEnchant(Enchantment.DURABILITY, 1, true);
					m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
					s.setItemMeta(m);
					p.getInventory().addItem(s);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.C("&e▸ &fThe purchase was completed &asuccessfully"));
					p.sendMessage(Main.C("&c-760&e$"));
					Data.removeCoins(p, 760);
				} else {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 5);
					p.sendMessage(Main.C("&cYou do not have enough coins yet to buy it"));
				}
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Armors_Chestplate())){
				e.setCancelled(true);
				p.closeInventory();
				if(Data.getCoins(p) >= 660){
					ItemStack s = new ItemStack(Material.DIAMOND_CHESTPLATE);
					ItemMeta m = s.getItemMeta();
					m.addEnchant(Enchantment.DURABILITY, 1, true);
					m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
					s.setItemMeta(m);
					p.getInventory().addItem(s);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.C("&e▸ &fThe purchase was completed &asuccessfully"));
					p.sendMessage(Main.C("&c-660&e$"));
					Data.removeCoins(p, 660);
				} else {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 5);
					p.sendMessage(Main.C("&cYou do not have enough coins yet to buy it"));
				}
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Armors_Leggings())){
				e.setCancelled(true);
				p.closeInventory();
				if(Data.getCoins(p) >= 560){
					ItemStack s = new ItemStack(Material.DIAMOND_LEGGINGS);
					ItemMeta m = s.getItemMeta();
					m.addEnchant(Enchantment.DURABILITY, 1, true);
					m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
					s.setItemMeta(m);
					p.getInventory().addItem(s);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.C("&e▸ &fThe purchase was completed &asuccessfully"));
					p.sendMessage(Main.C("&c-560&e$"));
					Data.removeCoins(p, 560);
				} else {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 5);
					p.sendMessage(Main.C("&cYou do not have enough coins yet to buy it"));
				}
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Armors_Boots())){
				e.setCancelled(true);
				p.closeInventory();
				if(Data.getCoins(p) >= 460){
					ItemStack s = new ItemStack(Material.DIAMOND_BOOTS);
					ItemMeta m = s.getItemMeta();
					m.addEnchant(Enchantment.DURABILITY, 1, true);
					m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
					s.setItemMeta(m);
					p.getInventory().addItem(s);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.C("&e▸ &fThe purchase was completed &asuccessfully"));
					p.sendMessage(Main.C("&c-460&e$"));
					Data.removeCoins(p, 460);
				} else {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 5);
					p.sendMessage(Main.C("&cYou do not have enough coins yet to buy it"));
				}
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Back())){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 10, 10);
				
				Inventory inv = Bukkit.createInventory(null, 27, Main.C("&e&lSky&6&lPvp"));
				inv.setItem(10, ItemStackAPI.skypvpMenu_Main_Food());
				inv.setItem(13, ItemStackAPI.skypvpMenu_Main_Armors());
				inv.setItem(16, ItemStackAPI.skypvpMenu_Main_Swords());
				inv.setItem(4, ItemStackAPI.skypvpMenu_Main_Perks());
				p.openInventory(inv);
			}
			
		}
		
		if(e.getClickedInventory().getTitle().equalsIgnoreCase(Main.C("&eSwords"))){
			if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Swords_Sword())){
				e.setCancelled(true);
				p.closeInventory();
				if(Data.getCoins(p) >= 360){
					ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
					ItemMeta m = s.getItemMeta();
					m.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
					m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					s.setItemMeta(m);
					p.getInventory().addItem(s);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.C("&e▸ &fThe purchase was completed &asuccessfully"));
					p.sendMessage(Main.C("&c-60&e$"));
					Data.removeCoins(p, 360);
				} else {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5, 5);
					p.sendMessage(Main.C("&cYou do not have enough coins yet to buy it"));
				}
			}
			else if(e.getCurrentItem().equals(ItemStackAPI.skypvpMenu_Back())){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 10, 10);
				
				Inventory inv = Bukkit.createInventory(null, 27, Main.C("&e&lSky&6&lPvp"));
				inv.setItem(10, ItemStackAPI.skypvpMenu_Main_Food());
				inv.setItem(13, ItemStackAPI.skypvpMenu_Main_Armors());
				inv.setItem(16, ItemStackAPI.skypvpMenu_Main_Swords());
				inv.setItem(4, ItemStackAPI.skypvpMenu_Main_Perks());
				p.openInventory(inv);
			}
		}
		
	}

}
