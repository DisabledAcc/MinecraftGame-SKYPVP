package me.SSP.Listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import me.SSP.Main;
import me.SSP.Utils.Data;
import me.SSP.Utils.ItemStackAPI;
import me.SSP.Utils.Lists;

public class Interact implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(p.getItemInHand().getType() == Material.GOLDEN_APPLE){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.EAT, 5, 5);
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*5, 2));
				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*120, 0));
				if (p.getItemInHand().getAmount() == 1) {
                    p.setItemInHand(null);
                } else {
                    p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                }
			}
			if(p.getItemInHand().getType() == Material.GHAST_TEAR && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a12+ §6Coins")){
				if (p.getItemInHand().getAmount() == 1) {
                    p.setItemInHand(null);
                } else {
                    p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                }
				Data.addCoins(p, 12);
				p.sendMessage(Main.C("&e▸ &fYou've been given &e12 &fCoins!"));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
			}
		}
	}
	
	@EventHandler
	public void onInteractOnEntity(PlayerInteractAtEntityEvent e){
		Player p = e.getPlayer();
		Entity t = e.getRightClicked();
		Location tloc = e.getRightClicked().getLocation();
		Location ploc = p.getLocation();
		
		if(t.getType().equals(EntityType.ENDER_CRYSTAL)){
			if(t.getCustomName().equals(Main.C("&7▸ &e&lSky&6&lPvp"))){
				if(Lists.removeMode.contains(p)){
					p.sendMessage(Main.C("&e▸ &eShop &fremoved!."));
					t.remove();
					p.playSound(ploc, Sound.NOTE_BASS, 10, 10);
				} else {
					Inventory inv = Bukkit.createInventory(null, 27, Main.C("&e&lSky&6&lPvp"));
					inv.setItem(10, ItemStackAPI.skypvpMenu_Main_Food());
					inv.setItem(13, ItemStackAPI.skypvpMenu_Main_Armors());
					inv.setItem(16, ItemStackAPI.skypvpMenu_Main_Swords());
					inv.setItem(4, ItemStackAPI.skypvpMenu_Main_Perks());
					p.openInventory(inv);
				}
			}
		}
		
		if(t instanceof ArmorStand){
			if(Lists.removeMode.contains(p)){
				e.setCancelled(true);
				t.remove();
				p.playSound(ploc, Sound.NOTE_BASS, 10, 10);
				if(t.getCustomName().contains("1")){
					p.sendMessage(Main.C("&e▸ &7Common &fcrate removed!."));
				}
				if(t.getCustomName().contains("2")){
					p.sendMessage(Main.C("&e▸ &eRare &fcrate removed!."));
				}
				if(t.getCustomName().contains("3")){
					p.sendMessage(Main.C("&e▸ &cEpic &fcrate removed!."));
				}
			} else {
				if(t.getCustomName().contains("4")){
					e.setCancelled(true);
					Inventory i = Bukkit.createInventory(null, 54, Main.C("&f&lRecycler"));
					p.openInventory(i);
				}
				
				if(t.getCustomName().contains("5")){
					e.setCancelled(true);
					p.openInventory(p.getEnderChest());
					p.playSound(ploc, Sound.CHEST_OPEN, 10, 10);
				}
				
				if(t.getCustomName().contains("1")){
					e.setCancelled(true);
					int rn = new Random().nextInt(12);
					switch(rn){
					    case 0:{
						    tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.CHAINMAIL_CHESTPLATE));
						break;
					    }
					    case 1:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.CHAINMAIL_LEGGINGS));
							break;
						}
					    case 2:{
							ItemStack s = new ItemStack(Material.LEATHER_BOOTS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
							m.addEnchant(Enchantment.DURABILITY, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 3:{
					    	ItemStack s = new ItemStack(Material.LEATHER_HELMET);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
							m.addEnchant(Enchantment.DURABILITY, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 4:{
					    	ItemStack s = new ItemStack(Material.BOW);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 5:{
					    	Potion pn = new Potion(PotionType.FIRE_RESISTANCE);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), pn.toItemStack(1));
							break;
						}
					    case 6:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.IRON_AXE));
							break;
						}
					    case 7:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.IRON_SWORD));
							break;
						}
					    case 8:{
					    	ItemStack s = new ItemStack(Material.STONE_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 9:{
					    	ItemStack s = new ItemStack(Material.STONE_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 10:{
					    	ItemStack s = new ItemStack(Material.STONE_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
							m.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 11:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.SNOW_BALL, 7));
							break;
						}
					}
					
					p.playSound(ploc, Sound.FIREWORK_BLAST, 10, 10);
					t.remove();
					
					double randDouble = Math.random();

					if(randDouble <= 0.20D) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand epic = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            epic.setBasePlate(false);
	                            epic.setArms(false);
	                            epic.setVisible(false);
	                            epic.setGravity(false);
	                            epic.setCanPickupItems(false);
	                            epic.setSmall(true);
	                            epic.setHelmet(Main.getHead("epic"));
	                            epic.setCustomName("3");
	                            epic.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    epic.setHeadPose(new EulerAngle(epic.getHeadPose().getX(), epic.getHeadPose().getY() + 0.1 , epic.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					} else if(randDouble <= 0.60D) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand common = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            common.setBasePlate(false);
	                            common.setArms(false);
	                            common.setVisible(false);
	                            common.setGravity(false);
	                            common.setCanPickupItems(false);
	                            common.setSmall(true);
	                            common.setHelmet(Main.getHead("common"));
	                            common.setCustomName("1");
	                            common.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    common.setHeadPose(new EulerAngle(common.getHeadPose().getX(), common.getHeadPose().getY() + 0.1 , common.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					} else {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand rare = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            rare.setBasePlate(false);
	                            rare.setArms(false);
	                            rare.setVisible(false);
	                            rare.setGravity(false);
	                            rare.setCanPickupItems(false);
	                            rare.setSmall(true);
	                            rare.setHelmet(Main.getHead("rare"));
	                            rare.setCustomName("2");
	                            rare.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    rare.setHeadPose(new EulerAngle(rare.getHeadPose().getX(), rare.getHeadPose().getY() + 0.1 , rare.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					}
					
				}
				
				if(t.getCustomName().contains("2")){
					e.setCancelled(true);
					int rn = new Random().nextInt(38);
					switch(rn){
					    case 0:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.MILK_BUCKET));
						break;
					    }
					    case 1:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.GOLDEN_APPLE));
							break;
						}
					    case 2:{
					    	ItemStack s = new ItemStack(Material.BOW);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 3:{
					    	ItemStack s = new ItemStack(Material.BOW);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.ARROW_FIRE, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 4:{
					    	ItemStack s = new ItemStack(Material.BOW);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 5:{
					    	ItemStack s = new ItemStack(Material.BOW);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
							m.addEnchant(Enchantment.ARROW_FIRE, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 6:{
					    	Potion pn = new Potion(PotionType.REGEN);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), pn.toItemStack(2));
							break;
						}
					    case 7:{
					    	Potion pn = new Potion(PotionType.FIRE_RESISTANCE);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), pn.toItemStack(1));
							break;
						}
					    case 8:{
					    	Potion pn = new Potion(PotionType.POISON);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), pn.toItemStack(2));
							break;
						}
					    case 9:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.ENCHANTED_BOOK));
							break;
						}
					    case 10:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.FLINT_AND_STEEL));
							break;
						}
					    case 11:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.DIAMOND_AXE));
							break;
						}
					    case 12:{
					    	ItemStack s = new ItemStack(Material.IRON_AXE);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 13:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.FISHING_ROD));
							break;
						}
					    case 14:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.IRON_SWORD));
							break;
						}
					    case 15:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.DIAMOND_SWORD));
							break;
						}
					    case 16:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.DIAMOND_AXE));
							break;
						}
					    case 17:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 18:{
					    	ItemStack s = new ItemStack(Material.STONE_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
							m.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 19:{
					    	ItemStack s = new ItemStack(Material.STONE_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 20:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.CHAINMAIL_BOOTS));
							break;
						}
					    case 21:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.CHAINMAIL_HELMET));
							break;
						}
					    case 22:{
					    	ItemStack s = new ItemStack(Material.GOLD_BOOTS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 23:{
					    	ItemStack s = new ItemStack(Material.GOLD_LEGGINGS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 24:{
					    	ItemStack s = new ItemStack(Material.GOLD_CHESTPLATE);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 25:{
					    	ItemStack s = new ItemStack(Material.GOLD_HELMET);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 26:{
					    	ItemStack s = new ItemStack(Material.IRON_BOOTS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 27:{
					    	ItemStack s = new ItemStack(Material.IRON_LEGGINGS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 28:{
					    	ItemStack s = new ItemStack(Material.IRON_LEGGINGS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 29:{
					    	ItemStack s = new ItemStack(Material.IRON_CHESTPLATE);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
						break;
					    }
					    case 30:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.IRON_BOOTS));
						break;
					    }
					    case 31:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.IRON_LEGGINGS));
						break;
					    }
					    case 32:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.IRON_CHESTPLATE));
						break;
					    }
					    case 33:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.IRON_HELMET));
						break;
					    }
					    case 34:{
					    	ItemStack s = new ItemStack(Material.CHAINMAIL_BOOTS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
							m.addEnchant(Enchantment.DURABILITY, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
						break;
					    }
					    case 35:{
					    	ItemStack s = new ItemStack(Material.CHAINMAIL_LEGGINGS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
							m.addEnchant(Enchantment.DURABILITY, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
						break;
					    }
					    case 36:{
					    	ItemStack s = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
							m.addEnchant(Enchantment.DURABILITY, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
						break;
					    }
					    case 37:{
					    	ItemStack s = new ItemStack(Material.CHAINMAIL_HELMET);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
							m.addEnchant(Enchantment.DURABILITY, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
						break;
					    }
					}
					
					p.playSound(ploc, Sound.FIREWORK_BLAST, 10, 10);
					t.remove();
					
					double randDouble = Math.random();

					if(randDouble <= 0.20D) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand epic = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            epic.setBasePlate(false);
	                            epic.setArms(false);
	                            epic.setVisible(false);
	                            epic.setGravity(false);
	                            epic.setCanPickupItems(false);
	                            epic.setSmall(true);
	                            epic.setHelmet(Main.getHead("epic"));
	                            epic.setCustomName("3");
	                            epic.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    epic.setHeadPose(new EulerAngle(epic.getHeadPose().getX(), epic.getHeadPose().getY() + 0.1 , epic.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					} else if(randDouble <= 0.60D) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand common = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            common.setBasePlate(false);
	                            common.setArms(false);
	                            common.setVisible(false);
	                            common.setGravity(false);
	                            common.setCanPickupItems(false);
	                            common.setSmall(true);
	                            common.setHelmet(Main.getHead("common"));
	                            common.setCustomName("1");
	                            common.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    common.setHeadPose(new EulerAngle(common.getHeadPose().getX(), common.getHeadPose().getY() + 0.1 , common.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					} else {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand rare = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            rare.setBasePlate(false);
	                            rare.setArms(false);
	                            rare.setVisible(false);
	                            rare.setGravity(false);
	                            rare.setCanPickupItems(false);
	                            rare.setSmall(true);
	                            rare.setHelmet(Main.getHead("rare"));
	                            rare.setCustomName("2");
	                            rare.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    rare.setHeadPose(new EulerAngle(rare.getHeadPose().getX(), rare.getHeadPose().getY() + 0.1 , rare.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					}
					
				}
				
				if(t.getCustomName().contains("3")){
					e.setCancelled(true);
					int rn = new Random().nextInt(28);
					switch(rn){
					    case 0:{
					    	ItemStack s = new ItemStack(Material.GHAST_TEAR);
							ItemMeta m = s.getItemMeta();
							m.setDisplayName(Main.C("&a12+ &6Coins"));
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
						break;
					    }
					    case 1:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.GOLDEN_APPLE));
							break;
						}
					    case 2:{
					    	Potion pn = new Potion(PotionType.REGEN);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), pn.toItemStack(2));
							break;
						}
					    case 3:{
					    	Potion pn = new Potion(PotionType.SPEED);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), pn.toItemStack(2));
							break;
						}
					    case 4:{
					    	Potion pn = new Potion(PotionType.INSTANT_DAMAGE);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), pn.toItemStack(2));
							break;
						}
					    case 5:{
					    	Potion pn = new Potion(PotionType.STRENGTH);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), pn.toItemStack(2));
							break;
						}
					    case 6:{
					    	ItemStack s = new ItemStack(Material.BOW);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 7:{
					    	ItemStack s = new ItemStack(Material.BOW);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 8:{
					    	ItemStack s = new ItemStack(Material.BOW);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
							m.addEnchant(Enchantment.ARROW_FIRE, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 9:{
					    	ItemStack s = new ItemStack(Material.IRON_BOOTS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 10:{
					    	ItemStack s = new ItemStack(Material.IRON_LEGGINGS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 11:{
					    	ItemStack s = new ItemStack(Material.IRON_CHESTPLATE);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 12:{
					    	ItemStack s = new ItemStack(Material.IRON_HELMET);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 13:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.FISHING_ROD));
							break;
						}
					    case 14:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_AXE);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 15:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
							m.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 16:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 17:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
							m.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 18:{
					    	ItemStack s = new ItemStack(Material.IRON_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
							m.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 19:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 20:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.DIAMOND_BOOTS));
							break;
						}
					    case 21:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.DIAMOND_LEGGINGS));
							break;
						}
					    case 22:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.DIAMOND_CHESTPLATE));
							break;
						}
					    case 23:{
					    	tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), new ItemStack(Material.DIAMOND_HELMET));
							break;
						}
					    case 24:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_BOOTS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 25:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_LEGGINGS);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 26:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_CHESTPLATE);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					    case 27:{
					    	ItemStack s = new ItemStack(Material.DIAMOND_HELMET);
							ItemMeta m = s.getItemMeta();
							m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
							s.setItemMeta(m);
							tloc.getWorld().dropItemNaturally(tloc.clone().add(0,1,0), s);
							break;
						}
					}
					
					p.playSound(ploc, Sound.FIREWORK_BLAST, 10, 10);
					t.remove();
					
					double randDouble = Math.random();

					if(randDouble <= 0.20D) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand epic = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            epic.setBasePlate(false);
	                            epic.setArms(false);
	                            epic.setVisible(false);
	                            epic.setGravity(false);
	                            epic.setCanPickupItems(false);
	                            epic.setSmall(true);
	                            epic.setHelmet(Main.getHead("epic"));
	                            epic.setCustomName("3");
	                            epic.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    epic.setHeadPose(new EulerAngle(epic.getHeadPose().getX(), epic.getHeadPose().getY() + 0.1 , epic.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					} else if(randDouble <= 0.60D) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand common = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            common.setBasePlate(false);
	                            common.setArms(false);
	                            common.setVisible(false);
	                            common.setGravity(false);
	                            common.setCanPickupItems(false);
	                            common.setSmall(true);
	                            common.setHelmet(Main.getHead("common"));
	                            common.setCustomName("1");
	                            common.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    common.setHeadPose(new EulerAngle(common.getHeadPose().getX(), common.getHeadPose().getY() + 0.1 , common.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					} else {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
	                        
	                        @Override
	                        public void run() {
	                            ArmorStand rare = (ArmorStand)p.getLocation().getWorld().spawn(tloc, ArmorStand.class);
	                            rare.setBasePlate(false);
	                            rare.setArms(false);
	                            rare.setVisible(false);
	                            rare.setGravity(false);
	                            rare.setCanPickupItems(false);
	                            rare.setSmall(true);
	                            rare.setHelmet(Main.getHead("rare"));
	                            rare.setCustomName("2");
	                            rare.setCustomNameVisible(false);
	                            new BukkitRunnable() {
	                                
	                                @Override
	                                public void run() {

	                                    rare.setHeadPose(new EulerAngle(rare.getHeadPose().getX(), rare.getHeadPose().getY() + 0.1 , rare.getHeadPose().getZ()));
	                                    
	                                }
	                            }.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 1L, 1L);
	                            
	                        }
	                    }, 20*23);
					}
					
				}
				
			}
			
		}
		
	}
	
}
