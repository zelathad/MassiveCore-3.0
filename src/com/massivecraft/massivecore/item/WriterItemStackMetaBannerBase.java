package com.massivecraft.massivecore.item;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class WriterItemStackMetaBannerBase extends WriterAbstractItemStackMetaField<BannerMeta, Integer, DyeColor>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static final WriterItemStackMetaBannerBase i = new WriterItemStackMetaBannerBase();
	public static WriterItemStackMetaBannerBase get() { return i; }
	public WriterItemStackMetaBannerBase()
	{
		super(BannerMeta.class);
		this.setMaterial(Material.WHITE_BANNER);
		this.setConverterTo(ConverterToDyeColor.get());
		this.setConverterFrom(ConverterFromDyeColor.get());
	}
	
	// -------------------------------------------- //
	// ACCESS
	// -------------------------------------------- //

	@Override
	public Integer getA(DataItemStack ca, ItemStack d)
	{
		return ca.getBannerBase();
	}

	@Override
	public void setA(DataItemStack ca, Integer fa, ItemStack d)
	{
		ca.setBannerBase(fa);
	}

	@Override
	public DyeColor getB(BannerMeta cb, ItemStack d)
	{
		// Base color is now encoded in the item Material type (e.g. RED_BANNER) since 1.13.
		return null;
	}

	@Override
	public void setB(BannerMeta cb, DyeColor fb, ItemStack d)
	{
		// Base color is now encoded in the item Material type since 1.13; cannot be set via BannerMeta.
	}
	
}
