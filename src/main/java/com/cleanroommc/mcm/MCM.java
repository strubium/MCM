package com.cleanroommc.mcm;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = ModRef.MODID, name = ModRef.NAME, version = ModRef.VERSION)
public class MCM {

    @EventHandler
    public void preInit(FMLPreInitializationEvent preInitializationEvent) {
        commonProxy.preInit(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent initializationEvent) {
        MWCRecipes.register();
        commonProxy.init(this);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent postInitializationEvent) {
        commonProxy.postInit(this, postInitializationEvent);
    }
}
