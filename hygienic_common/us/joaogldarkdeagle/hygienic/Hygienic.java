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

package us.joaogldarkdeagle.hygienic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.oredict.OreDictionary;
import us.joaogldarkdeagle.hygienic.block.BlockPolluCraft;
import us.joaogldarkdeagle.hygienic.block.BlockPollution;
import us.joaogldarkdeagle.hygienic.commands.HygienicCommand;
import us.joaogldarkdeagle.hygienic.creativetabs.CreativeTabHygienic;
import us.joaogldarkdeagle.hygienic.gui.GuiHandler;
import us.joaogldarkdeagle.hygienic.item.ItemLye;
import us.joaogldarkdeagle.hygienic.item.ItemMop;
import us.joaogldarkdeagle.hygienic.item.ItemRubber;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import us.joaogldarkdeagle.hygienic.net.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class Hygienic {

	@Instance(ModInfo.MOD_ID)
	public static Hygienic instance;

	private GuiHandler guiHandler = new GuiHandler();

	public static CreativeTabs hygienicCreativeTab = new CreativeTabHygienic();
	public Block blockPollution;
	public Block blockPolluCraft;
	public Item itemMop;
	public Item itemLye;
	public Item itemRubber;

	@SidedProxy(clientSide = "us.joaogldarkdeagle.hygienic.net.ClientProxy", serverSide = "us.joaogldarkdeagle.hygienic.net.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager serverCommand = ((ServerCommandManager) command);
		serverCommand.registerCommand(new HygienicCommand());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		blockPollution = new BlockPollution(Material.snow);
		GameRegistry.registerBlock(blockPollution, "pollution");
		//LanguageRegistry.addName(blockPollution, "Pollution");

		blockPolluCraft = new BlockPolluCraft(Material.iron);
		GameRegistry.registerBlock(blockPolluCraft, "pollucraft");
		//LanguageRegistry.addName(blockPolluCraft, "PolluCraft");
		GameRegistry.addRecipe(new ItemStack(blockPolluCraft, 1), new Object[] { "   ", " XX", " XX", Character.valueOf('X'), Item.itemRegistry.getObject("iron_ingot") });

		itemMop = (new ItemMop());
		GameRegistry.registerItem(itemMop, "mop");
		//LanguageRegistry.addName(itemMop, "Mop");

		itemLye = (new ItemLye()); //TODO: Make this a fluid?
		GameRegistry.registerItem(itemLye, "lye");
		//LanguageRegistry.addName(itemLye, "Lye");

		itemRubber = (new ItemRubber());
		GameRegistry.registerItem(itemRubber, "rubber");
		//LanguageRegistry.addName(itemRubber, "Rubber");
		OreDictionary.registerOre("itemRubber", itemRubber);

		//LanguageRegistry.instance().addStringLocalization("itemGroup.Hygienic", "en_US", "Hygienic");

		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
