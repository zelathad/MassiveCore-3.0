package com.massivecraft.massivecore.nms;

import org.bukkit.entity.Player;

public class NmsBasics121P extends NmsBasics
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static NmsBasics121P i = new NmsBasics121P();
	public static NmsBasics121P get() { return i; }

	// -------------------------------------------- //
	// PROVOKE
	// -------------------------------------------- //
	// Player.getPing() was added to the Paper API in 1.16+.
	// On Spigot 1.12 and older this method does not exist, so the constructor
	// throws and the Mixin system falls back to NmsBasics17R4P.

	@Override
	public Object provoke() throws Throwable
	{
		return Player.class.getMethod("getPing");
	}

	// -------------------------------------------- //
	// PING
	// -------------------------------------------- //

	@Override
	public int getPing(Player player)
	{
		return player.getPing();
	}

}
