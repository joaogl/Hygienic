package us.joaogldarkdeagle.hygienic.gui;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements ITickHandler {
    public Minecraft mc;
    public int playerOverflowHp = 0;
    public int flag = 0;

    public TickHandler() {
        mc = Minecraft.getMinecraft();
    }

    public void tickStart(EnumSet<TickType> type, Object... tickData) {
    }

    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        mc.entityRenderer.setupOverlayRendering();

        if (type.equals(EnumSet.of(TickType.RENDER))) {
            onRenderTick();
        }
    }

    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.RENDER);
    }

    public String getLabel() {
        return "OverhealBar";
    }

    public void onRenderTick() {
        if (mc.currentScreen == null && !mc.thePlayer.capabilities.isCreativeMode) {
            GuiIngame gui = this.mc.ingameGUI;
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/mods/DecayingWorld/textures/gui/overheal.png"));
            // System.out.println("Current hp: " + mc.thePlayer.getHealth());
            int hpo = playerOverflowHp;
            // hpo = 5;
            int u = (int) ((double) hpo / 40 * 81);

            if (u > 0) {
                int u2 = ((int) ((double) (hpo - (hpo % 4)) / 4) + 1) * 8 + 1;
                int v = 0;
                u++;
                int delay = 16;
                // System.out.println("flag " + flag);
                // This whole flag system was the best attempt I could make at
                // making the bar "flash" like the vanilla one
                // when the player takes damage. It's imperfect, but reasonably
                // cool
                if (flag > 20 && flag < 20 + delay) {
                    v = 18;
                } else if (flag > 21 + delay * 2 && flag < 20 + delay * 3) {
                    v = 18;
                } else if (flag > 104) {
                    flag = 0;
                }

                // System.out.println(v);
                gui.drawTexturedModalRect(122, 209, 0, v, u, 9);
                gui.drawTexturedModalRect(122, 209, 0, v + 9, u2, 9);

                if (flag > 0) {
                    flag += 1;
                }
            } else {
                flag = 0;
            }
        }
    }
}