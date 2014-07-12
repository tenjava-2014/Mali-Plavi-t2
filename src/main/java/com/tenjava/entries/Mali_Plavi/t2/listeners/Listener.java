package com.tenjava.entries.Mali_Plavi.t2.listeners;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listener implements org.bukkit.event.Listener{
	public Inventory i;
	public HashMap<Player,Boolean> to = new HashMap<Player,Boolean>();
	public HashMap<Player,Boolean> ms = new HashMap<Player,Boolean>(); 
	public String msg;
	public Player player;
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
				ItemStack m = new ItemStack(Material.PAPER);
				ItemMeta mm = m.getItemMeta();
				ArrayList<String> ml = new ArrayList<String>();
				ml.add(ChatColor.GRAY + "Send Messages");
				mm.setDisplayName("Messages");
				mm.setLore(ml);
				m.setItemMeta(mm);
				
				
				//if(p.getItemInHand().getItemMeta().getDisplayName() == "Phone"){
					i = Bukkit.createInventory(null, 27, "Phone");
					i.setItem(1, m);
					p.openInventory(i);
				//}
			}	
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem().getType() == Material.PAPER){
			p.sendMessage("pass");
				if(e.getInventory().getTitle() == "Phone"){
					p.sendMessage("pass");
					p.closeInventory();
				p.sendMessage("TO(say the person):");
				to.put(p, true);
				
				//msg.setItem(1, new ItemStack(Material.THIN_GLASS));
			}
		}
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		String m = e.getMessage();
		if(to.containsKey(p) | to.get(p).equals(true)){
			if(to.get(p).equals(true)){
				if(m.equals(p)){
						p.sendMessage(ChatColor.DARK_RED + "You can't send message to yourself");
						p.sendMessage("TO(say the person):");
						e.setCancelled(true);
				}
				for(Player all : Bukkit.getOnlinePlayers()){
					if(all.equals(m)){
						player = all;
						e.setCancelled(true);
						to.put(p, false);
						ms.put(p, true);
						p.sendMessage("Message:");
						break;
					}
					}
				p.sendMessage(ChatColor.DARK_RED + "That player is not on the server");
				}
			}
		if(ms.containsKey(p) | ms.get(p).equals(true)){
			msg = m;
			player.sendMessage(ChatColor.AQUA + "[" + p + " -> You] " + msg);
			e.setCancelled(true);
		}
		}
	}
