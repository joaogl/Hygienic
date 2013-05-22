package us.joaogldarkdeagle.hygienic;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemModFood extends ItemFood {
    private String texture;

    public ItemModFood(int par1, int par2, boolean par3, String texture) {
        super(par1, par2, par3);
        this.texture = texture;
        setCreativeTab(Hygienic.hygienicTab);
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 5;
    }
    
    public void registerIcons(IconRegister iconReg) {
        this.itemIcon = iconReg.registerIcon(this.texture);
    }

}
