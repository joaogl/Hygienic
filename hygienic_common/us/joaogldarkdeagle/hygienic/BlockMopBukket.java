package us.joaogldarkdeagle.hygienic;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockMopBukket extends Block {
    private String texture;

    public BlockMopBukket(int id, Material material, String texture) {
        super(id, material);
        this.texture = texture;
        setCreativeTab(Hygienic.hygienicTab);
        this.slipperiness = 4.0F;
    }

    public void registerIcons(IconRegister iconReg) {
        this.blockIcon = iconReg.registerIcon(this.texture);
    }

    public int quantityDropped(Random par1Random) {
        return 5;
    }

    public int idDropped(int par1, Random par2Random, int par3) {
        return Hygienic.mopBukket.blockID;
    }

    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        par5Entity.motionY = 0.8;
        for (int i = 0; i < 5; i++) {
            par1World.spawnParticle("flame", par5Entity.posX - 0.5D, par5Entity.posY - 0.5D, par5Entity.posZ - 0.5D, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", par5Entity.posX + 0.5D, par5Entity.posY - 0.5D, par5Entity.posZ + 0.5D, 0.0D, 0.0D, 0.0D);
        }
    }
}