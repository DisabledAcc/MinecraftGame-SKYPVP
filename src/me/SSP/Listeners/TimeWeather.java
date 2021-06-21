package me.SSP.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class TimeWeather implements Listener{
	
	@EventHandler
	public void weatherChange(WeatherChangeEvent e){
		
		e.setCancelled(true);
		
		if(e.getWorld().getTime() < 0){
			e.getWorld().setTime(0);
		}
		
	}


}
