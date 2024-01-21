/*
 * Source: HammerLib -- ITooptipInjector
 * Copyright (C) 2024 Zeitheron
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

package com.cleanroommc.mcm.internal;

import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Implementation for {@link Item}s that use custom tooltip. Allows to inject
 * variables. Can be used to make dynamic tooltips with custom vars. They are
 * replaced with $VARNAME There is now calculation feature. Use it like this:
 * parse[PI * 2 + (-2) ^ 2]
 */
@SuppressWarnings("unused")
public interface ITooltipInjector
{
    /**
     * Injects variables to vars map. Use vars.put("test", "This is a test
     * variable!"); Will replace "$test" with "This is a test variable!"
     */
     void injectVariables(ItemStack stack, Map<String, String> vars);
}