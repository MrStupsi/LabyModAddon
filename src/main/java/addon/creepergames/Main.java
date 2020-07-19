package addon.creepergames;

import java.util.List;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.minecraftforge.client.event.GuiScreenEvent.KeyboardInputEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class Main extends LabyModAddon {
	private static LabyModAddon addon;
	
	@Override
	public void onEnable() {
		addon = this;
		getApi().registerServerSupport(this, new CreeperGamesServer());
		getApi().registerForgeListener(this);
	}
	
	@Override
	public void loadConfig() {
		if (!getConfig().has("zweiterchat")) {getConfig().addProperty("zweiterchat", true);}
		saveConfig();
	}
	
	@Override
	protected void fillSettings(List<SettingsElement> list) {
		BooleanElement zweiterChat = new BooleanElement(
				"Private Nachrichten 2. Chat",
				new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"),
				new Consumer<Boolean>() {
					public void accept(Boolean zweiterchat) {
						getConfig().remove("zweiterchat");
						getConfig().addProperty("zweiterchat", zweiterchat);
						saveConfig();
					}
				},
				getConfig().get("zweiterchat").getAsBoolean());
	    list.add(zweiterChat);
	}
	
	public static LabyModAddon getAddon() {
		return addon;
	}
	
	@SubscribeEvent
	public void onTick(ClientTickEvent e) {
		
	}
	
	@SubscribeEvent
	public void onKey(KeyboardInputEvent e) {
		
	}
}