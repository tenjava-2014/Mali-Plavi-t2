package com.tenjava.entries.Mali_Plavi.t2.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor.EntityType;

public class Listener implements org.bukkit.event.Listener{
	public Inventory i;
	public Inventory spawn;
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_AIR || e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK){
			if(p.getItemInHand().getType() == Material.THIN_GLASS){
				//--------------------------------------------------
				//ItemStack s = new ItemStack(Material.MONSTER_EGG,1,(short) 1,(byte)1);
				//ItemMeta sm = s.getItemMeta();
				//ArrayList<String> sl = new ArrayList<String>();
				//sl.add(ChatColor.GRAY + "Spawn Mobs");
				//sm.setDisplayName("Spawn");
				//sm.setLore(sl);
				//s.setItemMeta(sm);
				//---------------------------------
				ItemStack s = new ItemStack(Material.MONSTER_EGG,1,(short) 1,(byte)1);
				ItemMeta sm = s.getItemMeta();
				ArrayList<String> sl = new ArrayList<String>();
				sl.add(ChatColor.GRAY + "Spawn Mobs");
				sm.setDisplayName("Spawn");
				sm.setLore(sl);
				s.setItemMeta(sm);
				
				
				//if(p.getItemInHand().getItemMeta().getDisplayName() == "Phone"){
					i = Bukkit.createInventory(null, 27, "Phone");
					//i.setItem(1, s);
					p.openInventory(i);
				//}
			}	
		}
	}
	
	@SuppressWarnings({"deprecation"})
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem().getType() == Material.MONSTER_EGG){
			if(e.getCurrentItem().getData().getData() == 1){
				if(e.getInventory().getTitle() == "Phone"){
				ItemStack ci = new ItemStack(Material.MONSTER_EGG,1,(short)1,(byte)50);
				ItemMeta cm = ci.getItemMeta();
				cm.setDisplayName("Creeper");
				ci.setItemMeta(cm);
				//
				ItemStack si = new ItemStack(Material.MONSTER_EGG,1,(short)1,(byte)51);
				ItemMeta sm = ci.getItemMeta();
				sm.setDisplayName("Skeleton");
				si.setItemMeta(sm);
				
				
				spawn = Bukkit.createInventory(null, 54,"Spawn");
				spawn.setItem(0, ci);
				spawn.setItem(2, si);
				p.openInventory(spawn);
				}
			}
		}
	}
	@EventHandler
	public void click(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem().getType() == Material.MONSTER_EGG){
			if(e.getCurrentItem().getData().getData() == (byte)50){
				p.sendMessage("paass");
				if(e.getInventory().getTitle() == "Spawn"){
				p.closeInventory();
				p.getWorld().spawnEntity((Location) p.getTargetBlock(null, 200).getLocation().add(0, 2, 0), org.bukkit.entity.EntityType.CREEPER);
				}
			}
		}
	}
}
