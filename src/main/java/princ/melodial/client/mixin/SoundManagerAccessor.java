package princ.melodial.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SoundManager.class)
@Environment(EnvType.CLIENT)
public interface SoundManagerAccessor {
    @Accessor("soundEngine")
    SoundEngine soundEngine();
}
