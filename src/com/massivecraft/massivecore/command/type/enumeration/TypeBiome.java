package com.massivecraft.massivecore.command.type.enumeration;

import com.massivecraft.massivecore.command.type.TypeAbstractChoice;
import com.massivecraft.massivecore.util.Txt;
import org.bukkit.Registry;
import org.bukkit.block.Biome;

import java.util.ArrayList;
import java.util.List;

public class TypeBiome extends TypeAbstractChoice<Biome>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static TypeBiome i = new TypeBiome();
	public static TypeBiome get() { return i; }
	public TypeBiome()
	{
		super(Biome.class);
		List<Biome> all = new ArrayList<>();
		Registry.BIOME.forEach(all::add);
		this.setAll(all);
	}

	@Override
	public String getNameInner(Biome value)
	{
		return Txt.getNicedEnumString(value.getKey().getKey());
	}

	@Override
	public String getIdInner(Biome value)
	{
		return value.getKey().getKey();
	}

}
