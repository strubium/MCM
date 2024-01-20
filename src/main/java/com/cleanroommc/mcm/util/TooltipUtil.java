package com.cleanroommc.mcm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cleanroommc.mcm.internal.ITooltipInjector;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TooltipUtil
{
    private static final ThreadLocal<Map<String, String>> results = ThreadLocal.withInitial(HashMap::new);
    private static final ThreadLocal<Map<String, String>> currentVars = ThreadLocal.withInitial(HashMap::new);

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void tooltipEvt(ItemTooltipEvent evt)
    {
        try
        {
            List<String> tooltip = evt.getToolTip();

            Map<String, String> currentVars = TooltipUtil.currentVars.get();
            Map<String, String> results = TooltipUtil.results.get();

            currentVars.clear();

            currentVars.put("count", "" + evt.getItemStack().getCount());
            currentVars.put("damage", "" + evt.getItemStack().getItemDamage());
            currentVars.put("nbt", "" + evt.getItemStack().getTagCompound());

            if(evt.getItemStack().getItem() instanceof ITooltipInjector)
                ((ITooltipInjector) evt.getItemStack().getItem()).injectVariables(evt.getItemStack(), currentVars);

            int i = 0;
            while(true)
            {
                String b = evt.getItemStack().getTranslationKey() + ".tooltip" + i;
                String l = I18n.format(b);
                if(b.equals(l))
                    break;

                for(String var : currentVars.keySet())
                    l = l.replaceAll("&" + var, currentVars.get(var));

                try
                {
                    if(l.contains("parse[") && l.substring(l.indexOf("parse[")).contains("]"))
                    {
                        StringBuilder sput = new StringBuilder();
                        String toEat = l;
                        int size = 0;
                        while(toEat.contains("parse[") && toEat.substring(toEat.indexOf("parse[")).contains("]"))
                        {
                            int parseStart = toEat.indexOf("parse[");
                            sput.append(toEat.substring(0, parseStart));
                            String fullExpr = toEat.substring(parseStart);
                            fullExpr = fullExpr.substring(0, fullExpr.indexOf("]") + 1);
                            String expr = fullExpr.substring(6, fullExpr.length() - 1);

                            if(results.containsKey(expr)) {
                                sput.append(results.get(expr));
                            }
                            else {
                                try {

                                }
                                catch(Throwable err) {
                                    l = l.replaceAll(fullExpr, "ERROR: " + expr);
                                }
                            }

                            int s = parseStart + fullExpr.length();
                            size += s;
                            toEat = toEat.substring(s);
                        }
                        l = sput.toString();
                    }
                } catch(Throwable err) {
                }

                tooltip.add(l);
                ++i;
            }
        } catch(Throwable err)
        {
            // This happened once in LT for no reason
        }
    }
}