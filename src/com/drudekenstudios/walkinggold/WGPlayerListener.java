package com.drudekenstudios.walkinggold;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class WGPlayerListener implements Listener {
	public WGPlayerListener(){}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent evt){
		Location loc = evt.getPlayer().getLocation();
		World w = loc.getWorld();
		loc.setY(loc.getY() - 1);
		Block b = w.getBlockAt(loc);
		if(b.getTypeId() != 0){
		b.setTypeId(41);
		}
	}
}
