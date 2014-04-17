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

package hygienic.blocks;

import hygienic.Hygienic;
import hygienic.lib.Textures;
import hygienic.tileentities.TileEntityPolluCraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPolluCraft extends BlockContainer {
    
    @SideOnly(Side.CLIENT)
    private IIcon iconTopBot;
    @SideOnly(Side.CLIENT)
    private IIcon iconFront;
    @SideOnly(Side.CLIENT)
    private IIcon iconBack;
    
    public BlockPolluCraft() {
        super(Material.iron);
        this.setHardness(2F);
        this.setStepSound(Block.soundTypeMetal);
        this.setCreativeTab(Hygienic.hygienicTab);
        this.setBlockName("pollucraft");
    }
    
    @Override
    public Item getItemDropped(int par1, Random par2, int par3) {
        return Item.getItemFromBlock(this);
    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
        if(side == 1 || side == 0)
            return this.iconTopBot;
        else {
            if(side == 2) {
                if(meta == 2)
                    return this.iconFront;
                else if(meta == 3)
                    return this.iconBack;
                else return this.blockIcon;
            } else if(side == 3) {
                if(meta == 3)
                    return this.iconFront;
                else if(meta == 2)
                    return this.iconBack;
                else return this.blockIcon;
            } else if(side == 4) {
                if(meta == 4)
                    return this.iconFront;
                else if(meta == 5)
                    return this.iconBack;
                else return this.blockIcon;
            } else if(side == 5) {
                if(meta == 5)
                    return this.iconFront;
                else if(meta == 4)
                    return this.iconBack;
                else return this.blockIcon;
            }
        }
        return this.blockIcon;
    }
    
    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
        int l = MathHelper.floor_double((double) (entityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if(l == 0) world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        if(l == 1) world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        if(l == 2) world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        if(l == 3) world.setBlockMetadataWithNotify(x, y, z, 4, 2);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Textures.BLOCK_POLLUCRAFT_SIDES);
        this.iconTopBot = iconRegister.registerIcon(Textures.BLOCK_POLLUCRAFT_TOPBOT);
        this.iconFront = iconRegister.registerIcon(Textures.BLOCK_POLLUCRAFT_FRONT);
        this.iconBack = iconRegister.registerIcon(Textures.BLOCK_POLLUCRAFT_BACK);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9) {
        if(world.isRemote) return true;
        
        if(player.isSneaking()) return false;
        
        player.openGui(Hygienic.instance, 1, world, x, y, z);
        
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityPolluCraft();
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        
        if(!(tileEntity instanceof TileEntityPolluCraft)) {
           return;
        }
        
        TileEntityPolluCraft tileEntityPolluCraft = (TileEntityPolluCraft) tileEntity;
        
        for(int i = 0; i < tileEntityPolluCraft.getSizeInventory(); i++) {
            ItemStack itemStack = tileEntityPolluCraft.getStackInSlotOnClosing(i);
            
            if(itemStack == null) continue;
            
            float spawnX = x + world.rand.nextFloat();
            float spawnY = y + world.rand.nextFloat();
            float spawnZ = z + world.rand.nextFloat();
            
            EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, itemStack);
            
            float mult = 0.05F;
            
            droppedItem.motionX = (-0.5F + world.rand.nextFloat()) * mult;
            droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
            droppedItem.motionZ = (-0.5F + world.rand.nextFloat()) * mult;
            
            world.spawnEntityInWorld(droppedItem);
        }
        
        super.breakBlock(world, x, y, z, block, meta);
    }
    
    public static int craftingGridSize() {
        return 16;
    }
}