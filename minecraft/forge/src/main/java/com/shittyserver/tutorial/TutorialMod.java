package com.shittyserver.tutorial;

import com.shittyserver.tutorial.blocks.BlockTable;
import com.shittyserver.tutorial.items.ItemTable;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "TM", name = "Tutorial Mod", version = "1.0")
public class TutorialMod {
	
	public static Item itemTable;
	public static Block blockTable;
	public static Item itemCheese;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// Item/Block init and registration
		//config handling
		itemTable = new ItemTable().setUnlocalizedName("ItemTable").setTextureName("TM:ItemTable");
		blockTable = new BlockTable(Material.cloth).setBlockName("BlockTable").setBlockTextureName("TM:BlockTable");
		itemCheese = new ItemFood(20, 1.0f, false).setUnlocalizedName("ItemCheese");
		
		
		GameRegistry.registerItem(itemTable, itemTable.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockTable, blockTable.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCheese, itemCheese.getUnlocalizedName().substring(5));
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		// Proxy, Tile Entity, entity, GUI, Packet Registration
		GameRegistry.addRecipe(new ItemStack(itemTable, 20), new Object[]{"www", " w "," w ", 'w', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(blockTable), new Object[]{"crc", "rrr","crc", 'c', Items.coal, 'r', Items.redstone});

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}