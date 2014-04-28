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
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;

public class ContainerPolluCraft extends Container {
    
    public IInventory craftResult = new InventoryCraftResult();
    private TileEntityPolluCraft tileEntityPolluCraft;
    
    public ContainerPolluCraft(InventoryPlayer inventoryPlayer, TileEntityPolluCraft tileEntityPolluCraft) {
        this.tileEntityPolluCraft = tileEntityPolluCraft;
        
        addSlotToContainer(new SlotCrafting(inventoryPlayer.player, tileEntityPolluCraft, craftResult, 0, 135, 34 + 14));
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                addSlotToContainer(new Slot(tileEntityPolluCraft, j + i * 4, 8 + j * 18, (7 + 14) + i * 18));
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
        
        updateInventory();
    }
    
    public void updateInventory() {
        this.craftResult.setInventorySlotContents(0,
                PolluCraftingManager.instance().findMatchingRecipe(tileEntityPolluCraft, this.tileEntityPolluCraft.getWorldObj()).getCraftingResult());
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return tileEntityPolluCraft.isUseableByPlayer(entityPlayer);
    }
}