package com.massivecraft.massivecore.item;

import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;

public class ConverterToEnchant extends Converter<Integer, Enchantment>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static final ConverterToEnchant i = new ConverterToEnchant();
	public static ConverterToEnchant get() { return i; }
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public Enchantment convert(Integer x)
	{
		if (x == null) return null;
		// Enchantment.getById() was removed in 1.21; look up by NamespacedKey hashCode.
		for (Enchantment e : Registry.ENCHANTMENT)
		{
			if (e.getKey().toString().hashCode() == x) return e;
		}
		return null;
	}

}
