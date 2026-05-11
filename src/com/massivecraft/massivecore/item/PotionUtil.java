package com.massivecraft.massivecore.item;

import com.massivecraft.massivecore.xlib.guava.collect.BiMap;
import com.massivecraft.massivecore.xlib.guava.collect.ImmutableBiMap;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

@SuppressWarnings("deprecation")
public class PotionUtil
{
	public static PotionData toPotionData(int damage)
	{
		// Potion class was removed in 1.13; numeric damage → PotionType mapping no longer applies.
		return null;
	}
	
	public static PotionData toPotionData(String potionString)
	{
		if (potionString == null) return null;
		return POTION_ID_TO_DATA.get(potionString);
	}
	
	public static String toPotionString(PotionData potionData)
	{
		if (potionData == null) return null;
		return POTION_ID_TO_DATA.inverse().get(potionData);
	}
	
	private static final BiMap<String, PotionData> POTION_ID_TO_DATA = ImmutableBiMap.<String, PotionData>builder()
		// REGULAR
		.put("empty", new PotionData(PotionType.MUNDANE, false, false))
		.put("water", new PotionData(PotionType.WATER, false, false))
		.put("mundane", new PotionData(PotionType.MUNDANE, false, false))
		.put("thick", new PotionData(PotionType.THICK, false, false))
		.put("awkward", new PotionData(PotionType.AWKWARD, false, false))
		.put("night_vision", new PotionData(PotionType.NIGHT_VISION, false, false))
		.put("invisibility", new PotionData(PotionType.INVISIBILITY, false, false))
		.put("leaping", new PotionData(PotionType.LEAPING, false, false))
		.put("fire_resistance", new PotionData(PotionType.FIRE_RESISTANCE, false, false))
		.put("swiftness", new PotionData(PotionType.SWIFTNESS, false, false))
		.put("slowness", new PotionData(PotionType.SLOWNESS, false, false))
		.put("water_breathing", new PotionData(PotionType.WATER_BREATHING, false, false))
		.put("healing", new PotionData(PotionType.HEALING, false, false))
		.put("harming", new PotionData(PotionType.HARMING, false, false))
		.put("poison", new PotionData(PotionType.POISON, false, false))
		.put("regeneration", new PotionData(PotionType.REGENERATION, false, false))
		.put("strength", new PotionData(PotionType.STRENGTH, false, false))
		.put("weakness", new PotionData(PotionType.WEAKNESS, false, false))
		.put("luck", new PotionData(PotionType.LUCK, false, false))
		
		// UPGRADABLE
		.put("strong_leaping", new PotionData(PotionType.LEAPING, false, true))
		.put("strong_swiftness", new PotionData(PotionType.SWIFTNESS, false, true))
		.put("strong_healing", new PotionData(PotionType.HEALING, false, true))
		.put("strong_harming", new PotionData(PotionType.HARMING, false, true))
		.put("strong_poison", new PotionData(PotionType.POISON, false, true))
		.put("strong_regeneration", new PotionData(PotionType.REGENERATION, false, true))
		.put("strong_strength", new PotionData(PotionType.STRENGTH, false, true))
		
		// EXTENDABLE
		.put("long_night_vision", new PotionData(PotionType.NIGHT_VISION, true, false))
		.put("long_invisibility", new PotionData(PotionType.INVISIBILITY, true, false))
		.put("long_leaping", new PotionData(PotionType.LEAPING, true, false))
		.put("long_fire_resistance", new PotionData(PotionType.FIRE_RESISTANCE, true, false))
		.put("long_swiftness", new PotionData(PotionType.SWIFTNESS, true, false))
		.put("long_slowness", new PotionData(PotionType.SLOWNESS, true, false))
		.put("long_water_breathing", new PotionData(PotionType.WATER_BREATHING, true, false))
		.put("long_poison", new PotionData(PotionType.POISON, true, false))
		.put("long_regeneration", new PotionData(PotionType.REGENERATION, true, false))
		.put("long_strength", new PotionData(PotionType.STRENGTH, true, false))
		.put("long_weakness", new PotionData(PotionType.WEAKNESS, true, false))
	
	// BUILD
	.build();
	
}
