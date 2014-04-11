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

package hygienic.commands;

import hygienic.lib.ModInfo;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

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
				if (icommandsender instanceof EntityPlayer) ((EntityPlayer) icommandsender).addChatMessage(new ChatComponentTranslation("Debug mode changed to " + ModInfo.debugging));
				else if (icommandsender instanceof MinecraftServer) ((MinecraftServer) icommandsender).addChatMessage(new ChatComponentTranslation("Debug mode changed to " + ModInfo.debugging));
			}
		}
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/<command>";
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}