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

import hygienic.tileentities.TileEntityPolluCraft;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PolluShapelessRecipes implements PolluRecipe {
    
    private final ItemStack recipeOutput;
    public final Map<Integer, Item> recipeItems;
    
    public PolluShapelessRecipes(ItemStack itemStack, Item... items) {
        this.recipeOutput = itemStack;
        this.recipeItems = new LinkedHashMap<Integer, Item>(16);
        
        for(int i = 0; i < items.length; i++) {
            recipeItems.put(i, items[i]);
        }
    }
    
    @Override
    public boolean matches(TileEntityPolluCraft tileEntityPolluCraft) {
        /*ArrayList<?> arraylist = new ArrayList<Object>(this.recipeItems);
        
        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                ItemStack itemstack = par1InventoryCrafting.getStackInSlot(j + i);
                
                if(itemstack != null) {
                    boolean flag = false;
                    Iterator<?> iterator = arraylist.iterator();
                    
                    while(iterator.hasNext()) {
                        ItemStack itemstack1 = (ItemStack) iterator.next();
                        if(itemstack.getItem() == itemstack1.getItem()
                                && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage())) {
                            flag = true;
                            arraylist.remove(itemstack1);
                            break;
                        }
                    }
                    if(!flag) return false;
                }
            }
        }
        return arraylist.isEmpty(); // */
        
        return false; //TODO THIS
    }
    
    @Override
    public ItemStack getCraftingResult() {
        return this.recipeOutput.copy();
    }
    
    @Override
    public int getSlotsOccupied() {
        return recipeItems.size();
    }
}