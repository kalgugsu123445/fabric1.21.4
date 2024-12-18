package com.reasure.hgmod.item;

import com.reasure.hgmod.HgMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item  HG_GEMSTONE = registerSimpleItem("hg_gemstone", new Item.Settings());
    public static final Item  HG_FRAGMENT = registerSimpleItem("hg_fragment", new Item.Settings());

    public static final Item HG_SWORD = registerSword("hg_sword", ModToolMaterials.MY_MATERIAL, 7, -2.4F);


    public static <T extends Item> T register(String name, Item.Settings settings, Function<Item.Settings, T> item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HgMod.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, item.apply(settings.registryKey(key)));
    }


    public static Item registerSimpleItem(String name, Item.Settings settings) {
        return register(name, settings, Item::new);
    }

    // 무기 등록
    public static Item registerSword(String name, ToolMaterial material, int attackDamage, float attackSpeed) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(HgMod.MOD_ID, name),
                new SwordItem(material, attackDamage, attackSpeed, new Item.Settings())
        );
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(itemGroup -> {
                    itemGroup.add(ModItems.HG_GEMSTONE);
                    itemGroup.add(ModItems.HG_FRAGMENT);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(itemGroup -> {
                    itemGroup.add(ModItems.HG_SWORD);
                });


    }
}
