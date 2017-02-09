package com.gkhnoisgtht.tutorial.init;

import com.gkhnoisgtht.tutorial.References;
import com.gkhnoisgtht.tutorial.items.ItemCheese;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item cheese;
	
	public static void init(){
		cheese = new ItemCheese();
	}
	
	public static void register(){
		GameRegistry.register(cheese);
	}
	
	public static void registerRenders(){
		registerRender(cheese);
	}
	
	private static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
