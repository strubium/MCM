/**
 * This class was created by <Darkhax>. It is distributed as part of Bookshelf. You can find
 * the original source here: https://github.com/Darkhax-Minecraft/Bookshelf
 *
 * Bookshelf is Open Source and distributed under the GNU Lesser General Public License version
 * 2.1.
 */
package com.cleanroommc.mcm.util;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.Random;

@SuppressWarnings("unused")
public class VillageTradeUtil implements ITradeList {

    private final ItemStack buyFirst;
    private final PriceInfo priceFirst;

    private final ItemStack buySecond;
    private final PriceInfo priceSecond;

    private final ItemStack product;
    private final PriceInfo amount;

    public VillageTradeUtil(int minEmeralds, int maxEmeralds, ItemStack product) {

        this(minEmeralds, maxEmeralds, product, product.getCount(), product.getCount());
    }

    public VillageTradeUtil(int minEmeralds, int maxEmeralds, ItemStack product, int minProduct, int maxProduct) {

        this(minEmeralds, maxEmeralds, ItemStack.EMPTY, 0, 0, product, minProduct, maxProduct);
    }

    public VillageTradeUtil(int minEmeralds, int maxEmeralds, ItemStack buySecond, int buySecondMin, int buySecondMax, ItemStack product, int minProduct, int maxProduct) {

        this(new ItemStack(Items.EMERALD), minEmeralds, maxEmeralds, buySecond, buySecondMin, buySecondMax, product, minProduct, maxProduct);
    }

    public VillageTradeUtil(ItemStack buyFirst, int buyFirstMin, int buyFirstMax, ItemStack buySecond, int buySecondMin, int buySecondMax, ItemStack product, int productMin, int productMax) {

        this.buyFirst = buyFirst;
        this.priceFirst = new PriceInfo(buyFirstMin, buyFirstMax);

        this.buySecond = buySecond;
        this.priceSecond = new PriceInfo(buySecondMin, buySecondMax);

        this.product = product;
        this.amount = new PriceInfo(productMin, productMax);
    }

    @Override
    public void addMerchantRecipe (IMerchant merchant, MerchantRecipeList recipeList, Random random) {

        final ItemStack buy = this.buyFirst.copy();
        buy.setCount(this.priceFirst.getPrice(random));

        final ItemStack buy2 = this.buySecond.copy();
        buy2.setCount(this.priceSecond.getPrice(random));

        final ItemStack output = this.product.copy();
        output.setCount(this.amount.getPrice(random));

        recipeList.add(new MerchantRecipe(buy, buy2, output));
    }
}