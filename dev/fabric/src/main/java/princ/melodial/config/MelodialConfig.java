package princ.melodial.config;

import me.fzzyhmstrs.fzzy_config.annotations.Translation;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedChoice;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedEnum;
import net.minecraft.resources.ResourceLocation;
import princ.melodial.sounds.Musics;

import java.util.Arrays;

import static princ.melodial.MelodialConstants.*;

@Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX )
public class MelodialConfig extends Config {
    public MelodialConfig() {
        super(ResourceLocation.fromNamespaceAndPath(NAMESPACE, "general"), "", "", NAMESPACE);
    }

    public ValidatedChoice<Musics> playMusic1 = new ValidatedChoice<>(Musics.AERIE, Arrays.stream(Musics.values()).toList(), new ValidatedEnum<>(Musics.AERIE), ValidatedChoice.WidgetType.SCROLLABLE);
    public ValidatedChoice<Musics> playMusic2 = new ValidatedChoice<>(Musics.ARIA_MATH, Arrays.stream(Musics.values()).toList(), new ValidatedEnum<>(Musics.ARIA_MATH), ValidatedChoice.WidgetType.SCROLLABLE);
    public ValidatedChoice<Musics> playMusic3 = new ValidatedChoice<>(Musics.ENDLESS, Arrays.stream(Musics.values()).toList(), new ValidatedEnum<>(Musics.ENDLESS), ValidatedChoice.WidgetType.SCROLLABLE);
    public boolean musicToast = true;
    public ExtraConfig extra = new ExtraConfig();

    @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".extra" )
    public static class ExtraConfig extends ConfigSection {
        public boolean pauseForDiscs = true;
        public boolean forceKeepCurrentMusicTrack = true;
        public boolean continueMusicInPauseScreen = true;
    }
}
