package us.joaogldarkdeagle.hygienic.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;

public class HygienicCommand extends CommandBase {

	public String getCommandName() {
		return "hygienic";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (icommandsender instanceof EntityPlayer || icommandsender instanceof MinecraftServer) {
			if (ModInfo.debug) {
				if (ModInfo.debugging) ModInfo.debugging = false;
				else ModInfo.debugging = true;
				// player.sendChatToPlayer("Debug mode changed to " +
				// ModInfo.debugging);
			}
		} else {
		    
		}
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/<command>";
	}

	@Override
	public int compareTo(Object o) {
		// TODO: this
		return 0;
	}
}