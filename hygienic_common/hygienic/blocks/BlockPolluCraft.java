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

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPolluCraft extends Block {
    
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
    public int quantityDropped(Random par1Random) {
        return 1;
    }
    
    @Override
    public IIcon getIcon(int par1, int par2) {
        if(par1 == 1 || par1 == 0)
            return this.iconTopBot;
        else {
            if(par1 == 2) {
                if(par2 == 2)
                    return this.iconFront;
                else if(par2 == 3)
                    return this.iconBack;
                else return this.blockIcon;
            } else if(par1 == 3) {
                if(par2 == 3)
                    return this.iconFront;
                else if(par2 == 2)
                    return this.iconBack;
                else return this.blockIcon;
            } else if(par1 == 4) {
                if(par2 == 4)
                    return this.iconFront;
                else if(par2 == 5)
                    return this.iconBack;
                else return this.blockIcon;
            } else if(par1 == 5) {
                if(par2 == 5)
                    return this.iconFront;
                else if(par2 == 4)
                    return this.iconBack;
                else return this.blockIcon;
            }
        }
        return this.blockIcon;
    }
    
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
    }
    
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
        int l = MathHelper.floor_double((double) (par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if(l == 0) par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        if(l == 1) par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        if(l == 2) par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        if(l == 3) par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Textures.BLOCK_POLLUCRAFT_SIDES);
        this.iconTopBot = par1IconRegister.registerIcon(Textures.BLOCK_POLLUCRAFT_TOPBOT);
        this.iconFront = par1IconRegister.registerIcon(Textures.BLOCK_POLLUCRAFT_FRONT);
        this.iconBack = par1IconRegister.registerIcon(Textures.BLOCK_POLLUCRAFT_BACK);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {
        if(!player.isSneaking()) {
            player.openGui(Hygienic.instance, 1, var1, var2, var3, var4);
            return true;
        } else return false;
    }
}