package com.tenjava.entries.Mali_Plavi.t2;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.Mali_Plavi.t2.listeners.Listener;

public class TenJava extends JavaPlugin{
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Listener(), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		 Player p = (Player) sender;
		 if(label.equalsIgnoreCase("ph")){
			 if(p.isOp() || p.hasPermission("phone.get")){
				 ItemStack i = new ItemStack(Material.THIN_GLASS, 1);
				 ArrayList<String> a = new ArrayList<String>();
				 a.add(ChatColor.GRAY + "This is your phone");
				 a.add(ChatColor.GRAY + ",you can do many thing with it");
				 ItemMeta m = i.getItemMeta();
				 m.setDisplayName("Phone");
				 m.setLore(a);
				 i.setItemMeta(m);
				 p.getInventory().addItem(i);
			 }
		 }
		return false;
	}
}
