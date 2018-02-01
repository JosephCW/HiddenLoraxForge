package com.josephcw.hiddenloraxforge.proxy;

import java.util.HashSet;

import com.josephcw.hiddenloraxforge.events.SaplingDroppedEventHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {

    }

    public void init(FMLInitializationEvent e) {
    	
    }

    public void postInit(FMLPostInitializationEvent e) {
    	SaplingDroppedEventHandler.allowedSet = new HashSet<String>();
    	
    	SaplingDroppedEventHandler.allowedSet.add("minecraft:sapling");
    }
}
