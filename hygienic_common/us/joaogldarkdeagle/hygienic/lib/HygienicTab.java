package us.joaogldarkdeagle.hygienic.lib;

import us.joaogldarkdeagle.hygienic.Hygienic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class HygienicTab extends CreativeTabs {

    public HygienicTab(String name) {
        super(name);
    }
    
    public ItemStack getIconItemStack() {
        return new ItemStack(Hygienic.mop);
    }

}
