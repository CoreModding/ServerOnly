package info.coremodding.serveronly;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * @author James
 *         The main mod class
 */
public class ServerOnly
{
    
    /**
     * @param evt
     *            The event that triggered the method
     */
    @EventHandler
    public void postinit(FMLPostInitializationEvent evt)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /**
     * Handles the entityjoinworldevent so that once the player (or anything
     * else) spawns, it ends.
     * 
     * @param evt
     *            The event that triggered the method
     */
    @SuppressWarnings("static-method")
    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent evt)
    {
        if (MinecraftServer.getServer() instanceof IntegratedServer)
        {
            Minecraft.stopIntegratedServer();
        }
    }
}
