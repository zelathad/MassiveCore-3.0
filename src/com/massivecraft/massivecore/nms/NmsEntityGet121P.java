package com.massivecraft.massivecore.nms;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.util.UUID;

public class NmsEntityGet121P extends NmsEntityGet
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static NmsEntityGet121P i = new NmsEntityGet121P();
	public static NmsEntityGet121P get() { return i; }

	// -------------------------------------------- //
	// PROVOKE
	// -------------------------------------------- //
	// Bukkit.getEntity(UUID) was added in Paper 1.12+ / Bukkit 1.16+.
	// On older Spigot without this method the Mixin falls back to NmsEntityGet18R1P.

	@Override
	public Object provoke() throws Throwable
	{
		return Bukkit.class.getMethod("getEntity", UUID.class);
	}

	// -------------------------------------------- //
	// GET ENTITY
	// -------------------------------------------- //

	@Override
	public Entity getEntity(UUID uuid)
	{
		if (uuid == null) return null;
		return Bukkit.getEntity(uuid);
	}

	@Override
	public Entity getEntity(World world, UUID uuid)
	{
		if (world == null) throw new NullPointerException("world");
		if (uuid == null) return null;
		return world.getEntities().stream()
			.filter(e -> uuid.equals(e.getUniqueId()))
			.findFirst()
			.orElse(null);
	}

}
