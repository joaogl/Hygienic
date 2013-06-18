package us.joaogldarkdeagle.hygienic.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRubber extends Item {

    public ItemRubber(int par1) {
        super(par1);
        LanguageRegistry.addName(this, "Rubber");
        
        OreDictionary.registerOre("itemRubber", this);
    }
    
    
}
