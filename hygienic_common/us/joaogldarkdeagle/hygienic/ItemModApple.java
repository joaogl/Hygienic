package us.joaogldarkdeagle.hygienic;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemModApple extends ItemModFood {

    public ItemModApple(int par1, int par2, boolean par3, String texture) {
        super(par1, par2, par3, texture);
    }

    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.common;
    }

    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }

}
