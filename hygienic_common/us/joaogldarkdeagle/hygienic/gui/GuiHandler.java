package us.joaogldarkdeagle.hygienic.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import us.joaogldarkdeagle.hygienic.Hygienic;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch (id) {
			case 1:
				return id == 1 && world.getBlock(x, y, z) == Hygienic.instance.blockPolluCraft ? new ContainerPolluCraft(player.inventory, world, x, y, z) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);

		switch (id) {
			case 1:
				return id == 1 && world.getBlock(x, y, z) == Hygienic.instance.blockPolluCraft ? new GuiPolluCraft(player.inventory, world, x, y, z) : null;
		}
		return null;
	}
}