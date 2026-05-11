package com.massivecraft.massivecore.nms;

import com.massivecraft.massivecore.util.IdUtil;
import com.massivecraft.massivecore.xlib.gson.JsonObject;
import com.massivecraft.massivecore.xlib.gson.JsonParser;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;

import java.time.Duration;

public class NmsChat121P extends NmsChat
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static NmsChat121P i = new NmsChat121P();
	public static NmsChat121P get() { return i; }

	// -------------------------------------------- //
	// PROVOKE
	// -------------------------------------------- //
	// Paper 1.16+ bundles the Adventure API. We probe for Player#sendActionBar(Component).
	// On plain Spigot (no Adventure) this method does not exist and the Mixin system
	// falls back to the NMS-based implementations.

	@Override
	public Object provoke() throws Throwable
	{
		return Player.class.getMethod("sendActionBar", Component.class);
	}

	// -------------------------------------------- //
	// TITLE
	// -------------------------------------------- //

	@Override
	public void sendTitleRaw(Object sendeeObject, int ticksIn, int ticksStay, int ticksOut, String rawMain, String rawSub)
	{
		Player player = IdUtil.getPlayer(sendeeObject);
		if (player == null) return;

		Component main = fromRaw(rawMain);
		Component sub  = fromRaw(rawSub);

		Title.Times times = Title.Times.times(
			Duration.ofMillis(ticksIn   * 50L),
			Duration.ofMillis(ticksStay * 50L),
			Duration.ofMillis(ticksOut  * 50L)
		);

		player.showTitle(Title.title(main, sub, times));
	}

	// -------------------------------------------- //
	// ACTION BAR
	// -------------------------------------------- //

	@Override
	public void sendActionbarRaw(Object sendeeObject, String raw)
	{
		Player player = IdUtil.getPlayer(sendeeObject);
		if (player == null) return;

		player.sendActionBar(fromRaw(raw));
	}

	// -------------------------------------------- //
	// UTIL
	// -------------------------------------------- //
	// MassiveCore packs text as {"text":"§aHello"}.
	// We extract the legacy-color string and convert it to an Adventure Component.

	private static Component fromRaw(String raw)
	{
		if (raw == null) return Component.empty();
		try
		{
			JsonObject obj = JsonParser.parseString(raw).getAsJsonObject();
			String legacy = obj.get("text").getAsString();
			return LegacyComponentSerializer.legacySection().deserialize(legacy);
		}
		catch (Exception e)
		{
			return LegacyComponentSerializer.legacySection().deserialize(raw);
		}
	}

}
