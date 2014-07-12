package com.tenjava.entries.Mali_Plavi.t2.listeners;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
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
	public Inventory music;
	public Inventory shop;
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
				//
				ItemStack music = new ItemStack(Material.JUKEBOX);
				ItemMeta mum = music.getItemMeta();
				ArrayList<String> mul = new ArrayList<String>();
				mul.add(ChatColor.GRAY + "Plays music");
				mum.setDisplayName("Music");
				mum.setLore(mul);
				music.setItemMeta(mum);
				//
				ItemStack h = new ItemStack(Material.WOOL);
				ItemMeta hm = h.getItemMeta();
				ArrayList<String> hl = new ArrayList<String>();
				hl.add(ChatColor.GRAY + "Call hospital");
				hm.setDisplayName("Hospital");
				hm.setLore(hl);
				h.setItemMeta(hm);
				//
				ItemStack s = new ItemStack(Material.MINECART);
				ItemMeta sm = m.getItemMeta();
				ArrayList<String> sl = new ArrayList<String>();
				sl.add(ChatColor.GRAY + "Buy stuff");
				sm.setDisplayName("Shop");
				sm.setLore(sl);
				s.setItemMeta(sm);
				
				
				//if(p.getItemInHand().getItemMeta().getDisplayName() == "Phone"){
					i = Bukkit.createInventory(null, 27, "Phone");
					i.setItem(1, m);
					i.setItem(3, music);
					i.setItem(5, h);
					i.setItem(7, s);
					p.openInventory(i);
				//}
			}	
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem().getType() == Material.PAPER){
				if(e.getInventory().getTitle() == "Phone"){
					p.closeInventory();
				p.sendMessage("TO(say the person):");
				to.put(p, true);
				
				//msg.setItem(1, new ItemStack(Material.THIN_GLASS));
			}
		}
		if(e.getCurrentItem().getType() == Material.JUKEBOX){
			e.setCancelled(true);
			music = Bukkit.createInventory(null , 9);
			music.addItem(new ItemStack(Material.RECORD_3));
			music.addItem(new ItemStack(Material.RECORD_4));
			music.addItem(new ItemStack(Material.RECORD_5));
			p.closeInventory();
			p.openInventory(music);
			music.addItem(new ItemStack(Material.RECORD_6));
			music.addItem(new ItemStack(Material.RECORD_7));
			music.addItem(new ItemStack(Material.RECORD_8));
			music.addItem(new ItemStack(Material.RECORD_9));
			music.addItem(new ItemStack(Material.RECORD_10));
			music.addItem(new ItemStack(Material.RECORD_11));
		}
		if(e.getCurrentItem().getType() == Material.RECORD_3){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_3);
			p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.RECORD_4){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_4);
			p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.RECORD_5){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_5);p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.RECORD_6){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_6);p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.RECORD_7){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_7);p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.RECORD_8){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_8);p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.RECORD_9){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_9);p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.RECORD_10){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_10);p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.RECORD_11){
			p.playEffect(p.getLocation(), Effect.RECORD_PLAY, Material.RECORD_11);p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.WOOL){
			p.setHealth(p.getHealthScale());
			p.closeInventory();
		}else if(e.getCurrentItem().getType() == Material.MINECART){
			e.setCancelled(true);
			shop = Bukkit.createInventory(null, 9,"Shop");
			shop.addItem(new ItemStack(Material.COOKED_BEEF,64));
			shop.addItem(new ItemStack(Material.EXP_BOTTLE,16));
			p.openInventory(shop);
		}else if(e.getCurrentItem().getType() == Material.COOKED_BEEF){
			p.closeInventory();
			p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,64));
		}else if(e.getCurrentItem().getType() == Material.EXP_BOTTLE){
			p.closeInventory();
			p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE,16));
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
						e.setMessage(null);
						e.setCancelled(true);
				}
				for(Player all : Bukkit.getOnlinePlayers()){
					if(all.equals(m)){
						player = all;
						e.setMessage(null);
						to.put(p, false);
						ms.put(p, true);
						p.sendMessage("Message:");
						return;
					}
					}
				p.sendMessage(ChatColor.DARK_RED + "That player is not on the server");
				}
			}
		if(ms.containsKey(p) | ms.get(p).equals(true)){
			msg = m;
			player.sendMessage(ChatColor.AQUA + "[" + p + " -> You] " + msg);
			e.setMessage(null);
		}
		}
	}
