/*
 * Source: Bookshelf -- MCColor
 * Copyright (C) 2024 Darkhax
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 3
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cleanroommc.mcm.util;

import java.awt.Color;
import java.util.Random;

import javax.annotation.Nonnull;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * This class is an extension of the AWT Color class. It adds several things which make working
 * with color in the MC environment less of a hassle.
 */
@SuppressWarnings("unused")
public class ColorUtil extends Color {

    /**
     * The color of black dye.
     */
    public static final ColorUtil DYE_BLACK = new ColorUtil(25, 25, 25);

    /**
     * The color of red dye.
     */
    public static final ColorUtil DYE_RED = new ColorUtil(153, 51, 51);

    /**
     * The color of green dye.
     */
    public static final ColorUtil DYE_GREEN = new ColorUtil(102, 127, 51);

    /**
     * The color of brown dye.
     */
    public static final ColorUtil DYE_BROWN = new ColorUtil(102, 76, 51);

    /**
     * The color of blue dye.
     */
    public static final ColorUtil DYE_BLUE = new ColorUtil(51, 76, 178);

    /**
     * The color of purple dye.
     */
    public static final ColorUtil DYE_PURPLE = new ColorUtil(127, 63, 178);

    /**
     * The color of cyan dye.
     */
    public static final ColorUtil DYE_CYAN = new ColorUtil(76, 127, 153);

    /**
     * The color of light gray dye.
     */
    public static final ColorUtil DYE_LIGHT_GRAY = new ColorUtil(153, 153, 153);

    /**
     * The color of gray dye.
     */
    public static final ColorUtil DYE_GRAY = new ColorUtil(76, 76, 76);

    /**
     * The color of pink dye.
     */
    public static final ColorUtil DYE_PINK = new ColorUtil(242, 127, 165);

    /**
     * The color of lime dye.
     */
    public static final ColorUtil DYE_LIME = new ColorUtil(127, 204, 25);

    /**
     * The color of yellow dye.
     */
    public static final ColorUtil DYE_YELLOW = new ColorUtil(229, 229, 51);

    /**
     * The color of blue dye.
     */
    public static final ColorUtil DYE_LIGHT_BLUE = new ColorUtil(102, 153, 216);

    /**
     * The color of magenta dye.
     */
    public static final ColorUtil DYE_MAGENTA = new ColorUtil(178, 76, 216);

    /**
     * The color of orange dye.
     */
    public static final ColorUtil DYE_ORANGE = new ColorUtil(216, 127, 5);

    /**
     * The color of white dye.
     */
    public static final ColorUtil DYE_WHITE = new ColorUtil(255, 255, 255);

    /**
     * An array of the vanilla colors.
     */
    public static final ColorUtil[] VANILLA_COLORS = { DYE_BLACK, DYE_RED, DYE_GREEN, DYE_BROWN, DYE_BLUE, DYE_PURPLE, DYE_CYAN, DYE_LIGHT_GRAY, DYE_GRAY, DYE_PINK, DYE_LIME, DYE_YELLOW, DYE_LIGHT_BLUE, DYE_MAGENTA, DYE_ORANGE, DYE_WHITE };

    /**
     * Constructs an ColorUtil from an ItemStack. Expects the stack to have already been checked
     * for validity.
     *
     * @param stack The ItemStack to construct a color from.
     */
    public ColorUtil(@Nonnull ItemStack stack) {

        this(stack.getTagCompound());
    }

    /**
     * Constructs an ColorUtil from a position in the world. Expects the position to have already
     * been checked for validity.
     *
     * @param world The World.
     * @param pos A position in the world.
     */
    public ColorUtil(IBlockAccess world, BlockPos pos) {

        this(world.getTileEntity(pos));
    }

    /**
     * Constructs an ColorUtil from a TileEntity. Expects the TileEntity to have already been
     * checked for validity.
     *
     * @param tile The TileEntity to construct a color from.
     */
    public ColorUtil(TileEntity tile) {

        this(tile.getTileData());
    }

    /**
     * Constructs an ColorUtil from an NBTTagCompound. Expects the tag to have already been
     * checked for validity.
     *
     * @param tag The NBTTagCompound to construct a color from.
     */
    public ColorUtil(@Nonnull NBTTagCompound tag) {

        this(tag.getIntArray("Color"));
    }

    /**
     * Constructs an ColorUtil from an array of color components. Expects the array to have
     * already been checked for validity.
     *
     * @param colors The array to construct a color from.
     */
    public ColorUtil(@Nonnull int[] colors) {

        this(colors[0], colors[1], colors[2]);
    }

    /**
     * Constructs an ColorUtil from raw color components.
     *
     * @param red The red component as an integer from 0 to 255.
     * @param green The green component as an integer from 0 to 255.
     * @param blue The blue component as an integer from 0 to 255.
     */
    public ColorUtil(int red, int green, int blue) {

        super(red, green, blue);
    }

    /**
     * Constructs an ColorUtil from the hashcode of a string.
     *
     * @param string The string to get a color for.
     */
    public ColorUtil(String string) {

        this(string.hashCode());
    }

    /**
     * Constructs an ColorUtil from a packed RGB integer.
     *
     * @param packed A packed RGB integer.
     */
    public ColorUtil(int packed) {

        super(packed);
    }

    /**
     * Writes the color object's data to the ItemStack's NBTTagCompound.
     *
     * @param stack The ItemStack to write the color data to.
     */
    public void writeToStack (@Nonnull ItemStack stack) {

        this.writeToNBT(stack.getTagCompound());
    }

    /**
     * Writes the color object's data to the NBTTagCompound.
     *
     * @param tag The NBTTagCompound to write the color data to.
     */
    public void writeToNBT (@Nonnull NBTTagCompound tag) {

        tag.setIntArray("Color", new int[] { this.getRed(), this.getGreen(), this.getBlue() });
    }

    /**
     * Gets the components as an integer array.
     *
     * @return The components as an integer array.
     */
    public int[] getComponents () {

        return new int[] { this.getRed(), this.getGreen(), this.getBlue() };
    }

    public float getRedF () {

        return this.getRed() / 255f;
    }

    public float getGreenF () {

        return this.getGreen() / 255f;
    }

    public float getBlueF () {

        return this.getBlue() / 255f;
    }

    public void setRenderColor () {

        GlStateManager.color(this.getRed(), this.getGreen(), this.getBlue());
    }

    /**
     * Creates a random ColorUtil.
     *
     * @param rand An instance of Random.
     * @return A random ColorUtil.
     */
    public static ColorUtil getRandomColor (@Nonnull Random rand) {

        return new ColorUtil(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    /**
     * Checks if an ItemStack is acceptable. For an ItemStack to be acceptable, it must not be
     * null or empty, and must have an NBTTagCompound which is deemed acceptable by
     * {@link #isAcceptable(NBTTagCompound)}.
     *
     * @param stack The ItemStack to check.
     * @return Whether or not the ItemStack was acceptable.
     */
    public static boolean isAcceptable (@Nonnull ItemStack stack) {

        return !stack.isEmpty() && stack.hasTagCompound() && isAcceptable(stack.getTagCompound());
    }

    /**
     * Checks if a tile entity at a given position in the world is acceptable. Check
     * {@link #isAcceptable(TileEntity)} for more info.
     *
     * @param world The world to check in.
     * @param pos The pos to check at.
     * @return Whether or not the TileEntity was acceptable.
     */
    public static boolean isAcceptable (@Nonnull IBlockAccess world, @Nonnull BlockPos pos) {

        return isAcceptable(world.getTileEntity(pos));
    }

    /**
     * Checks if a tile entity is acceptable. For a TileEntity to be acceptable, it must not be
     * null or invalid, and must have an NBTTagCompound which is deemed acceptable by
     * {@link #isAcceptable(NBTTagCompound)}.
     *
     * @param tile The TileEntity to check.
     * @return Whether or not the TileEntity was acceptable.
     */
    public static boolean isAcceptable (@Nonnull TileEntity tile) {

        return tile != null && !tile.isInvalid() && isAcceptable(tile.getTileData());
    }

    /**
     * Checks if a NBTTagCompound is acceptable. For an NBTTagCompound to be acceptable, it
     * must not be null, and must have an integer array named Color with 3 elements.
     *
     * @param tag The NBTTagCompound to check.
     * @return Whether or not the ItemStack was acceptable.
     */
    public static boolean isAcceptable (@Nonnull NBTTagCompound tag) {

        return tag.hasKey("Color") && tag.getIntArray("Color").length == 3;
    }
}