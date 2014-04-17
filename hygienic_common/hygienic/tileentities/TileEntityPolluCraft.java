package hygienic.tileentities;

import hygienic.blocks.BlockPolluCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPolluCraft extends TileEntity implements IInventory /*, ISidedInventory //Maybe later?*/{
    
    private ItemStack[] items; //The first 16 slots are the crafting GUI; the slot 17 is the result, WHICH IS NOT STORED IN NBT.
    
    public TileEntityPolluCraft() {
        items = new ItemStack[BlockPolluCraft.craftingGridSize()];
    }
    
    @Override
    public int getSizeInventory() {
        return items.length;
    }
    
    @Override
    public ItemStack getStackInSlot(int slot) {
        return items[slot];
    }
    
    @Override
    public ItemStack decrStackSize(int slot, int ammount) {
        ItemStack item = getStackInSlot(slot);
        
        if(item != null) {
            if(item.stackSize <= ammount) {
                setInventorySlotContents(slot, null);
            } else {
                item = item.splitStack(ammount);
                markDirty();
            }
        }
        
        return item;
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack item = getStackInSlot(slot);
        setInventorySlotContents(slot, null);
        return item;
    }
    
    @Override
    public void setInventorySlotContents(int slot, ItemStack item) {
        items[slot] = item;
        
        if(item != null && item.stackSize > getInventoryStackLimit()) {
            item.stackSize = getInventoryStackLimit();
        }
        
        markDirty();
    }
    
    @Override
    public String getInventoryName() {
        return "PolluCraft";
    }
    
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return entityPlayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
    }
    
    @Override
    public void openInventory() {}
    
    @Override
    public void closeInventory() {}
    
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack item) {
        return true;
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        System.out.println("Writting to NBT!");
        NBTTagList items = new NBTTagList();
        
        for(int slot = 0; slot < getSizeInventory(); slot++) {
            ItemStack itemStack = getStackInSlot(slot);
            
            if(itemStack != null) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setInteger("Slot", slot);
                itemStack.writeToNBT(itemTag);
                items.appendTag(itemTag);
            }
        }
        
        nbtTagCompound.setTag("Items", items);
        System.out.println("Wrote to NBT!");
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        System.out.println("Reading from NBT!");
        NBTTagList items = (NBTTagList) nbtTagCompound.getTag("Items");
        
        for(int i = 0; i < items.tagCount(); i++) {
            NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(i);
            
            int slot = item.getInteger("Slot");
            
            if(slot >= 0 && slot < getSizeInventory()) {
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
            }
        }
        System.out.println("Read from NBT!");
    }
}
