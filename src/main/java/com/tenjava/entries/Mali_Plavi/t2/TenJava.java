package com.tenjava.entries.Mali_Plavi.t2;

import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.Mali_Plavi.t2.listeners.Listener;

public class TenJava extends JavaPlugin{
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Listener(), this);
	}
}
