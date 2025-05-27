package princ.melodial.client;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import princ.melodial.config.MelodialConfig;

@Environment(EnvType.CLIENT)
public class Melodial implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ConfigApiJava.registerAndLoadConfig(MelodialConfig::new, RegisterType.CLIENT);
		KeyMappingImpl.registerMappings();
	}
}