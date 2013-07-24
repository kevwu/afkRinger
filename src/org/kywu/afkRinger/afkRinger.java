package org.kywu.afkRinger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class afkRinger extends JavaPlugin
{
	
	@Override
	public void onEnable()
	{
		getLogger().info("AFK Ringer ready.");
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("ring"))
		{
			if(args.length > 0)
			{
				Player recipient = (Bukkit.getServer().getPlayer(args[0]));
				if(recipient != null)
				{
					Location ringerLoc = recipient.getLocation();
					Sound sound = null;
					if(args.length == 1)
					{
						sound = Sound.NOTE_PIANO;
					} else if(args.length == 2)
					{
						switch(args[1])
						{
							case "ghast":
								sound = Sound.GHAST_SCREAM;
								break;
							case "thunder":
								sound = Sound.AMBIENCE_THUNDER;
								break;
							case "cave":
								sound = Sound.AMBIENCE_CAVE;
								break;
							case "click":
								sound = Sound.CLICK;
								break;
							case "creeper":
								sound = Sound.CREEPER_HISS;
								break;
							case "explosion":
								sound = Sound.EXPLODE;
								break;
							case "burp":
								sound = Sound.BURP;
								break;
							case "vwoop":
								sound = Sound.ENDERMAN_TELEPORT;
								break;
							case "piano":
								sound = Sound.NOTE_PIANO;
								break;
							case "glass":
								sound = Sound.GLASS;
								break;
							default:
								sound = null;
								sender.sendMessage("Usable sounds: ghast, thunder, cave, click, creeper, explosion, burp, vwoop, piano");
						}
					} else if(args.length > 2)
					{
						return false;
					}
					if(sound != null)
					{
						recipient.sendMessage(sender.getName() + " would like to get your attention!");	
						recipient.playSound(ringerLoc, sound, 20, 1);
					}
					return true;
				} else
				{
					sender.sendMessage("That player is not online!");
				}
			} else
			{
				return false;
			}
		}
		return false;
	}
}