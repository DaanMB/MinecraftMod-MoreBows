package io.github.daandolfijn.morebows;

import io.github.daandolfijn.morebows.creativemodetab.ModCreativeModeTabs;
import io.github.daandolfijn.morebows.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoreBows implements ModInitializer {
	public static final String MOD_ID = "morebows";
	public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();
	}
}