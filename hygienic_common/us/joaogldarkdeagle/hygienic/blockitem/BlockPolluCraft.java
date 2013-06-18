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

package us.joaogldarkdeagle.hygienic.blockitem;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import us.joaogldarkdeagle.hygienic.Hygienic;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPolluCraft extends Block {

    @SideOnly(Side.CLIENT)
    private Icon IconTopBot;
    @SideOnly(Side.CLIENT)
    private Icon IconFront;
    @SideOnly(Side.CLIENT)
    private Icon IconBack;

    public BlockPolluCraft(int par1, Material material) {
        super(par1, material);
        this.setCreativeTab(Hygienic.hygienicCreativeTab);
    }

    public int idDropped(int par1, Random par2Random, int par3) {
        return Hygienic.polluCraft.blockID;
    }

    public int quantityDropped(Random par1Random) {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if (par5 == 1 || par5 == 0) return this.IconTopBot;
        else {
            int par6 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
            if (par5 == 2)
            ;
            if (par5 == 3)
            ;
            if (par5 == 4)
            ;
            if (par5 == 5)
            ;
        }
        return null;
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3, int par4) {
        if (!par1World.isRemote) {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]) b0 = 3;
            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]) b0 = 2;
            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]) b0 = 5;
            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]) b0 = 4;
            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }

    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack) {
        int l = MathHelper.floor_double((double) (par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (l == 0) par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        if (l == 1) par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        if (l == 2) par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        if (l == 3) par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        if (par6ItemStack.hasDisplayName()) ((TileEntityFurnace) par1World.getBlockTileEntity(par2, par3, par4)).func_94129_a(par6ItemStack.getDisplayName());
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(ModInfo.polluCraft_Sides);
        this.IconTopBot = par1IconRegister.registerIcon(ModInfo.polluCraft_TopBot);
        this.IconFront = par1IconRegister.registerIcon(ModInfo.polluCraft_Front);
        this.IconBack = par1IconRegister.registerIcon(ModInfo.polluCraft_Back);
    }

    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {
        if (!player.isSneaking()) {
            player.openGui(Hygienic.instance, 1, var1, var2, var3, var4);
            return true;
        } else return false;
    }
}