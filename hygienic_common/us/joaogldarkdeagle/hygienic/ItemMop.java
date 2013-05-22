package us.joaogldarkdeagle.hygienic;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMop extends Item {
    private String texture;

    public ItemMop(int par1, String texture) {
        super(par1);
        this.texture = texture;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 5;
    }
    
    public void registerIcons(IconRegister iconReg) {
        this.itemIcon = iconReg.registerIcon(this.texture);
    }
}
