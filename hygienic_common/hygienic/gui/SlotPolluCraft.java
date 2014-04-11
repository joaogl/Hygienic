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

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class SlotPolluCraft extends Slot {
	private final IInventory craftMatrix;

	private EntityPlayer thePlayer;

	private int amountCrafted;

	public SlotPolluCraft(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3IInventory, int par4, int par5, int par6) {
		super(par3IInventory, par4, par5, par6);
		this.thePlayer = par1EntityPlayer;
		this.craftMatrix = par2IInventory;
	}

	public boolean isItemValid(ItemStack par1ItemStack) {
		return false;
	}

	public ItemStack decrStackSize(int par1) {
		if (this.getHasStack()) this.amountCrafted += Math.min(par1, this.getStack().stackSize);

		return super.decrStackSize(par1);
	}

	protected void onCrafting(ItemStack par1ItemStack, int par2) {
		this.amountCrafted += par2;
		this.onCrafting(par1ItemStack);
	}

	protected void onCrafting(ItemStack par1ItemStack) {
		par1ItemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
		this.amountCrafted = 0;
	}

	public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
		// GameRegistry.onItemCrafted(par1EntityPlayer, par2ItemStack, craftMatrix); //TODO: Find what this is now
		this.onCrafting(par2ItemStack);
		for (int var3 = 0; var3 < this.craftMatrix.getSizeInventory(); ++var3) {
			ItemStack var4 = this.craftMatrix.getStackInSlot(var3);
			if (var4 != null) {
				this.craftMatrix.decrStackSize(var3, 1);
				if (var4.getItem().hasContainerItem(var4)) {
					ItemStack var5 = var4.getItem().getContainerItem(var4);
					if (var5.isItemStackDamageable() && var5.getItemDamage() > var5.getMaxDamage()) {
						MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, var5));
						var5 = null;
					}
					if (var5 != null && (!var4.getItem().doesContainerItemLeaveCraftingGrid(var4) || !this.thePlayer.inventory.addItemStackToInventory(var5))) {
						if (this.craftMatrix.getStackInSlot(var3) == null) this.craftMatrix.setInventorySlotContents(var3, var5);
						else this.thePlayer.dropPlayerItemWithRandomChoice(var5, false);
					}
				}
			}
		}
	}
}