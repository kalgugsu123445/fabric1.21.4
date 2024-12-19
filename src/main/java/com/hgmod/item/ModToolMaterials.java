package com.hgmod.item;

import com.hgmod.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ModToolMaterials {
    public static final ToolMaterial MY_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, // incorrectBlocksForDrops
            225,                               // durability
            7.0f,                              // speed,
            1.0f,                              // attackDamageBonus
            10,                                 // enchantmentValue
                                                // repairItems
            ModTags.Items.HG_REPAIR_ITEMS
    );
}