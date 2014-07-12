package com.tenjava.entries.Mali_Plavi.t2.commands;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Comamnd extends JavaPlugin{

	public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
		Player p = (Player) sender;
		if(label.equalsIgnoreCase("test")){
			p.sendMessage("It works!");
		}
	return false;	
	}
}
