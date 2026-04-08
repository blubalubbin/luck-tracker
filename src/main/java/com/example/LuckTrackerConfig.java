package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
@ConfigGroup("lucktracker")
public interface LuckTrackerConfig extends Config
{
	@ConfigItem(
		keyName = "trackLuck",
		name = "Track Luck",
		description = "Enable luck tracking for drops"
	)
	default boolean trackLuck()
	{
		return true;
	}
}
