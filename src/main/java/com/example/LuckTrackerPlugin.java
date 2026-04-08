package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.LootReceived;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import okhttp3.OkHttpClient;

@Slf4j
@PluginDescriptor(
       name = "Luck Tracker"
)
public class LuckTrackerPlugin extends Plugin
{
       @Inject
       private Client client;

       @Inject
       private LuckTrackerConfig config;

       // Placeholder for HTTP client (for wiki lookups)
       @Inject
       private OkHttpClient okHttpClient;

       @Override
       protected void startUp() throws Exception
       {
	       log.debug("Luck Tracker started!");
       }

       @Override
       protected void shutDown() throws Exception
       {
	       log.debug("Luck Tracker stopped!");
       }

       /**
	* Listen for loot events and process drops.
	* TODO: Integrate drop logging and drop rate lookup.
	*/
       @Subscribe
       public void onLootReceived(LootReceived event)
       {
	       // TODO: Lookup drop rates using wiki (see WikiScraper in loot-lookup-plugin)
	       // TODO: Log drop and probability (see LTRecord/LTItemEntry in Loot Logger)
	       log.debug("Received loot: {}", event);
       }

       @Provides
       LuckTrackerConfig provideConfig(ConfigManager configManager)
       {
	       return configManager.getConfig(LuckTrackerConfig.class);
       }
}
