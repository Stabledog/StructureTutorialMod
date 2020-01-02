package com.telepathicgrunt.structuretutorial;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.telepathicgrunt.structuretutorial.world.features.FeatureInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StructureTutorialMain.MODID)
public class StructureTutorialMain
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    
    //mod ID to reference to from anywhere in mod
	public static final String MODID = "structure_tutorial";

    public StructureTutorialMain() 
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }
    

    /*
     * This is where you do all the manipulation and startup things you need to do for your mod.
     * What is actually done here will be different for each mod depending on what they are doing.
     * 
     * Here, we will use this to add our structure to all biomes.
     */
	public void setup(final FMLCommonSetupEvent event) 
	{
		//Add our structure to all biomes including other modded biomes
		//
		//You can filter to certain biomes based on stuff like temperature, scale, precipitation, mod id, 
		//and if you use the BiomeDictionary, you can even check if the biome has certain tags like swamp or snowy.
		for (Biome biome: ForgeRegistries.BIOMES) 
		{
			//this is .addStructure (name is not mapped yet). 
			//All structures needs to be added by .addStructure AND .addFeature.
			//
			//In vanilla, all biomes has all structures added by .addFeature but the biomes that
			//can actually spawn the structure will have it added with .func_226711_a_ as well.
			biome.func_226711_a_(Feature.STRONGHOLD.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.STRONGHOLD.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG).func_227228_a_(Placement.NOPE.func_227446_a_(IPlacementConfig.NO_PLACEMENT_CONFIG))); 
        }
		
	}
	
	
    // You can use EventBusSubscriber to automatically subscribe events on the contained class 
	// (this is subscribing to the MOD Event bus for receiving Registry Events)
	
	/*
	 * You will use this to register anything for your mod. The most common things
	 * you will register are blocks, items, biomes, entities, and dimensions.
	 */
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents 
    {
    	
		/**
		 * This method will be called by Forge when it is time for the mod to register features.
		 */
		@SubscribeEvent
		public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event) 
		{
			//registers the feature part of structures.
			//If you don't do this, you'll crash. fun times right? lol
			FeatureInit.registerFeatures(event);
			
			
			LOGGER.log(Level.INFO, "features/structures registered.");
		}
    }
}