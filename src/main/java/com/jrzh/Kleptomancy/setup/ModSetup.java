package com.jrzh.Kleptomancy.setup;
import com.jrzh.Kleptomancy.blocks.Modblocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class ModSetup {
    public ItemGroup itemGroup = new ItemGroup("kleptomancy") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Modblocks.KLEPTOBLOCK);
        }
    };

    public void init(){

    }
}
