package me.tpc.raven.bot.Commands;

import me.tpc.raven.bot.Bot;
import me.tpc.raven.bot.Helpers.EmbedBuilderHelper;
import me.tpc.raven.bot.Helpers.StringUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class Help extends ListenerAdapter {
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();

        if(StringUtils.hasCommand(Bot.CMD_PREFIX + "help", msg.getContentRaw(), false)) {
            EmbedBuilderHelper embed = new EmbedBuilderHelper(Color.GREEN, "RavenBot Help", "RavenBot Usage Information");
            embed.newBlankField(false);
            embed.newField(Bot.CMD_PREFIX + "pfp", "Returns the Profile picture for a given user", false);
            channel.sendMessageEmbeds(embed.build()).queue();
        }
    }
}
