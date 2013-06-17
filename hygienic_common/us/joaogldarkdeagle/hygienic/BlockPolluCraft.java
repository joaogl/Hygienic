package us.joaogldarkdeagle.hygienic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPolluCraft extends Block {

    @SideOnly(Side.CLIENT)
    private Icon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private Icon workbenchIconFront;
    String texture;

    public BlockPolluCraft(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setStepSound(Block.soundWoodFootstep);
        this.setCreativeTab(Hygienic.hygienicTab);
        this.texture = ModInfo.polluCraft_Tex;
        this.setUnlocalizedName("polluCraft_UN");
        this.setHardness(2.5F);
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("workbench_side");
        this.workbenchIconTop = par1IconRegister.registerIcon("workbench_top");
        this.workbenchIconFront = par1IconRegister.registerIcon("workbench_front");
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
        return false;
    }
}