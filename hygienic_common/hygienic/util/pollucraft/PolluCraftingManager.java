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

package hygienic.util.pollucraft;

import hygienic.Hygienic;
import hygienic.tileentity.TileEntityPolluCraft;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PolluCraftingManager {
    
    private static final PolluCraftingManager instance = new PolluCraftingManager();
    
    private List<PolluRecipe> recipes;
    
    public static final PolluCraftingManager instance() {
        return instance;
    }
    
    private PolluCraftingManager() {
        recipes = new ArrayList<PolluRecipe>();
        
        this.addRecipe(new ItemStack(Hygienic.itemMop, 1), null, new ItemStack(Items.stick, 1), new ItemStack(Items.stick, 1), null, null, new ItemStack(Items.stick, 1), new ItemStack(Items.stick, 1), null, null, new ItemStack(Items.stick, 1), new ItemStack(Items.stick, 1), null, new ItemStack(Items.string, 1), new ItemStack(Items.string, 1), new ItemStack(Items.string, 1), new ItemStack(Items.string, 1));
    }
    
    public void addRecipe(ItemStack output, ItemStack... items) {
        PolluShapedRecipe recipe = new PolluShapedRecipe(output, items);
        this.recipes.add(recipe);
    }
    
    /*public void addBuilderShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
        ArrayList<ItemStack> var3 = new ArrayList<ItemStack>();
        Object[] var4 = par2ArrayOfObj;
        int var5 = par2ArrayOfObj.length;
        
        for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            if(var7 instanceof ItemStack)
                var3.add(((ItemStack) var7).copy());
            else if(var7 instanceof Item)
                var3.add(new ItemStack((Item) var7));
            else {
                if(!(var7 instanceof Block)) throw new RuntimeException("Invalid shapeless recipy!");
                var3.add(new ItemStack((Block) var7));
            }
        }
        this.recipes.add(new PolluShapelessRecipes(par1ItemStack, var3));
    } // */
    
    public PolluRecipe findMatchingRecipe(TileEntityPolluCraft tileEntityPolluCraft, World world) {
        /*int var3 = 0;
        ItemStack var4 = null;
        ItemStack var5 = null;
        int var6;
        
        for(var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6) {
            ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);
            if(var7 != null) {
                if(var3 == 0) var4 = var7;
                if(var3 == 1) var5 = var7;
                ++var3;
            }
        }
        
        if(var3 == 2 && var4.getItem() == var5.getItem() && var4.stackSize == 1 && var5.stackSize == 1 && var4.getItem().isRepairable()) {
            Item var11 = var4.getItem();
            int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
            int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
            int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
            int var10 = var11.getMaxDamage() - var9;
            if(var10 < 0) var10 = 0;
            return new ItemStack(var4.getItem(), 1, var10);
        } else {
            for(var6 = 0; var6 < this.recipes.size(); ++var6) {
                PolluRecipe var12 = this.recipes.get(var6);
                if(var12.matches(par1InventoryCrafting, par2World)) return var12.getCraftingResult(par1InventoryCrafting);
            }
            return null;
        } // */
        
        for(PolluRecipe polluRecipe : getRecipeList()) {
            if(polluRecipe.matches(tileEntityPolluCraft)) {
                return polluRecipe;
            }
        }
        
        return new PolluRecipe() { //Empty pollu recipe
            @Override
            public boolean matches(TileEntityPolluCraft tileEntityPolluCraft) {
                return true;
            }

            @Override
            public ItemStack getCraftingResult() {
                return null;
            }
            
            @Override
            public int getSlotsOccupied() {
                return 0;
            }
        };
    }
    
    public List<PolluRecipe> getRecipeList() {
        return this.recipes;
    }
}