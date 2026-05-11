package com.massivecraft.massivecore.nms;

import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.UUID;

public class NmsSkullMeta121P extends NmsSkullMeta
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static NmsSkullMeta121P i = new NmsSkullMeta121P();
	public static NmsSkullMeta121P get() { return i; }

	// -------------------------------------------- //
	// PROVOKE
	// -------------------------------------------- //
	// Bukkit's PlayerProfile API (SkullMeta#getOwnerProfile) was added in 1.18.
	// On older versions the Mixin system falls back to NmsSkullMeta18R1P.

	@Override
	public Object provoke() throws Throwable
	{
		return SkullMeta.class.getMethod("getOwnerProfile");
	}

	// -------------------------------------------- //
	// RAW
	// -------------------------------------------- //

	@Override
	public UUID getId(SkullMeta meta)
	{
		PlayerProfile profile = meta.getOwnerProfile();
		if (profile == null) return null;
		return profile.getUniqueId();
	}

	@Override
	public void set(SkullMeta meta, String name, UUID id)
	{
		PlayerProfile profile = Bukkit.createProfile(id, name);
		meta.setOwnerProfile(profile);
	}

}
