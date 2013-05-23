package us.joaogldarkdeagle.hygienic;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemMop extends ItemTool {
    private String texture;
    private final EnumToolMaterial toolMaterial;
    public static final Block[] blocksEffectiveAgainst = new Block[] { Hygienic.pollutedBlock };

    public ItemMop(int par1, EnumToolMaterial par2EnumToolMaterial, String texture) {
        super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.texture = texture;
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
    }

    public void registerIcons(IconRegister iconReg) {
        this.itemIcon = iconReg.registerIcon(this.texture);
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 72000;
    }

    public boolean canHarvestBlock(Block par1Block) {
        return par1Block.blockID == Hygienic.pollutedBlock.blockID;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.block;
    }

    public boolean isFull3D() {
        return true;
    }
}