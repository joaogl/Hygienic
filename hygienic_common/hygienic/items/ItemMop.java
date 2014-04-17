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

package hygienic.items;

import hygienic.Hygienic;
import hygienic.lib.Textures;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

@SuppressWarnings("unchecked")
public class ItemMop extends ItemTool {
    
    private String texture;
    @SuppressWarnings("rawtypes")
    public static final Set blocksEffectiveAgainst;
    
    static {
        blocksEffectiveAgainst = new HashSet<Block>();
        
        blocksEffectiveAgainst.add(Hygienic.blockPollution);
    }
    
    public ItemMop() {
        super(0, ToolMaterial.STONE, blocksEffectiveAgainst);
        this.texture = Textures.ITEM_MOP;
        this.setMaxStackSize(1);
        this.setCreativeTab(Hygienic.hygienicTab);
        this.setUnlocalizedName("mop");
    }
    
    @Override
    public void registerIcons(IIconRegister iconReg) {
        this.itemIcon = iconReg.registerIcon(this.texture);
    }
    
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 72000;
    }
    
    @Override
    public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
        if(block == Hygienic.blockPollution) {
            item.damageItem(1, entityLivingBase);
        }
        return false;
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.block;
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
}