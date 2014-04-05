package us.joaogldarkdeagle.hygienic.gui;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class PolluRecipeSorter implements Comparator {
	final CraftingManager CraftingManager;

	PolluRecipeSorter(CraftingManager par1CraftingManager) {
		this.CraftingManager = par1CraftingManager;
	}

	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe) {
		return par1IRecipe instanceof PolluShapelessRecipes && par2IRecipe instanceof PolluShapedRecipes ? 1 : (par2IRecipe instanceof PolluShapelessRecipes && par1IRecipe instanceof PolluShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
	}

	public int compare(Object par1Obj, Object par2Obj) {
		return this.compareRecipes((IRecipe) par1Obj, (IRecipe) par2Obj);
	}
}