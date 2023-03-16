package com.licker2689.lpc.api.discord;

import com.licker2689.lpc.LPCore;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DiscordAPI {
    private static final LPCore plugin = LPCore.getInstance();
    private static JDA jda;
    public static void init() {
        String token = LPCore.getInstance().config.getString("Settings.discord-bot-token");
        if(token == null){
            plugin.log.warning("디스코드 봇 토큰이 설정되지 않았습니다.");
            plugin.log.warning("Discord API 사용 불가.");
            return;
        }
        jda = JDABuilder.createDefault(token).build();
    }

    public static JDA getJDA(){
        return jda;
    }
}
