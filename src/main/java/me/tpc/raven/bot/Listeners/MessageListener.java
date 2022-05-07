package me.tpc.raven.bot.Listeners;

import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MessageListener extends ListenerAdapter {

    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        System.out.println(event.getMessage().getContentRaw());
    }

    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
        if(event.getUser().isBot()) return;
        String emo = "";
        MessageReaction.ReactionEmote emote = event.getReactionEmote();
        if(emote.isEmoji()) {
            System.out.println("isEmoji is true");
            emo = emote.getEmoji();
        } else if (emote.isEmote()) {
            System.out.println("isEmote is true");
            emo = emote.getEmote().getAsMention();
        }

        event.getChannel().sendMessage(emo).queue();
    }
}
