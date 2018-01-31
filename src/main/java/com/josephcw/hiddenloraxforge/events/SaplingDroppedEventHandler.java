package com.josephcw.hiddenloraxforge.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class SaplingDroppedEventHandler {
	@SubscribeEvent
	public static void itemExpires(ItemExpireEvent e) {
		
		
		EntityItem expiringItem = e.getEntityItem();
		if (expiringItem.onGround) {
			
			ItemStack droppedItemStack = expiringItem.getItem();
			Item singleItem = droppedItemStack.getItem();
			String itemName2 = singleItem.getRegistryName().toString();
			String itemName3 = droppedItemStack.getDisplayName();
			String itemName4 = droppedItemStack.getUnlocalizedName();
			System.out.println("2: " + itemName2);
			System.out.println("3: " + itemName3);
			System.out.println("4: " + itemName4);
			
			// item.unlocalized = item.sapling
			// item.registryName.toString = minecraft:sapling
			// itemStack.getDisplaynaem = oaksapling
			// itemStack.getUnlocalizedName = tile.sapling.oak
		}
	}
	
}
