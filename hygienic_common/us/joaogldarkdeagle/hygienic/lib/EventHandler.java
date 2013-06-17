package us.joaogldarkdeagle.hygienic.lib;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EventHandler {
    public EventHandler() {
    }

    @ForgeSubscribe
    public void EntityDamaged(LivingHurtEvent event) {
        EntityLiving ent = event.entityLiving;
        NBTTagCompound nbt = ent.getEntityData();
        int hpo = nbt.getInteger("HealthOverflow");
        int hp = ent.getHealth();
        int mhp = ent.getMaxHealth();
        int newhp = hp;
        int newhpo = hpo;

        if (newhpo > mhp * 2) {
        } else if (hp < mhp) {
            newhp = Math.min(hp + hpo, mhp);
            newhpo = Math.max(hp + hpo - mhp, 0);
            ent.heal(newhp - hp);
            if (ent.isDead && (newhp - hp) > 0) ent.isDead = false;
        }

        nbt.setInteger("HealthOverflow", newhpo);
        nbt.setBoolean("TookDamageFlag", true);

        if (ent instanceof EntityPlayer) {
            ByteArrayOutputStream bt = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(bt);

            try {
                out.writeInt(2);
                out.writeBoolean(true);
                Packet250CustomPayload packet = new Packet250CustomPayload("MoreDecay", bt.toByteArray());
                Player player = (Player) ent;
                PacketDispatcher.sendPacketToAllAround(ent.posX, ent.posY, ent.posZ, 0.01, ent.worldObj.provider.dimensionId, packet);
            } catch (IOException ex) {
                System.out.println("couldnt send packet!");
            }
        }
    }
}
