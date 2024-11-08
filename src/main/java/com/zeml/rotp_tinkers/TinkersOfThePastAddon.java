package com.zeml.rotp_tinkers;


import com.zeml.rotp_tinkers.init.JojoBlocks;
import com.zeml.rotp_tinkers.init.JojoFluids;
import com.zeml.rotp_tinkers.modifiers.JojoModifiers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// Your addon's main file

@Mod(TinkersOfThePastAddon.MOD_ID)
public class TinkersOfThePastAddon {

    public static final String MOD_ID = "rotp_tinkers";
    public static final Logger LOGGER = LogManager.getLogger();

    public TinkersOfThePastAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        JojoFluids.FLUIDS.register(modEventBus);
        JojoBlocks.BLOCKS.register(modEventBus);
        JojoModifiers.MODIFIERS.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);

    }


    private void doClientStuff(final FMLClientSetupEvent event){
        event.enqueueWork(()->{

        });
    }
}
