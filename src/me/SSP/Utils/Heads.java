package me.SSP.Utils;

import org.bukkit.inventory.ItemStack;

import me.SSP.Main;

public enum Heads {
	
	rare("NDNkMDRkYmE1MWY4OTI0OTU4MzRmZjcxYTQyOWE4YTkxMDE1YTVhNzg2Yjg1NmZmZTljMDI0Y2RiNTJmYmM4ZiJ9fX0=", "rare"),
    epic("MzE1NDRiZDcyNjA1ODI3YjlhODgwMjNlNzgzNjhiNDFlOGY4M2FjNWM5ZTQ3YzgyZmIxOTZmYzY3MmIyMmE3NiJ9fX0=", "epic"),
    common("ZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0=", "common"),
    enderchest("Mzc0ZWUxNTQyYzQ1NjNmZDZlN2Q3MmRlMjZlNzM3Y2YxOGZiZDA0Y2NhYjFiOGIyODM1M2RhODczNDhlY2ZiIn19fQ==", "enderchest"),
    trash("YzA3NDI0ZWZiMzQ4MWUyMjY4ZjFhNjQ0OWRlOTQzZTMxYmJmNzIxZTQzZGNlYTE5OTYxYWE5MzFjODFkYjU2OCJ9fX0=", "trash");
    
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
    private ItemStack item;
    private String idTag;

    private Heads(String texture, String id) {
        this.item = Main.createSkull(String.valueOf(this.prefix) + texture, id);
        this.idTag = id;
    }

    public ItemStack getItemStack() {
        return this.item;
    }

    public String getName() {
        return this.idTag;
    }

}
