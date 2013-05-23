package us.joaogldarkdeagle.hygienic.gui;

public class Gui_PolluCraft extends TileGui {
    private final TileRollingMachine tile;

    public GuiRollingMachine(qw inventoryplayer, TileRollingMachine tile) {
        super(tile, new ContainerRollingMachine(inventoryplayer, tile), "/railcraft/client/textures/gui/gui_rolling.png");
        this.tile = tile;
    }

    public void b() {
        super.b();
    }

    protected void b(int mouseX, int mouseY) {
        GuiTools.drawCenteredString(this.l, this.tile.b(), 6);
        this.l.b(bm.a("container.inventory"), 8, this.c - 96 + 2, 4210752);
    }

    protected void a(float f, int i, int j) {
        super.a(f, i, j);
        int x = (this.g - this.b) / 2;
        int y = (this.h - this.c) / 2;
        if (this.tile.getProgress() > 0) {
            int progress = this.tile.getProgressScaled(23);
            b(x + 89, y + 45, 176, 0, progress + 1, 12);
        }
    }
}