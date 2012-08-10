package com.drudekenstudios.walkinggold;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.block.Block;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;

public class WalkingGold extends JavaPlugin {
	
	private final WGPlayerListener pl = new WGPlayerListener();
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(pl,this);
	}

	public void onDisable(){
		getLogger().info("Your plugin has been disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = null;
		Player target = null;

		if(sender instanceof Player){
			player = (Player) sender;
		}else{
			msg(sender,"You must be a player!");
			return false;
		}

		target = (Bukkit.getServer().getPlayer(args[0]));

		if(target == null){
			msg(sender,args[0] + "is not valid or is not online!");
			return false;
		}

		String cmdName = cmd.getName().toLowerCase();

		switch(cmdName){
		case "on":
			msg(sender,"You now walk on blocks of GOLD!");
			return true;
		case "off":
			msg(sender,"You no longer walk on blocks of GOLD!");
			return true;

		default:

			return false;
		}

	}

	
	private void msg(CommandSender sender, String msg){
		sender.sendMessage(msg);
	}
}
