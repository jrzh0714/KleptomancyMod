package com.jrzh.Kleptomancy.items;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.command.impl.EnchantCommand;
import net.minecraft.command.impl.MessageCommand;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import com.jrzh.Kleptomancy.Kleptomancy;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.play.server.SCombatPacket;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.EnchantmentNameParts;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.living.PotionColorCalculationEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.enchantment.EnchantmentType;

import java.awt.*;
import java.util.Random;

public class Kleptosword extends SwordItem{

    public Kleptosword(){
        super(ItemTier.DIAMOND,5, (float) 0.0, new Properties().rarity(Rarity.RARE).group(Kleptomancy.setup.itemGroup).maxDamage(100));
        setRegistryName("kleptosword");
    }
    public boolean hasEffect(ItemStack par1ItemStack){
        return true;
    }
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Potion[] rnd = new Potion[]{Potions.HEALING,Potions.STRENGTH,Potions.LEAPING,Potions.REGENERATION,Potions.SWIFTNESS};
        Potion[] strong = new Potion[]{Potions.STRONG_HEALING,Potions.STRONG_STRENGTH,Potions.STRONG_LEAPING,Potions.STRONG_REGENERATION,Potions.STRONG_SWIFTNESS};

        Random generator = new Random();
        int percent = generator.nextInt(100)+1;
        int randomIndex = generator.nextInt(rnd.length);
        int klep = generator.nextInt(2);
        if (attacker instanceof PlayerEntity && target instanceof LivingEntity&& klep ==1)
        {
            if (percent <= 50 && percent >= 1) {
                ItemStack potion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), rnd[randomIndex]);
                ((PlayerEntity) attacker).addItemStackToInventory(potion);
                attacker.sendMessage(new StringTextComponent("You received " + PotionUtils.getPotionFromItem(potion).getNamePrefixed("") +" potion!"));
            }
            else if (percent <= 75 && percent>= 51) {
                ItemStack potion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), strong[randomIndex]);
                ((PlayerEntity) attacker).addItemStackToInventory(potion);
                attacker.sendMessage(new StringTextComponent("You received " + PotionUtils.getPotionFromItem(potion).getNamePrefixed("") +" potion!"));
            }
            else {
                ((PlayerEntity) attacker).addItemStackToInventory(new ItemStack(Items.GOLD_NUGGET));
                attacker.sendMessage(new StringTextComponent("You received a "+ Items.GOLD_NUGGET.getName().getString()+ "!"));
                ((PlayerEntity) attacker).giveExperiencePoints(5);
            }
        }



        return super.hitEntity(stack, target, attacker);
    }
}
