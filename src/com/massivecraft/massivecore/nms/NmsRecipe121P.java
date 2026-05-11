package com.massivecraft.massivecore.nms;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

public class NmsRecipe121P extends NmsRecipe
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static NmsRecipe121P i = new NmsRecipe121P();
	public static NmsRecipe121P get() { return i; }

	// -------------------------------------------- //
	// PROVOKE
	// -------------------------------------------- //
	// NamespacedKey-based recipe constructors exist since Bukkit 1.12.
	// On older servers without NamespacedKey the Mixin falls back to NmsRecipe112R1P.

	@Override
	public Object provoke() throws Throwable
	{
		return ShapedRecipe.class.getConstructor(NamespacedKey.class, ItemStack.class);
	}

	// -------------------------------------------- //
	// RECIPE CREATION
	// -------------------------------------------- //

	@Override
	public ShapelessRecipe createShapeless(ItemStack result)
	{
		return createShapeless(result, null, "massivecore_" + System.nanoTime());
	}

	@Override
	public ShapelessRecipe createShapeless(ItemStack result, Plugin plugin, String key)
	{
		NamespacedKey nk = (plugin != null)
			? new NamespacedKey(plugin, key)
			: NamespacedKey.minecraft(key.toLowerCase().replaceAll("[^a-z0-9_.-]", "_"));
		return new ShapelessRecipe(nk, result);
	}

	@Override
	public ShapedRecipe createShaped(ItemStack result)
	{
		return createShaped(result, null, "massivecore_" + System.nanoTime());
	}

	@Override
	public ShapedRecipe createShaped(ItemStack result, Plugin plugin, String key)
	{
		NamespacedKey nk = (plugin != null)
			? new NamespacedKey(plugin, key)
			: NamespacedKey.minecraft(key.toLowerCase().replaceAll("[^a-z0-9_.-]", "_"));
		return new ShapedRecipe(nk, result);
	}

}
