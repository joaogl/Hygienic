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

package us.joaogldarkdeagle.hygienic.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import us.joaogldarkdeagle.hygienic.Hygienic;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;

public class CreativeTabHygienic extends CreativeTabs{
    
    public CreativeTabHygienic() {
        super(CreativeTabs.getNextID(), ModInfo.CREATIVETAB_NAME);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Hygienic.instance.mop);
    }
}
