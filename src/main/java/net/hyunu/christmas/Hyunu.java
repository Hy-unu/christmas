package net.hyunu.christmas;

import net.fabricmc.api.ModInitializer;
import net.hyunu.christmas.block.ModBlocks;
import net.hyunu.christmas.item.ModItemGroups;
import net.hyunu.christmas.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hyunu implements ModInitializer {
	public static final String MOD_ID = "hyunu";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}