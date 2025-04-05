package com.somethingdev.armora.util;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ArmorTuple {
    public final RegistryObject<Item> HELMET;
    public final RegistryObject<Item> CHESTPLATE;
    public final RegistryObject<Item> LEGGINGS;
    public final RegistryObject<Item> BOOTS;
    public ArmorTuple(RegistryObject<Item> helmet, RegistryObject<Item> chestplate, RegistryObject<Item> leggings, RegistryObject<Item> boots) {
        this.HELMET = helmet;
        this.CHESTPLATE = chestplate;
        this.LEGGINGS = leggings;
        this.BOOTS = boots;
    }
}
