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

package hygienic.util;

import net.minecraft.item.ItemStack;

public class Util {
    
    public static boolean itemsOfStacksEqual(ItemStack itemStack1, ItemStack itemStack2, boolean useStackSize) {
        if(itemStack1 == null || itemStack2 == null) {
            return false;
        }
        
        if(itemStack1.getItem() == itemStack2.getItem()) {
            if(useStackSize) {
                if(itemStack1.stackSize == itemStack2.stackSize)
                    return true;
                else return false;
            } else return true;
        } else return false;
    }
}
