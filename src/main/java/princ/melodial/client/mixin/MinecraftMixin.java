package princ.melodial.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static princ.melodial.MelodialConstants.config;

@Mixin(Minecraft.class)
@Environment(EnvType.CLIENT)
public class MinecraftMixin {
    @Redirect(method = "updateLevelInEngines", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sounds/SoundManager;stop()V"))
    public void updateLevelInEngines(SoundManager soundManager) {
        if (!config.misc.forceKeepCurrentTrack) {
            soundManager.stop();
        }
    }
}