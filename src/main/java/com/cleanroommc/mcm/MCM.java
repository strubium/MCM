package com.cleanroommc.mcm;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.cleanroommc.mcm.ModRef.ID;
import static com.cleanroommc.mcm.ModRef.NAME;
import static com.cleanroommc.mcm.ModRef.VERSION;

@Mod(modid = ModRef.MODID, name = ModRef.NAME, version = ModRef.VERSION)
public class MCM {

    @EventHandler
    public void preInit(FMLPreInitializationEvent preInitializationEvent) {
    }

    @EventHandler
    public void init(FMLInitializationEvent initializationEvent) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent postInitializationEvent) {
    }
}
