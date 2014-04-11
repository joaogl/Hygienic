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

package hygienic;

import hygienic.blocks.BlockPolluCraft;
import hygienic.blocks.BlockPollution;
import hygienic.commands.HygienicCommand;
import hygienic.creativetabs.CreativeTabHygienic;
import hygienic.gui.GuiHandler;
import hygienic.items.ItemMop;
import hygienic.lib.ModInfo;
import hygienic.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class Hygienic {

	// General Mod Stuff
	@Instance(ModInfo.MOD_ID)
	public static Hygienic instance;
	@SidedProxy(clientSide = "hygienic.proxy.ClientProxy", serverSide = "hygienic.proxy.CommonProxy")
	public static CommonProxy proxy;

	/**
	 * Items / Blocks / Etc's.
	 */

	// Gui
	private GuiHandler guiHandler = new GuiHandler();

	// Tabs
	public static final CreativeTabHygienic hygienicTab = new CreativeTabHygienic();

	// Blocks
	public static final Block blockPollution = new BlockPollution();
	public static final Block blockPolluCraft = new BlockPolluCraft();

	// Items
	public static final Item itemMop = new ItemMop();

	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager serverCommand = ((ServerCommandManager) command);
		serverCommand.registerCommand(new HygienicCommand());
	}

	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		proxy.registerRenderInformation();

		// Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.farmland, 1), Blocks.dirt, Items.stone_hoe);
		GameRegistry.addShapedRecipe(new ItemStack(blockPolluCraft, 1), "   ", " XX", " XX", 'X', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(itemMop, 1), "  S", "TS ", "TT ", 'S', Items.stick, 'T', Items.string);

		// Smeltings
		//GameRegistry.addSmelting(Blocks.coal_block, new ItemStack(Blocks.obsidian), 1.0F); //??
		
		//Language
		proxy.initLang();
		
		// Blocks
		//LanguageRegistry.addName(blockPollution, "Pollution"); Just add in the language file, for blocks use like this: tile.<block name>.name=<localized block name>
		GameRegistry.registerBlock(blockPollution, blockPollution.getUnlocalizedName().substring(5)); //The substring is to get rid of the "tile." part of the unlocalized name
		OreDictionary.registerOre("Pollution", blockPollution);

		//LanguageRegistry.addName(blockPolluCraft, "PolluCraft");
		GameRegistry.registerBlock(blockPolluCraft, blockPolluCraft.getUnlocalizedName().substring(5)); //The substring is to get rid of the "tile." part of the unlocalized name
		OreDictionary.registerOre("PolluCraft", blockPolluCraft);

		// Tabs
		//LanguageRegistry.instance().addStringLocalization("itemGroup.hygienic", "en_US", "Hygienic Mod"); Lang file, usage: itemGroup.<tab unlocalized name>=<localized name>

		// Items
		//LanguageRegistry.addName(itemMop, "Mop"); Lang file. usage for items: item.<unlocalized name>.name=<localized name>
		GameRegistry.registerItem(itemMop, "Mop");
		OreDictionary.registerOre("Mop", itemMop);

		// Gui
		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
	}

}