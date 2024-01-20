/*
 * Source: HammerLib -- FluidDictionary
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

package com.cleanroommc.mcm.dict;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.Event;

import static com.cleanroommc.mcm.ModRef.LOG;

public class FluidDictionary
{
	private static boolean hasInit = false;
	
	private static final Map<String, List<String>> idToFn = Maps.newHashMapWithExpectedSize(96);
	private static final Map<String, String> fnToId = Maps.newHashMapWithExpectedSize(96);
	private static final Map<String, NonNullList<FluidStack>> fnToStack = Maps.newHashMapWithExpectedSize(96);
	
	static
	{
		initVanillaEntries();
	}
	
	private static void initVanillaEntries()
	{
		if(!hasInit)
		{
			registerFluid(FluidRegistry.WATER, "water");
			registerFluid(FluidRegistry.LAVA, "lava");
			hasInit = true;
		}
	}
	
	public static void registerFluid(Fluid fluid, String fname)
	{
		registerFluid(fluid, fname, null);
	}
	
	public static void registerFluid(Fluid fluid, String fname, NBTTagCompound fluidTags)
	{
		registerFluid(new FluidStack(fluid, 1, fluidTags), fname);
	}
	
	public static void registerFluid(FluidStack fluid, String fname)
	{
		if(isEmpty(fluid))
		{
			LOG.warn("Invalid registration attempt for a Fluid Dictionary fluid with name %s has occurred. The registration has been denied to prevent crashes. The mod responsible for the registration needs to correct this.", fname);
			return;
		}
		
		String id = getFluidId(fluid);
		
		getNamesByFluidId(id).add(fname);
		fnToId.put(fname, id);
		getFluidsByName(fname).add(fluid);
		
		MinecraftForge.EVENT_BUS.post(new FluidRegisterEvent(fname, fluid));
	}
	
	public static List<String> getNamesByFluidId(String id)
	{
		List<String> l = idToFn.get(id);
		if(l == null)
			idToFn.put(id, l = new ArrayList<String>());
		return l;
	}
	
	public static NonNullList<FluidStack> getFluidsByName(String fname)
	{
		NonNullList<FluidStack> l = fnToStack.get(fname);
		if(l == null)
			fnToStack.put(fname, l = NonNullList.create());
		return l;
	}
	
	public static String getFluidId(FluidStack stack)
	{
		if(isEmpty(stack))
			return "";
		return FluidRegistry.getFluidName(stack) + "^" + stack.tag;
	}
	
	public static String[] getFluidNames()
	{
		return fnToId.keySet().toArray(new String[0]);
	}
	
	public static boolean isEmpty(FluidStack stack)
	{
		return stack == null || stack.amount < 1 || stack.getFluid() == null;
	}
	
	public static class FluidRegisterEvent extends Event
	{
		private final String Name;
		private final FluidStack Fluid;
		
		public FluidRegisterEvent(String name, @Nonnull FluidStack fluid)
		{
			this.Name = name;
			this.Fluid = fluid;
		}
		
		public String getName()
		{
			return Name;
		}
		
		@Nonnull
		public FluidStack getFluid()
		{
			return Fluid;
		}
	}
}
