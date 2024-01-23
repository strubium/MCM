/*
 * Source: Bookshelf -- MoonPhases
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

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
public enum MoonPhaseUtil {

    FULL(0, "full"),
    WAXING_GIBBOUS(1, "waxing.gibbous"),
    FIRST_QUARTER(2, "first.quarter"),
    WAXING_CRESCENT(3, "waxing.crescent"),
    NEW_MOON(4, "new"),
    WANING_CRESCENT(5, "waning.crescent"),
    LAST_QUARTER(6, "last.quarter"),
    WANING_GIBBOUS(7, "waning.gibbous");

    private final int phase;

    private final String key;

    MoonPhaseUtil(int phase, String key) {

        this.phase = phase;
        this.key = key;
    }

    public int getPhase () {

        return this.phase;
    }

    public String getKey () {

        return this.key;
    }

    public static MoonPhaseUtil getPhase (int phase) {

        final int safePhase = phase < 0 ? 0 : Math.min(phase, 7);
        return MoonPhaseUtil.values()[safePhase];
    }

    @SideOnly(Side.CLIENT)
    public String getPhaseName () {

        return I18n.format("moon.phase." + this.key + ".name");
    }

    @SideOnly(Side.CLIENT)
    public static MoonPhaseUtil getCurrentPhase () {

        return getPhase(Minecraft.getMinecraft().world.getMoonPhase());
    }
}
