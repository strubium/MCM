/*
 * Source: Bookshelf -- Blockstates
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

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;

public final class BlockstateUtil {

    /**
     * Utility classes, such as this one, are not meant to be instantiated. Java adds an
     * implicit public constructor to every class which does not define at lease one
     * explicitly. Hence why this constructor was added.
     */
    private BlockstateUtil() {

        throw new IllegalAccessError("BlockstateUtil is a utility class!");
    }

    /**
     * Used to handle whether or not the block is on or off. Used mainly by redstone blocks.
     */
    public static final PropertyBool POWERED = PropertyBool.create("powered");

    /**
     * Used to determine the color of a block. Only supports the 16 vanilla colors.
     */
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);

    /**
     * Used to determine the direction a block is facing.
     */
    public static final PropertyEnum<EnumFacing> FACING = PropertyEnum.create("facing", EnumFacing.class);

    /**
     * Used to determine the direction a block is facing. Only includes horizontal directions.
     * (N-S-W-E)
     */
    public static final PropertyDirection HORIZONTAL = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    /**
     * Used to determine if a block is connected on the bottom face.
     */
    public static final PropertyBool CONNECTED_DOWN = PropertyBool.create("connected_down");

    /**
     * Used to determine if a block is connected on the upward face.
     */
    public static final PropertyBool CONNECTED_UP = PropertyBool.create("connected_up");

    /**
     * Used to determine if a block is connected on the northern face.
     */
    public static final PropertyBool CONNECTED_NORTH = PropertyBool.create("connected_north");

    /**
     * Used to determine if a block is connected on the southern face.
     */
    public static final PropertyBool CONNECTED_SOUTH = PropertyBool.create("connected_south");

    /**
     * Used to determine if a block is connected on the eastern face.
     */
    public static final PropertyBool CONNECTED_EAST = PropertyBool.create("connected_east");

    /**
     * Used to determine if a block is connected on the western face.
     */
    public static final PropertyBool CONNECTED_WEST = PropertyBool.create("connected_west");

    /**
     * Used to determine if a block has been enabled or not.
     */
    public static final PropertyBool ENABLED = PropertyBool.create("enabled");

}