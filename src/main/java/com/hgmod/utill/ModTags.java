package com.hgmod.utill;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> BLOCK_HG_TOOL = createTag("block_hg_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("hgmod", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HG_REPAIR_ITEMS = createTag("hg_repair_items");
        public static final TagKey<Item> HG_GEMSTONE = createTag("hg_gemstone");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("hgmod", name));
        }
    }
}