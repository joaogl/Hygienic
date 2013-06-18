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

package us.joaogldarkdeagle.hygienic.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import us.joaogldarkdeagle.hygienic.Hygienic;
import us.joaogldarkdeagle.hygienic.lib.BlockInfo;
import us.joaogldarkdeagle.hygienic.lib.ItemInfo;
import us.joaogldarkdeagle.hygienic.lib.Textures;

public class ItemMop extends ItemTool {
    private String texture;
    private final EnumToolMaterial toolMaterial;
    public static final Block[] blocksEffectiveAgainst = new Block[] { Hygienic.instance.blockPollution };

    public ItemMop(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.texture = Textures.ITEM_MOP;
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setCreativeTab(Hygienic.hygienicCreativeTab);
        this.setUnlocalizedName(ItemInfo.ITEM_MOP_UNLOCALIZEDNAME);
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
        return par1Block.blockID == BlockInfo.BLOCK_POLLUTION_ID;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.block;
    }

    public boolean isFull3D() {
        return true;
    }
}