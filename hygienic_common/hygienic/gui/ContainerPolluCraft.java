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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

public class ContainerPolluCraft extends Container {
    
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 4, 4);
    public IInventory craftResult = new InventoryCraftResult();
    private TileEntityPolluCraft tileEntityPolluCraft;
    
    public ContainerPolluCraft(InventoryPlayer inventoryPlayer, TileEntityPolluCraft tileEntityPolluCraft) {
        this.tileEntityPolluCraft = tileEntityPolluCraft;
        
        addSlotToContainer(new SlotCrafting(inventoryPlayer.player, craftMatrix, craftResult, 0, 135, 34 + 14));
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                addSlotToContainer(new Slot(this.craftMatrix, j + i * 4, 8 + j * 18, (7 + 14) + i * 18));
            }
        }
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, (99 + 14) + i * 18));
            }
        }
        
        for(int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 171));
        }
        
        onCraftMatrixChanged(this.craftMatrix);
    }
    
    /*public ContainerPolluCraft(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
        this.worldObj = par2World;
        this.posX = par3;
        this.posY = par4;
        this.posZ = par5;
        
        //int offset2 = ((ModInfo.ScreenHeight * 6) / 480);
        
        this.addSlotToContainer(new SlotPolluCraft(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 135, 34));
        int var6;
        int var7;
        
        for(var6 = 0; var6 < 4; var6++)
            for(var7 = 0; var7 < 4; var7++)
                this.addSlotToContainer(new Slot(this.craftMatrix, var7 + var6 * 4, 8 + var7 * 18, 7 + var6 * 18));
        
        for(int i1 = 0; i1 < 3; i1++)
            for(int l1 = 0; l1 < 9; l1++)
                this.addSlotToContainer(new Slot(par1InventoryPlayer, l1 + i1 * 9 + 9, 8 + l1 * 18, 99 + i1 * 18));
        
        for(int j1 = 0; j1 < 9; j1++)
            this.addSlotToContainer(new Slot(par1InventoryPlayer, j1, 8 + j1 * 18, 157));
        
        this.onCraftMatrixChanged(this.craftMatrix);
    } // */
    
    @Override
    public void onCraftMatrixChanged(IInventory par1IInventory) {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance()
                .findMatchingRecipe(this.craftMatrix, this.tileEntityPolluCraft.getWorldObj())); //TODO: Change this, OF COURSE.
    } // */
    
    @Override
    public void onContainerClosed(EntityPlayer par1EntityPlayer) { //TODO: Make sure the items are saved after closing the GUI
        super.onContainerClosed(par1EntityPlayer);
        
        if(!this.tileEntityPolluCraft.getWorldObj().isRemote) {
            for(int var2 = 0; var2 < 16; ++var2) {
                ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);
                if(var3 != null) par1EntityPlayer.dropPlayerItemWithRandomChoice(var3, false);
            }
        }
    } // */
    
    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return tileEntityPolluCraft.isUseableByPlayer(entityPlayer);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        /*ItemStack var3 = null;
        Slot var4 = (Slot) this.inventorySlots.get(par2);
        
        if(var4 != null && var4.getHasStack()) {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();
            
            if(par2 == 0) {
                if(!this.mergeItemStack(var5, 10, 46, true)) return null;
                var4.onSlotChange(var5, var3);
            } else if(par2 >= 10 && par2 < 37) {
                if(!this.mergeItemStack(var5, 37, 46, false)) return null;
            } else if(par2 >= 37 && par2 < 46) {
                if(!this.mergeItemStack(var5, 10, 37, false)) return null;
            } else if(!this.mergeItemStack(var5, 10, 46, false)) return null;
            
            if(var5.stackSize == 0)
                var4.putStack((ItemStack) null);
            else var4.onSlotChanged();
            if(var5.stackSize == var3.stackSize) return null;
            var4.onPickupFromSlot(par1EntityPlayer, var5);
        }
        return var3; // */
        
        return null;
    }
}