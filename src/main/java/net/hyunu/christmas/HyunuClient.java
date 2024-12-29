package net.hyunu.christmas;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.hyunu.christmas.client.ThirstHudOverlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyunuClient implements ClientModInitializer {
    public static final String MOD_ID = "hyunu";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Hello Fabric world!");

        HudRenderCallback.EVENT.register(new ThirstHudOverlay());
    }
}
