package com.reasure.hgmod.Utill;

import com.reasure.hgmod.HgMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_HG_TOOL = createTag("needs_hg_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(HgMod.MOD_ID, name));
        }
    }
        public static class Items {
            public static final TagKey<Item> HG_ITEMS = createTag("hg_Items");

            private static TagKey<Item> createTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(HgMod.MOD_ID, name));
            }
        }
}


