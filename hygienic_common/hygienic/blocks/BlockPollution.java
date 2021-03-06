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

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPollution extends Block {
    
    private String texture;
    
    public BlockPollution() {
        super(Material.plants);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0035F, 1.0F);
        this.setHardness(1F);
        this.setStepSound(Block.soundTypeSnow);
        this.setBlockName("pollution");
        this.setCreativeTab(Hygienic.hygienicTab);
        this.texture = Textures.BLOCK_POLLUTION;
        this.setBlockTextureName(this.texture);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(this.texture);
    }
    
    @Override
    public boolean getCanBlockGrass() {
        return false;
    }
    
    @Override
    public boolean canReplace(World world, int x, int y, int z, int meta, ItemStack par5) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    /*@Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par4) {
    	//world.setBlock(x, y, z, this);
    }// */
    
    @Override
    public float getPlayerRelativeBlockHardness(EntityPlayer entityPlayer, World world, int x, int y, int z) {
        return entityPlayer.capabilities.isCreativeMode ? 1.0F : entityPlayer.getCurrentEquippedItem() != null
                && entityPlayer.getCurrentEquippedItem().getItem() == Hygienic.itemMop ? 1.0F : -1.0F;
        
        /*if(entityPlayer.capabilities.isCreativeMode) {
            return 1.0F;
        }
        
        if(entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem().getItem() == Hygienic.itemMop) {
            System.out.println("Works");
            return 1.0F;
        }
        
        return -1.0F; // */
    }
    
    @Override
    public boolean canHarvestBlock(EntityPlayer player, int meta) {
        return false;
    }
    
    /*@Override
    public boolean canPlaceBlockAt(World par1World, int x, int y, int z) {
        if(ModInfo.debugging)
            return true;
        else return false;
    }// *///Why limiting this? Players shouldn't be able to get pollution, so, less code needed, fool
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(world.getBlock(x, (y - 1), z) == Blocks.air) world.setBlockToAir(x, y, z);
        int blockX = x, blockY = y + 1, blockZ = z;
        
        Block blockAbove = world.getBlock(blockX, blockY, blockZ);
        if(blockAbove != Blocks.air) {
            if(blockAbove == Blocks.water) return;
            world.setBlockToAir(blockX, blockY, blockZ);
        }
    }
    
    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, @SuppressWarnings("rawtypes") List collisionBoxes,
            Entity collidingEntity) {
        // None to make it nonCollidable
    }
    
    @Override
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        par1World.setBlockToAir(par3, par4, par5);
    }
    
    @Override
    public Item getItemDropped(int par1, Random par2, int par3) {
        return null; //Just return null, no need to drop pollution
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
    
    @Override
    public int quantityDropped(Random random) {
        return 0;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if(side == 1) return true;
        return false;
    }
    
}
