package com.reach;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ModEventHandler {
    @SubscribeEvent
    public void onLogPlayer(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).setBaseValue(CommonConfig.reach);
    }

}
