package princ.melodial.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static princ.melodial.MelodialConstants.*;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow
    @Final
    private SoundManager soundManager;

    @Redirect(method = "pauseGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sounds/SoundManager;pause()V"))
    public void pauseGame(SoundManager soundManager) {
        if (!config.extra.continueMusicInPauseScreen) {
            soundManager.pause();
        }
    }

    @Redirect(method = "updateScreenAndTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sounds/SoundManager;stop()V"))
    public void updateScreenAndTick(SoundManager soundManager) {
        if (!config.extra.forceKeepCurrentMusicTrack) {
            soundManager.stop();
        }
    }
}