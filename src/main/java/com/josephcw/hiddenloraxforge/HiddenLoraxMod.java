package com.josephcw.hiddenloraxforge;

import com.josephcw.hiddenloraxforge.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HiddenLoraxMod.modId, name = HiddenLoraxMod.name, version = HiddenLoraxMod.version, acceptedMinecraftVersions = "[1.12]")
public class HiddenLoraxMod {

	public static final String modId = "hiddenlorax";
	public static final String name = "Hidden Lorax";
	public static final String version = "0.0.1";

	@Mod.Instance(modId)
	public static HiddenLoraxMod instance;

	@SidedProxy(serverSide="net.josephwatts.hiddenloraxforge.proxy.CommonProxy", clientSide="net.josephwatts.hiddenloraxforge.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
	
}