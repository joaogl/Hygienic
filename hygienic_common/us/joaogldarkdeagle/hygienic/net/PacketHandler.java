package us.joaogldarkdeagle.hygienic.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import us.joaogldarkdeagle.hygienic.gui.TickHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
        if (packet.channel.equals("MoreDecay")) {
            handleRandom(packet, player);
        }
    }

    private void handleRandom(Packet250CustomPayload packet, Player player) {
        EntityPlayer p = (EntityPlayer) player;
        World world = p.worldObj;
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(packet.data));

        try {
            int guiId = dis.readInt();
            TickHandler gui = (TickHandler) TickHandler.overlayGui;

            switch (guiId) {
                case 1:
                    gui.playerOverflowHp = dis.readInt();
                    break;
                case 2:
                    gui.flag = 1;
                    break;
            }
        } catch (IOException e) {
            System.out.println("Failed to read packet");
        } finally {
        }
    }
}