package com.somethingdev.armora.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class OreTuple {
    public final RegistryObject<Item> SMELTED;
    public final RegistryObject<Item> RAW;
    public final RegistryObject<Block> ORE;
    public OreTuple(RegistryObject<Item> smelted, RegistryObject<Item> raw, RegistryObject<Block> ore) {
        this.SMELTED = smelted;
        this.RAW = raw;
        this.ORE = ore;
    }
}
