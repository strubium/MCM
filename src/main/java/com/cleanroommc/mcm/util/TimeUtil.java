/*
 * Source: SilentLib - TimeHelper
 * Copyright (C) 2018 SilentChaos512
 *
 * This library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cleanroommc.mcm.util;

@SuppressWarnings("unused")
public final class TimeUtil {
    /*
     * TODO get the servers tps, instead of using a static variable
     */
    public static final int TICKS_PER_SECOND = 20;
    public static final int VANILLA_DAY_LENGTH = 24000;

    private TimeUtil() {
        throw new IllegalAccessError("TimeUtil is a utility class!");
    }

    public static int ticksFromSeconds(float seconds) {
        return (int) (TICKS_PER_SECOND * seconds);
    }

    public static int secondsFromTicks(int ticks) {
        return (ticks / TICKS_PER_SECOND);
    }

    public static int ticksFromMinutes(float minutes) {
        return (int) (TICKS_PER_SECOND * 60 * minutes);
    }

    public static int minutesFromTicks(int ticks) {
        return (ticks / (60 * 60));
    }

    public static int ticksFromHours(float hours) {
        return (int) (TICKS_PER_SECOND * 60 * 60 * hours);
    }
}
