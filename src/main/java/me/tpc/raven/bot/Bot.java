package me.tpc.raven.bot;

import me.tpc.raven.bot.Commands.Help;
import me.tpc.raven.bot.Commands.PFP;
import me.tpc.raven.bot.Listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {
    private static final String TOKEN = "TOKEN_HERE";
    public static final String CMD_PREFIX = "rb!";

    public static void main(String[] args) {
        Bot bot = new Bot();
        bot.prepareJDA();
    }

    private JDA prepareJDA() {
        try {
            JDA api = JDABuilder.createDefault(Bot.TOKEN)
                    .addEventListeners(
                            new MessageListener(),
                            new PFP(),
                            new Help()
                    )
                    .build()
                    .awaitReady();
            return api;
        } catch(LoginException | InterruptedException e) {
            System.out.println("Login auth or await ready failed");
            System.exit(-1);
        }
        return null;
    }
}
