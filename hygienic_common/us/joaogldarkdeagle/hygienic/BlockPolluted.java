package us.joaogldarkdeagle.hygienic;

import java.util.Random;

import us.joaogldarkdeagle.hygienic.lib.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPolluted extends Block {

    public BlockPolluted(int par1, Material par2Material, String texture) {
        super(par1, par2Material);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.005F, 1.0F);
        this.setTickRandomly(true);
        //this.setHardness(-1.0F);
        this.setStepSound(Block.soundSnowFootstep);
        this.setCreativeTab(Hygienic.hygienicTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("snow");
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        if (ModInfo.debugin) return true;
        else return false;
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        if (par1World.getBlockId(par2, (par3 - 1), par4) == 0) par1World.setBlockToAir(par2, par3, par4);
    }

    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        par1World.setBlockToAir(par3, par4, par5);
    }

    public int idDropped(int par1, Random par2Random, int par3) {
        if (ModInfo.debugin) return 905;
        else return 0;
    }

    public int quantityDropped(Random par1Random) {
        if (ModInfo.debugin) return 5;
        else return 0;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if (ModInfo.debugin) return 5;
        else return 0;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.getSavedLightValue(EnumSkyBlock.Block, par2, par3, par4) > 11) {
            par1World.setBlockToAir(par2, par3, par4);
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        System.out.println("Breaked");
    }

}
