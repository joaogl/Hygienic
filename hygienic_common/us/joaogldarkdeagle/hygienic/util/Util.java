package us.joaogldarkdeagle.hygienic.util;

import net.minecraft.util.ChatMessageComponent;

public class Util {
    
    public static ChatMessageComponent buildChatMessageComponent(String text) {
        return ChatMessageComponent.createFromJson("{ text: '" + text + "' }");
    }
}