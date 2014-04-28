package hygienic.util.pollucraft;

import hygienic.tileentity.TileEntityPolluCraft;
import net.minecraft.item.ItemStack;

public interface PolluRecipe {
    
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(TileEntityPolluCraft tileEntityPolluCraft);
    
    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult();
    
    /**
     * Returns the number of slots occupied by this recipe's shape
     */
    int getSlotsOccupied();
}
