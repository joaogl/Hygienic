package us.joaogldarkdeagle.hygienic.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import us.joaogldarkdeagle.hygienic.util.Util;

public class DebugCommand extends CommandBase {

	public String getCommandName() {
		return "debug";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (icommandsender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) icommandsender;

			if (ModInfo.debug) {
				if (ModInfo.debugging) ModInfo.debugging = false;
				else ModInfo.debugging = true;
				// player.sendChatToPlayer("Debug mode changed to " +
				// ModInfo.debugging);
			}
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