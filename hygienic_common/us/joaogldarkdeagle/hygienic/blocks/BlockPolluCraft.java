package us.joaogldarkdeagle.hygienic.blocks;

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
import us.joaogldarkdeagle.hygienic.Hygienic;
import us.joaogldarkdeagle.hygienic.lib.Textures;
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
		this.setBlockName("PolluCraft");
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
		if (par1 == 1 || par1 == 0) return this.iconTopBot;
		else {
			if (par1 == 2) {
				if (par2 == 2) return this.iconFront;
				else if (par2 == 3) return this.iconBack;
				else return this.blockIcon;
			} else if (par1 == 3) {
				if (par2 == 3) return this.iconFront;
				else if (par2 == 2) return this.iconBack;
				else return this.blockIcon;
			} else if (par1 == 4) {
				if (par2 == 4) return this.iconFront;
				else if (par2 == 5) return this.iconBack;
				else return this.blockIcon;
			} else if (par1 == 5) {
				if (par2 == 5) return this.iconFront;
				else if (par2 == 4) return this.iconBack;
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
		if (l == 0) par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		if (l == 1) par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		if (l == 2) par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		if (l == 3) par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
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
		if (!player.isSneaking()) {
			player.openGui(Hygienic.instance, 1, var1, var2, var3, var4);
			return true;
		} else return false;
	}
}