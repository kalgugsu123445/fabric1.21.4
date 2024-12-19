package com.hgmod.item;

import com.hgmod.HgMod;
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

    public static final Item HG_SWORD = registerSword("hg_sword", ModToolMaterials.MY_MATERIAL, 3,  -1.8F);
    public static final Item HG_PICKAXE = registerPickaxe("hg_pickaxe", ModToolMaterials.MY_MATERIAL, -2, -2.8F);
    public static final Item HG_AXE = registerAxe("hg_axe", ModToolMaterials.MY_MATERIAL, 9, -3.8F);
    public static final Item HG_SHOVEL = registerShovel("hg_shovel", ModToolMaterials.MY_MATERIAL, 1, -3.0F);
    public static final Item HG_HOE = registerHoe("hg_hoe", ModToolMaterials.MY_MATERIAL, 0, 5.0F);


    public static <T extends Item> T register(String name, Item.Settings settings, Function<Item.Settings, T> item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HgMod.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, item.apply(settings.registryKey(key)));
    }


    public static Item registerSimpleItem(String name, Item.Settings settings) {
        return register(name, settings, Item::new);
    }

    // 무기 등록
    public static Item registerSword(String name, ToolMaterial material, int attackDamage, float attackSpeed) {
        return register(name, new Item.Settings(),
                settings -> new SwordItem(material, attackDamage, attackSpeed, settings));
    }
    public static Item registerPickaxe(String name, ToolMaterial material, int attackDamage, float attackSpeed) {
        return register(name, new Item.Settings(),
                settings -> new PickaxeItem(material, attackDamage, attackSpeed, settings));
    }
    public static Item registerAxe(String name, ToolMaterial material, int attackDamage, float attackSpeed) {
        return register(name, new Item.Settings(),
                settings -> new AxeItem(material, attackDamage, attackSpeed, settings));
    }
    public static Item registerShovel(String name, ToolMaterial material, int attackDamage, float attackSpeed) {
        return register(name, new Item.Settings(),
                settings -> new ShovelItem(material, attackDamage, attackSpeed, settings));
    }
    public static Item registerHoe(String name, ToolMaterial material, int attackDamage, float attackSpeed) {
        return register(name, new Item.Settings(),
                settings -> new HoeItem(material, attackDamage, attackSpeed, settings));
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
                    itemGroup.add(ModItems.HG_PICKAXE);
                    itemGroup.add(ModItems.HG_AXE);
                    itemGroup.add(ModItems.HG_SHOVEL);
                    itemGroup.add(ModItems.HG_HOE);
                });


    }
}

