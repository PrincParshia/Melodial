package princ.melodial.mixin;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static princ.melodial.MelodialConstants.*;

@Mixin(SoundManager.class)
@SuppressWarnings("DataFlowIssue")
public class SoundManagerMixin {
    @Unique
    private SoundInstance currentMusicDisc;

    @Inject(method = "play", at = @At("HEAD"), cancellable = true)
    public void play(SoundInstance soundInstance, CallbackInfo ci) {
        if (soundInstance.getLocation().getPath().startsWith("music_disc.") && config.extra.pauseForDiscs) {
            this.currentMusicDisc = soundInstance;
        }
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tick(boolean bl, CallbackInfo ci) {
        if (this.currentMusicDisc != null) {
            boolean isActive = ((SoundManager)(Object) this).isActive(this.currentMusicDisc);
            if (isActive && config.extra.pauseForDiscs) {
                musicManagerImpl().pauseMusic();
            } else if (!isActive) {
                musicManagerImpl().resumeMusic();
                this.currentMusicDisc = null;
            }
        }
    }

}