/**
 * This file is part of Hygienic.

    Hygienic is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Hygienic is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Hygienic.  If not, see <http://www.gnu.org/licenses/>.
 */

package us.joaogldarkdeagle.hygienic.gui;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class RecipeSorter implements Comparator {
    final CraftingManager CraftingManager;

    RecipeSorter(CraftingManager par1CraftingManager) {
        this.CraftingManager = par1CraftingManager;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe) {
        return par1IRecipe instanceof PolluShapelessRecipes && par2IRecipe instanceof PolluShapedRecipes ? 1 : (par2IRecipe instanceof PolluShapelessRecipes && par1IRecipe instanceof PolluShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj) {
        return this.compareRecipes((IRecipe) par1Obj, (IRecipe) par2Obj);
    }
}