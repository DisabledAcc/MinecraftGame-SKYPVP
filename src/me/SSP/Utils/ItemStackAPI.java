package me.SSP.Utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.SSP.Main;

public class ItemStackAPI {
	
	public static ItemStack skypvpMenu_Back(){
		ItemStack s = new ItemStack(Material.ARROW);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&bGo back"));
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Main_Food(){
		ItemStack s = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&e▸ &fFood"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Click to buy food"));
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Main_Armors(){
		ItemStack s = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&e▸ &fArmors"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Click to buy armors"));
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Main_Swords(){
		ItemStack s = new ItemStack(Material.IRON_SWORD);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&e▸ &fSwords"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Click to buy swords"));
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Main_Perks(){
		ItemStack s = new ItemStack(Material.NETHER_STAR);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&e▸ &cPerks"));
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Food_GAPPLE(){
		ItemStack s = new ItemStack(Material.GOLDEN_APPLE, 2);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&e2x GoldenApples"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Price&b: &f60SC"));
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Food_GAPPLE1(){
		ItemStack s = new ItemStack(Material.GOLDEN_APPLE, 32);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&e32x GoldenApples"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Price&b: &f360SC"));
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Food_GAPPLE2(){
		ItemStack s = new ItemStack(Material.GOLDEN_APPLE, 1 , (short) 1);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&e1 GoldenNotch"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Price&b: &f560SC"));
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Armors_Helmet(){
		ItemStack s = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&eHelmet"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Price&b: &f760SC"));
		m.addEnchant(Enchantment.DURABILITY, 1, true);
		m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Armors_Chestplate(){
		ItemStack s = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&eChestplate"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Price&b: &f660SC"));
		m.addEnchant(Enchantment.DURABILITY, 1, true);
		m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Armors_Leggings(){
		ItemStack s = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&eLeggings"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Price&b: &f460SC"));
		m.addEnchant(Enchantment.DURABILITY, 1, true);
		m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Armors_Boots(){
		ItemStack s = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&eBoots"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Price&b: &f360SC"));
		m.addEnchant(Enchantment.DURABILITY, 1, true);
		m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack skypvpMenu_Swords_Sword(){
		ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta m = s.getItemMeta();
		m.setDisplayName(Main.C("&eSword"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&8» &7Price&b: &f360SC"));
		m.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		m.setLore(lore);
		s.setItemMeta(m);
		return s;
	}
	
	public static ItemStack DefaultKit_Helmet(){
		ItemStack item = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&7Default"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack DefaultKit_Chestplate(){
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&7Default"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack DefaultKit_Leggings(){
		ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&7Default"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack DefaultKit_Boots(){
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&7Default"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack DefaultKit_Sword(){
		ItemStack item = new ItemStack(Material.WOOD_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&7Default"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack DefaultKit_Bow(){
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&7Default"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack DefaultKit_Arrows(){
		ItemStack item = new ItemStack(Material.ARROW, 25);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&7Default"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack SuperKit_Helmet(){
		ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&eSuper"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack SuperKit_Chestplate(){
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&eSuper"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack SuperKit_Leggings(){
		ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&eSuper"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack SuperKit_Boots(){
		ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&eSuper"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack SuperKit_Sword(){
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&eSuper"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack SuperKit_Bow(){
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&eSuper"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack SuperKit_Arrows(){
		ItemStack item = new ItemStack(Material.ARROW, 45);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.C("&eSuper"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.C("&c&lLOCKED"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

}
