package net.hyunu.christmas.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hyunu.christmas.Hyunu;
import net.hyunu.christmas.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CHRISTMAS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Hyunu.MOD_ID,"christmas"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.christmas"))
                    .icon(() -> new ItemStack(ModItems.HyunuCookie)).entries((displayContext, entries) -> {
                        entries.add(ModItems.HyunuCookie);
                        entries.add(ModItems.RawStar);
                        entries.add(ModItems.MuiBurger);
                        entries.add(ModItems.CucumberDog);
                        entries.add(ModBlocks.MINJUN_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        Hyunu.LOGGER.info("Registering Item Groups for " + Hyunu.MOD_ID);
    }
}
