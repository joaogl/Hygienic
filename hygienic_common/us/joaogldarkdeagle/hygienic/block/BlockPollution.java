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

package us.joaogldarkdeagle.hygienic.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import us.joaogldarkdeagle.hygienic.Hygienic;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import us.joaogldarkdeagle.hygienic.lib.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPollution extends Block {
	private String texture;

	public BlockPollution(Material material) {
		super(material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0035F, 1.0F);
		this.setHardness(1F);
		this.setStepSound(Block.soundTypeSnow);
		this.setBlockName("pollution");
		this.setCreativeTab(Hygienic.hygienicCreativeTab);
		this.texture = Textures.BLOCK_POLLUTION;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(this.texture);
	}

	@Override
	public boolean canReplace(World world, int par1, int par2, int par3, int par4, ItemStack par5) {
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

	@Override
	public void onBlockDestroyedByPlayer(World world, int par1, int par2, int par3, int par4) {
		// if (canHarvestBlock(player, world.getBlockMetadata(x, y, z))) return
		// world.setBlockToAir(x, y, z);
		// else return false;
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		if (ModInfo.debugging) return true;
		else return false;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		/*
		 * int blockX; int blockY; int blockZ; if (world.getBlockId(x, (y - 1),
		 * z) == 0) world.setBlockToAir(x, y, z); blockX = x; blockY = y + 1;
		 * blockZ = z; int blockAboveId = world.getBlockId(blockX, blockY,
		 * blockZ); if (blockAboveId != 0) { if (blockAboveId ==
		 * Block.waterMoving.blockID || blockAboveId ==
		 * Block.waterStill.blockID) return;
		 * 
		 * world.destroyBlock(blockX, blockY, blockZ, true); }
		 */
	}

	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
		par1World.setBlockToAir(par3, par4, par5);
	}

	@Override
	public Item getItemDropped(int par1, Random par2, int par3) {
		if (ModInfo.debugging) return Item.getItemFromBlock(this);
		else return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		if (ModInfo.debugging) return 1;
		else return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		if (side == 1) return true;
		return false;
	}
}
