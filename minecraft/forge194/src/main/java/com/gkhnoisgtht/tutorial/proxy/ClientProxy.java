package com.gkhnoisgtht.tutorial.proxy;

import com.gkhnoisgtht.tutorial.init.ModItems;

public class ClientProxy implements CommonProxy{

	@Override
	public void init() {
		ModItems.registerRenders();
	}

}
