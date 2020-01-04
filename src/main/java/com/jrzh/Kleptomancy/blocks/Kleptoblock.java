package com.jrzh.Kleptomancy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Kleptoblock extends Block {
    public Kleptoblock() {
        super(Block.Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
                .lightValue(14)
        );
        setRegistryName("kleptoblock");
    }
}
