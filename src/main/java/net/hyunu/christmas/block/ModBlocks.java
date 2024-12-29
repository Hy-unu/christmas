package net.hyunu.christmas.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hyunu.christmas.Hyunu;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block MINJUN_BLOCK = registerBlock("minjun_block",
        new Block(FabricBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            )
        );

    private static void addItemsToBuildingBlocksTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(MINJUN_BLOCK);
    };

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Hyunu.MOD_ID,name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Hyunu.MOD_ID,name),
            new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Hyunu.LOGGER.info("Registering Mod Blocks for " + Hyunu.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlocksTabItemGroup);
    }
}
