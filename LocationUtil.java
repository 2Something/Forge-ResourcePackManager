package com.somethingdev.armora.util;

import net.minecraft.resources.ResourceLocation;

public class LocationUtil {
    private final String ID;

    public LocationUtil(String id) {
        this.ID = id;
    }

    public ResourceLocation block(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, "block/"+path);
    }
    public ResourceLocation item(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, "item/"+path);
    }
}
