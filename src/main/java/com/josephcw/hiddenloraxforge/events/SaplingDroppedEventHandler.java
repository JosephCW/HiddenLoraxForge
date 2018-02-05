package com.josephcw.hiddenloraxforge.events;

import java.util.HashSet;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class SaplingDroppedEventHandler {
	
	public static HashSet<String> allowedSet;
	
	@SubscribeEvent
	public static void itemExpires(ItemExpireEvent e) {
		ItemStack itemStack = getItemStack(e);
		Item singleItem = itemStack.getItem();
		if (isAllowedItem(singleItem)) {
			if (isPlantableLocation(itemStack, e)) {
				plantItem(itemStack, e);
			}
		}
	}
	
	private static ItemStack getItemStack(ItemExpireEvent e) {
		EntityItem expiringItem = e.getEntityItem();
		ItemStack droppedItemStack = expiringItem.getItem();
		return droppedItemStack;
	}
	
	private static boolean isAllowedItem(Item item) {
		String registryName = item.getRegistryName().toString();
		return allowedSet.contains(registryName);
	}
	
	private static boolean isPlantableLocation(ItemStack itemStack, ItemExpireEvent e) {
		// Get the xyz position of our dropped item stack
		Entity entityItemStack = e.getEntity();
		World eventWorld = e.getEntity().getEntityWorld();
		BlockPos itemPosition = entityItemStack.getPosition();
		// Subtract y by one to get the position of the block the item is on
		BlockPos onePosUnder = itemPosition.subtract(new Vec3i(0, 1, 0));
		// get the block and its name
		Block blockOn = eventWorld.getBlockState(onePosUnder).getBlock();
		String blockOnRegName = blockOn.getRegistryName().toString();
		return (blockOnRegName.equals("minecraft:grass") 
				|| blockOnRegName.equals("minecraft:dirt"));
	}
	
	private static void plantItem(ItemStack itemStack, ItemExpireEvent e) {
		World eventWorld = e.getEntity().getEntityWorld();
		BlockPos itemPosition = e.getEntity().getPosition();
		// Get the block that we will replace the expring item with
		Block replaceBlock = Block.getBlockFromItem(itemStack.getItem());
		// Get the metadata of the item, apply it to the block.
		IBlockState blockState = replaceBlock.getStateFromMeta(itemStack.getMetadata());
		eventWorld.setBlockState(itemPosition, blockState);
	}
}
