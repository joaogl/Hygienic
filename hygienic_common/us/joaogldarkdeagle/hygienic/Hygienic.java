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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import us.joaogldarkdeagle.hygienic.blocks.BlockPollution;
import us.joaogldarkdeagle.hygienic.creativetabs.CreativeTabHygienic;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import us.joaogldarkdeagle.hygienic.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class Hygienic {

	// General Mod Stuff
	@Instance(ModInfo.MOD_ID)
	public static Hygienic instance;
	@SidedProxy(clientSide = "us.joaogldarkdeagle.hygienic.proxy.ClientProxy", serverSide = "us.joaogldarkdeagle.hygienic.proxy.CommonProxy")
	public static CommonProxy proxy;

	/**
	 * Items / Blocks / Etc's.
	 */

	// Tabs
	public static final CreativeTabHygienic hygienicTab = new CreativeTabHygienic();

	// Blocks
	public static final Block blockPollution = new BlockPollution();

	// Items

	// Recipes

	// Smeltings

	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		proxy.registerRenderInformation();

		// Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.farmland, 1), Blocks.dirt, Items.stone_hoe);
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.command_block, 1), "X X", " Y ", "X X", 'X', Blocks.dirt, 'Y', Blocks.anvil);

		// Smeltings
		GameRegistry.addSmelting(Blocks.coal_block, new ItemStack(Blocks.obsidian), 1.0F);

		// Blocks
		LanguageRegistry.addName(blockPollution, "Pollution");
		GameRegistry.registerBlock(blockPollution, blockPollution.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("Pollution", blockPollution);

		// Tabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.hygienic", "en_US", "Hygienic Mod");
	}

}