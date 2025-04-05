package com.somethingdev.armora.util;


import net.minecraft.item.Item;

public class ArmorTuple {
    public final Item HELMET;
    public final Item CHESTPLATE;
    public final Item LEGGINGS;
    public final Item BOOTS;
    public ArmorTuple(Item helmet, Item chestplate, Item leggings, Item boots) {
        this.HELMET = helmet;
        this.CHESTPLATE = chestplate;
        this.LEGGINGS = leggings;
        this.BOOTS = boots;
    }
}
