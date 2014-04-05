package us.joaogldarkdeagle.hygienic.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import us.joaogldarkdeagle.hygienic.lib.ModInfo;

public class GuiPolluCraft extends GuiContainer {

	private static final ResourceLocation TEXTURE = new ResourceLocation("hygienic", "textures/gui/gui_pollucraft.png");

	protected int xSize = 176;
	protected int ySize = 195;

	public GuiPolluCraft(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
		super(new ContainerPolluCraft(par1InventoryPlayer, par2World, par3, par4, par5));
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.crafting"), 10, -6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 10, 85, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.renderEngine.bindTexture(TEXTURE);

		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;

		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
		ModInfo.ScreenHeight = this.mc.displayHeight;
		ModInfo.ScreenWidth = this.mc.displayWidth;
	}
}