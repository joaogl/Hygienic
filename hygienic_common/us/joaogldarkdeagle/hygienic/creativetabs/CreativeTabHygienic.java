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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import us.joaogldarkdeagle.hygienic.lib.ItemIDs;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabHygienic extends CreativeTabs{
    
    public CreativeTabHygienic() {
        super(ModInfo.CREATIVETAB_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return ItemIDs.ITEM_MOP;
    }
}
