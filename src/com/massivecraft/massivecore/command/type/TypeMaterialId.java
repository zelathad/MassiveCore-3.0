package com.massivecraft.massivecore.command.type;

import com.massivecraft.massivecore.command.type.enumeration.TypeMaterial;
import com.massivecraft.massivecore.command.type.primitive.TypeInteger;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;

public class TypeMaterialId extends TypeTransformer<Material, Integer> 
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static TypeMaterialId i = new TypeMaterialId();
	public static TypeMaterialId get() { return i; }
	
	public TypeMaterialId()
	{
		super(TypeMaterial.get(), TypeInteger.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	

	@Override
	public Integer innerToOuter(Material inner, CommandSender sender)
	{
		if (inner == null) return null;
		// Material.getId() was removed in 1.13 (flattening). Use ordinal as a stable int surrogate.
		return inner.ordinal();
	}

	@Override
	public Material outerToInner(Integer outer)
	{
		if (outer == null) return null;
		Material[] values = Material.values();
		if (outer < 0 || outer >= values.length) return null;
		return values[outer];
	}
	
}
