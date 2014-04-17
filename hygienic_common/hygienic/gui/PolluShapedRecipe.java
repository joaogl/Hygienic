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

package hygienic.gui;

import hygienic.blocks.BlockPolluCraft;
import hygienic.tileentities.TileEntityPolluCraft;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;

public class PolluShapedRecipe implements PolluRecipe {
    
    public final Map<Integer, ItemStack> recipeItems;
    private ItemStack recipeOutput;
    
    public PolluShapedRecipe(ItemStack output, ItemStack[] items) {
        this.recipeOutput = output;
        this.recipeItems = new LinkedHashMap<Integer, ItemStack>(BlockPolluCraft.craftingGridSize());
        
        for(int i = 0; i < items.length; i++) {
            recipeItems.put(i, items[i]);
        }
        
        if(recipeItems.size() != BlockPolluCraft.craftingGridSize()) {
            for(int i = recipeItems.size() - 1; i < BlockPolluCraft.craftingGridSize(); i++) {
                recipeItems.put(i, null);
            }
        }
        
        for(int i = 0; i < recipeItems.size(); i++) {
            try {
                recipeItems.get(i).getItem();
            } catch(NullPointerException e) {
                recipeItems.put(i, null);
            }
        }
    }
    
    @Override
    public boolean matches(TileEntityPolluCraft tileEntityPolluCraft) {
        for(int slot = 0; slot < recipeItems.size(); slot++) {
            ItemStack recipeStack = recipeItems.get(slot);
            
            if(recipeStack == null) {
                if(tileEntityPolluCraft.getStackInSlot(slot) == null) {
                    continue;
                }
                
                continue;
            }
            
            if(ItemStack.areItemStacksEqual(recipeStack, tileEntityPolluCraft.getStackInSlot(slot))) {
                continue;
            }
            
            return false;
        }
        
        return true;
    }
    
    @Override
    public ItemStack getCraftingResult() {
        return this.recipeOutput;
    }
    
    @Override
    public int getSlotsOccupied() {
        return recipeItems.size();
    }
}