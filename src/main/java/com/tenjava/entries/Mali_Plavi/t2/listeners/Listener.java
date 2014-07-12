package com.tenjava.entries.Mali_Plavi.t2.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Listener implements org.bukkit.event.Listener{
	public Inventory i;
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_AIR || e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK){
			if(p.getItemInHand().getType() == Material.THIN_GLASS){
				//if(p.getItemInHand().getItemMeta().getDisplayName() == "Phone"){
					i = Bukkit.createInventory(null, 27, "Phone");
					p.openInventory(i);
				//}
			}	
		}
	}
}
