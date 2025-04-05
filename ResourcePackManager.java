package com.tutorial.mod;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Objects;
import java.util.function.Consumer;

//To add a resource pack,
// you must put your resource pack FOLDER into a resourcepacks/ folder in the resources package
// Then call `ResourcePackManager.registerOptionalResourcePack` in your mod's main method (where you register your Mod Buses)

//As an additional note, required resource packs will be loaded before optional ones, and they cannot be disabled by the user.


// ALL CREDIT OF THIS CLASS GOES TO MOONLIGHT LIB, AND THE OFFICIAL MINECRAFT FORGE GITHUB
// (I simply ported it into a class, and made some feature tweaks)
// Moonlight Lib: https://github.com/MehVahdJukaar/Moonlight/
// Forge Class: https://github.com/MinecraftForge/MinecraftForge/blob/1.19.x/src/test/java/net/minecraftforge/debug/AddPackFinderEventTest.java

public class ResourcePackManager {
    private final String ID;
    private final IEventBus bus;
    private final Logger log;

    private void registerPack(@NotNull String resourcePackIdentifier, @NotNull Component resourcePackTitle, Boolean optional, PackSource source) {
        var file = ModList.get().getModFileById(this.ID).getFile();
        try (PathPackResources pack = new PathPackResources(
                resourcePackIdentifier,
                file.findResource("resourcepacks/"+resourcePackIdentifier),
                true
        )) {
            var metadata = Objects.requireNonNull(pack.getMetadataSection(PackMetadataSection.TYPE), "Missing pack.mcmeta for pack " + resourcePackTitle);
            var optionalPack = Pack.create(
                    resourcePackIdentifier,
                    resourcePackTitle,
                    !optional,
                    (s) -> pack,
                    new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                    PackType.CLIENT_RESOURCES,
                    Pack.Position.TOP,
                    false,
                    source);
            Consumer<AddPackFindersEvent> resourcePackConsumer = event -> event.addRepositorySource((packConsumer) -> packConsumer.accept(optionalPack));

            this.bus.addListener(resourcePackConsumer);
        } catch (Exception ee) {
            this.log.error(ee.getMessage());
        }
    }

    public ResourcePackManager(@NotNull String ID, @NotNull IEventBus bus, @NotNull Logger log) {
        this.ID = ID;
        this.bus = bus;
        this.log = log;
    }

    public void registerOptionalResourcePack(@NotNull String resourcePackIdentifier, @NotNull Component resourcePackTitle) {
        registerPack(resourcePackIdentifier,resourcePackTitle, true, PackSource.BUILT_IN);
    }

    public void registerRequiredResourcePack(@NotNull String resourcePackIdentifier, @NotNull Component resourcePackTitle) {
        registerPack(resourcePackIdentifier,resourcePackTitle, false, PackSource.BUILT_IN);
    }
}
