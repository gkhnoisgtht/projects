package com.gkhnoisgtht.tutorial;

import com.gkhnoisgtht.tutorial.blocks.ItemBlock;
import com.gkhnoisgtht.tutorial.init.ModItems;
import com.gkhnoisgtht.tutorial.items.ItemTable;
import com.gkhnoisgtht.tutorial.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = References.MOD_ID, version = References.VERSION, name = References.NAME, acceptedMinecraftVersions = References.ACCEPTED_VERSTIONS)
public class Tutorial
{     
    @Instance
    public static Tutorial instance;
    
    @SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    
    @EventHandler
    public void postInit(FMLPreInitializationEvent event)
    {
    	ModItems.init();
    	ModItems.register();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
    	proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // some example code
    }
    
}
