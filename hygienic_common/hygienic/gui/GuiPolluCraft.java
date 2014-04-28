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

package hygienic.gui;

import hygienic.tileentity.TileEntityPolluCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPolluCraft extends GuiContainer {
    
    private static final ResourceLocation TEXTURE = new ResourceLocation("hygienic", "textures/gui/gui_pollucraft.png");
    
    
    /*public GuiPolluCraft(InventoryPlayer inventoryPlayer, World world, int x, int y, int z) {
        super(new ContainerPolluCraft(inventoryPlayer, world, x, y, z));
    }*/
    
    public GuiPolluCraft(InventoryPlayer inventoryPlayer, TileEntityPolluCraft tileEntity) {
        super(new ContainerPolluCraft(inventoryPlayer, tileEntity));
        
        xSize = 176;
        ySize = 195;
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.crafting"), 10, -6 + 17, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 10, 85 + 17, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
    
    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        
        ((ContainerPolluCraft) inventorySlots).updateInventory();
    }
}