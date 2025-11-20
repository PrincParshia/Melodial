package princ.melodial.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MusicManager.class)
@Environment(EnvType.CLIENT)
public interface MusicManagerAccessor {
    @Accessor("currentMusic")
    SoundInstance currentMusic();
}
