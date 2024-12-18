package com.reasure.hgmod;

import com.reasure.hgmod.block.ModBlocks;
import com.reasure.hgmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HgMod implements ModInitializer {

	public static final String MOD_ID = "hgmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModBlocks.initialize();
	}
}