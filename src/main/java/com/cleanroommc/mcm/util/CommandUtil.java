/**
 * This class was created by <Darkhax>. It is distributed as part of Bookshelf. You can find
 * the original source here: https://github.com/Darkhax-Minecraft/Bookshelf
 *
 * Bookshelf is Open Source and distributed under the GNU Lesser General Public License version
 * 2.1.
 */
package com.cleanroommc.mcm.util;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

/**
 * This class is a new implementation of CommandBase, which adds working permission levels.
 */
@SuppressWarnings("unused")
public abstract class CommandUtil extends CommandBase {

    @Override
    public boolean checkPermission (MinecraftServer server, ICommandSender sender) {

        return this.getRequiredPermissionLevel() <= 0 || super.checkPermission(server, sender);
    }
}