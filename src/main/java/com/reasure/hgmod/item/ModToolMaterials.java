package com.reasure.hgmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class ModToolMaterials {
    public static final ToolMaterial MY_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, // incorrectBlocksForDrops
            250,                               // durability
            4.0f,                              // speed,
            2.0f,                              // attackDamageBonus
            5,                                 // enchantmentValue
            ItemTags.IRON_TOOL_MATERIALS       // repairItems
    );
}
