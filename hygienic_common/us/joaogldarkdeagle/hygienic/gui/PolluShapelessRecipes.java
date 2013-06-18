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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class PolluShapelessRecipes implements IRecipe {

    private final ItemStack recipeOutput;
    public final List recipeItems;

    public PolluShapelessRecipes(ItemStack par1ItemStack, List par2List) {
        this.recipeOutput = par1ItemStack;
        this.recipeItems = par2List;
    }

    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    public boolean matches(InventoryCrafting par1InventoryCrafting, World par2World) {
        ArrayList arraylist = new ArrayList(this.recipeItems);

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                ItemStack itemstack = par1InventoryCrafting.getStackInRowAndColumn(j, i);

                if (itemstack != null) {
                    boolean flag = false;
                    Iterator iterator = arraylist.iterator();

                    while (iterator.hasNext()) {
                        ItemStack itemstack1 = (ItemStack) iterator.next();
                        if (itemstack.itemID == itemstack1.itemID && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage())) {
                            flag = true;
                            arraylist.remove(itemstack1);
                            break;
                        }
                    }
                    if (!flag) return false;
                }
            }
        }
        return arraylist.isEmpty();
    }

    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting) {
        return this.recipeOutput.copy();
    }

    public int getRecipeSize() {
        return this.recipeItems.size();
    }
}