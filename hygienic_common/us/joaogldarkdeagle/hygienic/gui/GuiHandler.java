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

package us.joaogldarkdeagle.hygienic.gui;

import us.joaogldarkdeagle.hygienic.Hygienic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        
        @SuppressWarnings("unused")
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        
        switch(id) {
            case 1:
                return id == 1 && world.getBlock(x, y, z) == Hygienic.instance.blockPolluCraft ? new ContainerPolluCraft(player.inventory, world, x, y, z)
                        : null;
        }
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        
        @SuppressWarnings("unused")
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        
        switch(id) {
            case 1:
                return id == 1 && world.getBlock(x, y, z) == Hygienic.instance.blockPolluCraft ? new GuiPolluCraft(player.inventory, world, x, y, z) : null;
        }
        return null;
    }
}