package net.hyunu.christmas;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.hyunu.christmas.client.MoneyHudOverlay;
import net.hyunu.christmas.util.IEntityDataSaver;
import net.hyunu.christmas.util.MoneyData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyunuClient implements ClientModInitializer {
    public static final String MOD_ID = "hyunu";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Hello Fabric world!");
        HudRenderCallback.EVENT.register(new MoneyHudOverlay());
    }
}
