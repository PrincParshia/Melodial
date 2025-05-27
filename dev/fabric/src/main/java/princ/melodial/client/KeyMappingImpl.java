package princ.melodial.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;

import static princ.melodial.MelodialConstants.*;

@Environment(EnvType.CLIENT)
public class KeyMappingImpl {
    public static final KeyMapping playMusic1Key = new KeyMapping(GENETIC_KEY_NAMESPACE + ".playMusic1", InputConstants.Type.KEYSYM, InputConstants.KEY_H, KEY_CATEGORY);
    public static final KeyMapping playMusic2Key = new KeyMapping(GENETIC_KEY_NAMESPACE + ".playMusic2", InputConstants.Type.KEYSYM, InputConstants.KEY_J, KEY_CATEGORY);
    public static final KeyMapping playMusic3Key = new KeyMapping(GENETIC_KEY_NAMESPACE + ".playMusic3", InputConstants.Type.KEYSYM, InputConstants.KEY_K, KEY_CATEGORY);
    public static final KeyMapping stopMusicKey = new KeyMapping(GENETIC_KEY_NAMESPACE + ".stopMusic", InputConstants.Type.KEYSYM, InputConstants.KEY_Y, KEY_CATEGORY);

    public static void registerMappings() {
        KeyBindingHelper.registerKeyBinding(playMusic1Key);
        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (playMusic1Key.consumeClick()) musicManagerImpl().playMusic(config.playMusic1.get().value());
        });

        KeyBindingHelper.registerKeyBinding(playMusic2Key);
        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (playMusic2Key.consumeClick()) musicManagerImpl().playMusic(config.playMusic2.get().value());
        });

        KeyBindingHelper.registerKeyBinding(playMusic3Key);
        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (playMusic3Key.consumeClick()) musicManagerImpl().playMusic(config.playMusic3.get().value());
        });

        KeyBindingHelper.registerKeyBinding(stopMusicKey);
        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (stopMusicKey.consumeClick()) musicManagerImpl().stopMusic();
        });
    }
}
