package addon.creepergames;

import java.util.List;

import net.labymod.api.events.TabListEvent.Type;
import net.labymod.servermanager.ChatDisplayAction;
import net.labymod.servermanager.Server;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.PacketBuffer;

public class CreeperGamesServer extends Server {
	public CreeperGamesServer() {
		super("CreeperGames", "creepergames.serveminecraft.net");
	}
	
	@Override
	public void fillSubSettings(List<SettingsElement> list) {
		
	}
	
	@Override
	public ChatDisplayAction handleChatMessage(String unformatted, String formatted) throws Exception {
		if (Main.getAddon().getConfig().get("zweiterchat").getAsBoolean()) {
			if (unformatted.startsWith("[mir -> ")) {
				return ChatDisplayAction.SWAP;
			}
			if (unformatted.contains("-> mir]")) {
				return ChatDisplayAction.SWAP;
			}
			if (unformatted.startsWith("[Plot-Chat]")) {
				return ChatDisplayAction.SWAP;
			}
			if (unformatted.startsWith("[Spectator-Chat]")) {
				return ChatDisplayAction.SWAP;
			}
			/*if (unformatted.startsWith("[Global]")) {
				return ChatDisplayAction.SWAP;
			}
			if (unformatted.endsWith(": gg") || unformatted.endsWith(": Gg") ||
					unformatted.endsWith(": gG") || unformatted.endsWith(": GG")) {
				return ChatDisplayAction.SWAP;
			}
			if (unformatted.endsWith(": bg") || unformatted.endsWith(": Bg") ||
					unformatted.endsWith(": bG") || unformatted.endsWith(": BG")) {
				return ChatDisplayAction.SWAP;
			}*/
		}
		return null;
	}
	
	@Override
	public void handlePluginMessage(String arg0, PacketBuffer arg1) throws Exception {
		
	}
	
	@Override
	public void handleTabInfoMessage(Type arg0, String arg1, String arg2) throws Exception {
		
	}
	
	@Override
	public void onJoin(ServerData data) {
		
	}
}
