package com.gkhnoisgtht.tutorial;

public class References {
	public static final String MOD_ID = "gtm";
	public static final String NAME = "Gkhnoisgtht's Tutorial Mod";
	public static final String VERSION = "0.1";
	public static final String ACCEPTED_VERSTIONS = "[1.9.4]";
	
	public static final String CLIENT_PROXY_CLASS = "com.gkhnoisgtht.tutorial.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.gkhnoisgtht.tutorial.proxy.ServerProxy";
	
	public static enum TutorialItems {
		CHEESE("cheese", "ItemCheese");
		
		private String unlocalizedName;
		private String registryName;
		
		TutorialItems(String unlocalizedName, String registeryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registeryName;
		}
		
		public String getUnlocalizedName(){
			return unlocalizedName;
		}
		
		public String getRegistryName(){
			return registryName;
		}
	}
}
