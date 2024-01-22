/*
 * Source: ForgeEssentials -- PlayerWallet
 * Copyright (C) 2024 ForgeEssentials
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

package com.cleanroommc.mcm.economy;

@SuppressWarnings("unused")
public class PlayerWallet
{

    private long amount;

    private double fraction;

    public PlayerWallet(long amount)
    {
        this.amount = amount;
    }

    public long get()
    {
        return amount;
    }

    public void set(long value)
    {
        this.amount = value;
    }

    public boolean covers(long value)
    {
        if (amount < value)
            return false;
        return true;
    }

    public boolean withdraw(long value)
    {
        if (amount < value)
            return false;
        amount -= value;
        return true;
    }

    public void add(long amount)
    {
        this.amount += amount;
    }

    public void add(double amount)
    {
        this.fraction += amount;
        long rest = (long) fraction;
        this.fraction -= rest;
        this.amount += rest;
    }

    public String toString()
    {
        return toString();
    }

}