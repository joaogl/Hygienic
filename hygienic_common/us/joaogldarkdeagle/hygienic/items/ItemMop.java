package us.joaogldarkdeagle.hygienic.items;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import us.joaogldarkdeagle.hygienic.Hygienic;
import us.joaogldarkdeagle.hygienic.lib.Textures;

public class ItemMop extends ItemTool {
	private String texture;
	@SuppressWarnings("rawtypes")
	public static final Set blocksEffectiveAgainst;

	static {
		blocksEffectiveAgainst = new HashSet<Block>();

		blocksEffectiveAgainst.add(Hygienic.instance.blockPollution);
	}

	public ItemMop() {
		super(0, ToolMaterial.STONE, blocksEffectiveAgainst);
		this.texture = Textures.ITEM_MOP;
		this.maxStackSize = 1;
		this.setCreativeTab(Hygienic.hygienicTab);
		this.setUnlocalizedName("Mop");
	}

	@Override
	public void registerIcons(IIconRegister iconReg) {
		this.itemIcon = iconReg.registerIcon(this.texture);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
		if (block == Hygienic.instance.blockPollution) {
			item.damageItem(1, entityLivingBase);
		}
		return false;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	@Override
	public boolean isFull3D() {
		return true;
	}

}