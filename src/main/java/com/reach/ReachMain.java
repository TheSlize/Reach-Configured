package com.reach;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod(
        modid = ReachMain.MOD_ID,
        name = ReachMain.MOD_NAME,
        version = ReachMain.VERSION
)
public class ReachMain {

    public static final String MOD_ID = "reach";
    public static final String MOD_NAME = "Reach Configured";
    public static final String VERSION = "1.12.2-1.0";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static ReachMain INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */

    @SidedProxy(clientSide = "com.reach.ClientProxy", serverSide = "com.reach.ServerProxy")
    public static ServerProxy proxy;


    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ModEventHandler());
        reloadConfig();
    }

    public static void reloadConfig() {
        Configuration config = new Configuration(new File(proxy.getDataDir().getPath() + "/config/reachConfig.cfg"));
        config.load();
        CommonConfig.loadFromConfig(config);
        config.save();
    }
}
