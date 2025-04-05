package com.somethingdev.armora.util;


import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class OreTuple {
    public final Item SMELTED;
    public final Item RAW;
    public final Block ORE;
    public OreTuple(Item smelted, Item raw, Block ore) {
        this.SMELTED = smelted;
        this.RAW = raw;
        this.ORE = ore;
    }
}
