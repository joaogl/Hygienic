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

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import us.joaogldarkdeagle.hygienic.Hygienic;
import us.joaogldarkdeagle.hygienic.lib.Textures;

public class ItemRubber extends Item {

    private String texture;
    
    public ItemRubber(int par1) {
        super(par1);
        this.setCreativeTab(Hygienic.hygienicCreativeTab);
        this.texture = Textures.BLOCK_POLLUCRAFT_BACK;
        this.maxStackSize = 64;
        this.setUnlocalizedName("hygienicRubber");
    }
    
    public void registerIcons(IconRegister iconReg) {
        this.itemIcon = iconReg.registerIcon(this.texture);
    }
}
