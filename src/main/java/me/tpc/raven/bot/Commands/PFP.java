package me.tpc.raven.bot.Commands;

import me.tpc.raven.bot.Bot;
import me.tpc.raven.bot.Helpers.StringUtils;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.List;

public class PFP extends ListenerAdapter {
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();

        if(StringUtils.startsWithIgnoreCase(msg.getContentRaw(), Bot.CMD_PREFIX + "pfp")) {
            List<Member> mentioned = msg.getMentionedMembers();
            if(mentioned.isEmpty()) {
                String[] parts = msg.getContentRaw().split(" "); // !pfp user_id
                if(parts.length == 2) {
                    User user = event.getJDA().getUserById(parts[1]);
                    if(user == null) {
                        channel.sendMessage("Please provide a user ID or mention").queue();
                    } else {
                        channel.sendMessage(user.getEffectiveAvatarUrl()).queue();
                    }
                } else {
                    channel.sendMessage("Please provide a user ID or mention").queue();
                }
            } else {
                for(Member m : mentioned) {
                    channel.sendMessage(m.getEffectiveAvatarUrl()).queue();
                }
            }
        }

    }

}
