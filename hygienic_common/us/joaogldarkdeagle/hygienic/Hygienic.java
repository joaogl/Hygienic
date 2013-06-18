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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import us.joaogldarkdeagle.hygienic.block.BlockPolluCraft;
import us.joaogldarkdeagle.hygienic.block.BlockPolluted;
import us.joaogldarkdeagle.hygienic.creativetabs.CreativeTabHygienic;
import us.joaogldarkdeagle.hygienic.gui.GuiHandler;
import us.joaogldarkdeagle.hygienic.item.ItemMop;
import us.joaogldarkdeagle.hygienic.item.ItemRubber;
import us.joaogldarkdeagle.hygienic.lib.BlockIDs;
import us.joaogldarkdeagle.hygienic.lib.ItemIDs;
import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import us.joaogldarkdeagle.hygienic.net.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class Hygienic {

    @Instance(ModInfo.MOD_ID)
    public static Hygienic instance;

    private GuiHandler guiHandler = new GuiHandler();

    public static CreativeTabs hygienicCreativeTab = new CreativeTabHygienic();
    public Block pollutedBlock;
    public Block polluCraft;
    public Item mop;
    public Item rubber;

    @SidedProxy(clientSide = "us.joaogldarkdeagle.hygienic.net.ClientProxy", serverSide = "us.joaogldarkdeagle.hygienic.net.CommonProxy")
    public static CommonProxy proxy;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Init
    public void init(FMLInitializationEvent event) {
        pollutedBlock = new BlockPolluted(BlockIDs.BLOCK_POLLUTION, Material.snow);
        GameRegistry.registerBlock(pollutedBlock, "polluted_UN");
        LanguageRegistry.addName(pollutedBlock, "Pollution");

        polluCraft = new BlockPolluCraft(BlockIDs.BLOCK_POLLUCRAFT, Material.iron);
        GameRegistry.registerBlock(polluCraft, "polluCraft_UN");
        LanguageRegistry.addName(polluCraft, "PolluCraft");
        GameRegistry.addRecipe(new ItemStack(polluCraft, 1), new Object[] { "   ", " XX", " XX", Character.valueOf('X'), Item.ingotIron });

        mop = (new ItemMop(ItemIDs.ITEM_MOP, EnumToolMaterial.IRON));
        LanguageRegistry.addName(mop, "Mop");

        rubber = (new ItemRubber(ItemIDs.ITEM_RUBBER));
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.Hygienic", "en_US", "Hygienic");

        NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {

    }
}
