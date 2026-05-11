package com.massivecraft.massivecore.command.type.enumeration;

import com.massivecraft.massivecore.command.type.TypeAbstractChoice;
import com.massivecraft.massivecore.util.Txt;
import org.bukkit.Registry;
import org.bukkit.block.banner.PatternType;

import java.util.ArrayList;
import java.util.List;

public class TypePatternType extends TypeAbstractChoice<PatternType>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static TypePatternType i = new TypePatternType();
	public static TypePatternType get() { return i; }
	public TypePatternType()
	{
		super(PatternType.class);
		List<PatternType> all = new ArrayList<>();
		Registry.BANNER_PATTERN.forEach(all::add);
		this.setAll(all);
	}

	@Override
	public String getNameInner(PatternType value)
	{
		return Txt.getNicedEnumString(value.getKey().getKey());
	}

	@Override
	public String getIdInner(PatternType value)
	{
		return value.getKey().getKey();
	}

}
