package com.massivecraft.massivecore.command.type.enumeration;

import com.massivecraft.massivecore.command.type.TypeAbstractChoice;
import com.massivecraft.massivecore.util.Txt;
import org.bukkit.Registry;
import org.bukkit.entity.Villager.Profession;

import java.util.ArrayList;
import java.util.List;

public class TypeVillagerProfession extends TypeAbstractChoice<Profession>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static TypeVillagerProfession i = new TypeVillagerProfession();
	public static TypeVillagerProfession get() { return i; }
	public TypeVillagerProfession()
	{
		super(Profession.class);
		List<Profession> all = new ArrayList<>();
		Registry.VILLAGER_PROFESSION.forEach(all::add);
		this.setAll(all);
	}

	@Override
	public String getNameInner(Profession value)
	{
		return Txt.getNicedEnumString(value.getKey().getKey());
	}

	@Override
	public String getIdInner(Profession value)
	{
		return value.getKey().getKey();
	}

}
