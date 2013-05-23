package us.joaogldarkdeagle.hygienic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockPolluCraft extends Block {

    public BlockPolluCraft(int par1, Material par2Material, String texture) {
        super(par1, par2Material);
        this.setStepSound(Block.soundWoodFootstep);
        this.setCreativeTab(Hygienic.hygienicTab);
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.isRemote) {
            return true;
        } else {
            par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
            return true;
        }
    }
}