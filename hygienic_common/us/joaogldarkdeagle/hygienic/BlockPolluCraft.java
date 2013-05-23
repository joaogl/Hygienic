package us.joaogldarkdeagle.hygienic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPolluCraft extends Block {

    public BlockPolluCraft(int par1, Material par2Material, String texture) {
        super(par1, par2Material);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.005F, 1.0F);
        this.setTickRandomly(true);
        this.setStepSound(Block.soundSnowFootstep);
        this.setCreativeTab(Hygienic.hygienicTab);
    }
}
