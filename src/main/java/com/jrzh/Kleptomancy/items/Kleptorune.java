package com.jrzh.Kleptomancy.items;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import com.jrzh.Kleptomancy.Kleptomancy;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class Kleptorune extends Item {

    public Kleptorune() {
        super(new Item.Properties()
                .maxStackSize(1)
                .rarity(Rarity.UNCOMMON)

                .group(Kleptomancy.setup.itemGroup));
        setRegistryName("kleptorune");

    }
    public boolean hasEffect(ItemStack par1ItemStack){
        return true;
    }


}


