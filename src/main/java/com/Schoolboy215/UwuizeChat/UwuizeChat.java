package com.Schoolboy215.UwuizeChat;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(UwuizeChat.MOD_ID)
public class UwuizeChat {

    public static final String MOD_ID = "uwuizechat";

    public UwuizeChat() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void onSendingChat(ClientChatEvent event) {
        event.setMessage(this.uwuizeString(event.getMessage()));
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    @SubscribeEvent
    public void onPlayerSendingChat(ServerChatEvent event) {
        TranslatableComponent textComponent = (TranslatableComponent) event.getComponent();
        Object[] args = textComponent.getArgs();
        args[1] = this.uwuizeString((String) args[1]);
        event.setComponent(textComponent);
    }

    private String uwuizeString(String _text)
    {
        String ret = _text;

        ret = ret.replaceAll("(?:r|l)","w");
        ret = ret.replaceAll("(?:R|L)", "W");

        ret = ret.replaceAll("n([aeiou])", "ny$1");
        ret = ret.replaceAll("N([aeiou])", "Ny$1");
        ret = ret.replaceAll("N([AEIOU])", "NY$1");

        ret = ret.replaceAll("ove", "uv");
        ret = ret.replaceAll("OVE", "UV");

        return ret;
    }

}
