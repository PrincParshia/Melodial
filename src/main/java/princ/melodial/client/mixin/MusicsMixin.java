package princ.melodial.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static princ.melodial.MelodialConstants.config;

@Mixin(Musics.class)
@Environment(EnvType.CLIENT)
public class MusicsMixin {
    @Shadow
    @Final
    @Mutable
    public static Music MENU;

    @Shadow
    @Final
    @Mutable
    public static Music CREATIVE;

    @Shadow
    @Final
    @Mutable
    public static Music CREDITS;

    @Shadow
    @Final
    @Mutable
    public static Music END_BOSS;

    @Shadow
    @Final
    @Mutable
    public static Music END;

    @Shadow
    @Final
    @Mutable
    public static Music UNDER_WATER;

    @Shadow
    @Final
    @Mutable
    public static Music GAME;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyDelays(CallbackInfo ci) {
        MENU = new Music(SoundEvents.MUSIC_MENU, config.delays.menu.min.get().value(), config.delays.menu.max.get().value(), true);
        CREATIVE = new Music(SoundEvents.MUSIC_CREATIVE, config.delays.creative.min.get().value(), config.delays.creative.max.get().value(), false);
        CREDITS = new Music(SoundEvents.MUSIC_CREDITS, config.delays.credits.min.get().value(), config.delays.credits.max.get().value(), true);
        END_BOSS = new Music(SoundEvents.MUSIC_DRAGON, config.delays.endBoss.min.get().value(), config.delays.endBoss.max.get().value(), true);
        END = new Music(SoundEvents.MUSIC_END, config.delays.end.min.get().value(), config.delays.end.max.get().value(), true);
        UNDER_WATER = new Music(SoundEvents.MUSIC_UNDER_WATER, config.delays.underWater.min.get().value(), config.delays.underWater.max.get().value(), false);
        GAME = new Music(SoundEvents.MUSIC_GAME, config.delays.game.min.get().value(), config.delays.game.max.get().value(), false);
    }
}
