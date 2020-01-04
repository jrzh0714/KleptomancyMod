package com.jrzh.Kleptomancy.items;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import com.jrzh.Kleptomancy.Kleptomancy;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class Kleptorune extends Item{

    public Kleptorune(){
        super(new Item.Properties()
                .maxStackSize(1)
                .group(Kleptomancy.setup.itemGroup));
        setRegistryName("kleptorune");


    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof PlayerEntity && target.getType() == EntityType.COW)
        {
            System.out.println(target.getEntity());
            ItemStack potion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.HEALING);
            ((PlayerEntity) attacker).addItemStackToInventory(potion);
        }

        if (attacker instanceof PlayerEntity && target.getType() == EntityType.SHEEP)
        {
            System.out.println(target.getEntity());
            ItemStack potion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.STRENGTH);
            ((PlayerEntity) attacker).addItemStackToInventory(potion);
        }
        return super.hitEntity(stack, target, attacker);
    }
}

