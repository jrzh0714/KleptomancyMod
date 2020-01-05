package com.jrzh.Kleptomancy.setup;
import com.jrzh.Kleptomancy.blocks.Modblocks;

import com.jrzh.Kleptomancy.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class ModSetup {
    public ItemGroup itemGroup = new ItemGroup("kleptomancy") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.KLEPTORUNE);
        }
    };

    public void init(){

    }
}
