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
    public static final KeyMapping choiceIKey = new KeyMapping(GENETIC_KEY_NAMESPACE + ".choiceI", InputConstants.Type.KEYSYM, InputConstants.KEY_Y, KEY_CATEGORY);
    public static final KeyMapping choiceIIKey = new KeyMapping(GENETIC_KEY_NAMESPACE + ".choiceII", InputConstants.Type.KEYSYM, InputConstants.KEY_U, KEY_CATEGORY);
    public static final KeyMapping choiceIIIKey = new KeyMapping(GENETIC_KEY_NAMESPACE + ".choiceIII", InputConstants.Type.KEYSYM, InputConstants.KEY_I, KEY_CATEGORY);
    public static final KeyMapping stopMusicKey = new KeyMapping(GENETIC_KEY_NAMESPACE + ".stopMusic", InputConstants.Type.KEYSYM, InputConstants.KEY_O, KEY_CATEGORY);

    public static void registerMappings() {
        KeyBindingHelper.registerKeyBinding(choiceIKey);
        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (choiceIKey.consumeClick()) musicManagerImpl().playMusic(config.choiceI.get().value());
        });

        KeyBindingHelper.registerKeyBinding(choiceIIKey);
        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (choiceIIKey.consumeClick()) musicManagerImpl().playMusic(config.choiceII.get().value());
        });

        KeyBindingHelper.registerKeyBinding(choiceIIIKey);
        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (choiceIIIKey.consumeClick()) musicManagerImpl().playMusic(config.choiceIII.get().value());
        });

        KeyBindingHelper.registerKeyBinding(stopMusicKey);
        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            if (stopMusicKey.consumeClick()) musicManagerImpl().stopMusic();
        });
    }
}
