# ResourcePackManager

This gives you an easy way to add built-in resource packs </br>

Add [this class](ResourcePackManager.java) to your util folder or namespace</br>
and then reference it in your mod's main class

```java
package com.example.mod

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.network.chat.Component;
import com.example.mod.util.ResourcePackManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod(TutorialMod.ID)
public class TutorialMod
{
    public static final String ID = "tutorialmod";
    public static final Logger log = LoggerFactory.getLogger(ID);

    public Armora(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ResourcePackManager resourceManager = new ResourcePackManager(ID,modEventBus,log);

        resourceManager.registerOptionalResourcePack( // Registers a resource pack that is togglable
            "tutorial_optional_pack",  // (String) The name of the resource pack folder in resourcepacks/*
            Component.literal("Tutorial Optional Pack")  // (Component) The title of the resource pack
        );

        resourceManager.registerRequiredResourcePack( // Registers resource pack that can't be disabled.
            "tutorial_required_pack",  // (String) The name of the resource pack folder in resourcepacks/*
            Component.literal("Tutorial AlwaysOn Pack")  // (Component) The title of the resource pack
        );
    }       
}
```
