package hygienic.gui;

import hygienic.tileentities.TileEntityPolluCraft;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface PolluRecipe {
    
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(TileEntityPolluCraft var1, World var2);
    
    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(TileEntityPolluCraft var1);
    
    /**
     * Returns the size of the recipe area
     */
    int getRecipeSize();
    
    ItemStack getRecipeOutput();
}
