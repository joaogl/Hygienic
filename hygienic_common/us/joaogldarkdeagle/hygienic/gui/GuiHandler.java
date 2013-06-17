package us.joaogldarkdeagle.hygienic.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    // returns an instance of the Container you made earlier
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof TileGui) {
            return new CraftContainer(player.inventory, (TileGui) tileEntity);
        }
        return null;
    }

    // returns an instance of the Gui you made earlier
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof TileGui) {
            return new Gui(player.inventory, (TileGui) tileEntity);
        }
        return null;

    }
}