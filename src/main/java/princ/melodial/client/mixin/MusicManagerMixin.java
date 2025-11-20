package princ.melodial.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicInfo;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import princ.melodial.client.gui.components.toasts.MusicToast;

import static princ.melodial.MelodialConstants.*;

@Mixin(MusicManager.class)
@Environment(EnvType.CLIENT)
public class MusicManagerMixin {
    @Shadow
    private SoundInstance currentMusic;

    @Inject(method = "startPlaying", at = @At("RETURN"))
    public void startPlaying(MusicInfo musicInfo, CallbackInfo ci) {
        if (this.currentMusic != null && this.currentMusic.getSound() != null && config.musicToast) {
            MusicToast.addOrUpdate(toastManager(), Component.translatable(getMusicName()), Component.literal("by " + getMusicArtist()));
        }
    }
}
