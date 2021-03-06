package net.darkhax.eplus.item;

import net.darkhax.eplus.EnchantingPlus;
import net.darkhax.eplus.handler.ContentHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBook extends ItemBlock {

    public static final String[] TYPES = new String[] { "eplus", "vanilla", "prismarine", "nether", "tartarite", "white", "metal" };

    public ItemBook () {

        super(ContentHandler.blockDecoration);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata (int damage) {

        return damage;
    }

    @Override
    public String getItemStackDisplayName (ItemStack stack) {

        return I18n.translateToLocal("item.eplus.book." + getName(stack.getMetadata()) + ".name");
    }

    public static String getName (int meta) {

        return meta >= 0 && meta < TYPES.length ? TYPES[meta] : "error";
    }

    @Override
    public void getSubItems (CreativeTabs tab, NonNullList<ItemStack> subItems) {

        if (this.isInCreativeTab(tab)) {
            for (int meta = 0; meta < TYPES.length; meta++) {
                subItems.add(new ItemStack(this, 1, meta));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab () {

        return EnchantingPlus.tabEplus;
    }
}
