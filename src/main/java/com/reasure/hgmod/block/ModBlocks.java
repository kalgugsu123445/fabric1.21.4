package com.reasure.hgmod.block;

import com.reasure.hgmod.HgMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block HG_ORE_BLOCK = registerSimpleBlock("hg_ore_block", AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SOLID_HG_BLOCK = registerSimpleBlock("solid_hg_block", AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE));
    public static final Block ADJECTIVE_HG_BLOCK = registerSimpleBlock("adjective_hg_block", AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRYSTAL_HG_BLOCK = registerSimpleBlock("crystal_hg_block", AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE));

    public static <T extends Block> T register(String name, boolean shouldRegisterItem, Block.Settings settings, Function<Block.Settings, T> block) {
        Identifier id = Identifier.of(HgMod.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        T registerBlock = block.apply(settings.registryKey(key));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
            BlockItem blockItem = new BlockItem(registerBlock, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, key, registerBlock);
    }

    public static Block registerSimpleBlock(String name, Block.Settings settings) {
        return register(name, true, settings, Block::new);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(itemGroup -> {
                    itemGroup.add(ModBlocks.HG_ORE_BLOCK);
                    itemGroup.add(ModBlocks.SOLID_HG_BLOCK);
                    itemGroup.add(ModBlocks.ADJECTIVE_HG_BLOCK);
                    itemGroup.add(ModBlocks.CRYSTAL_HG_BLOCK);
                });
    }
}


