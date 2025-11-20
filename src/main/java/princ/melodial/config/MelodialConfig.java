package princ.melodial.config;

import me.fzzyhmstrs.fzzy_config.annotations.Translation;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedChoice;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedEnum;
import net.minecraft.resources.ResourceLocation;
import princ.melodial.sounds.MusicDelays;
import princ.melodial.sounds.Musics;

import java.util.Arrays;

import static princ.melodial.MelodialConstants.*;

@Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX )
public class MelodialConfig extends Config {
    public MelodialConfig() {
        super(ResourceLocation.fromNamespaceAndPath(NAMESPACE, "general"), "", "", NAMESPACE);
    }

    public Delays delays = new Delays();

    @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".delays")
    public static class Delays extends ConfigSection {
        public Menu menu = new Menu();
        public Creative creative = new Creative();
        public Credits credits = new Credits();
        public EndBoss endBoss = new EndBoss();
        public End end = new End();
        public UnderWater underWater = new UnderWater();
        public Game game = new Game();

        @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".delays")
        public static class Menu extends ConfigSection {
            public ValidatedChoice<MusicDelays> min = new ValidatedChoice<>(MusicDelays.ONE_SECOND, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.ONE_SECOND), ValidatedChoice.WidgetType.SCROLLABLE);
            public ValidatedChoice<MusicDelays> max = new ValidatedChoice<>(MusicDelays.THIRTY_SECONDS, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.THIRTY_SECONDS), ValidatedChoice.WidgetType.SCROLLABLE);
        }

        @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".delays")
        public static class Creative extends ConfigSection {
            public ValidatedChoice<MusicDelays> min = new ValidatedChoice<>(MusicDelays.TEN_MINUTES, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.TEN_MINUTES), ValidatedChoice.WidgetType.SCROLLABLE);
            public ValidatedChoice<MusicDelays> max = new ValidatedChoice<>(MusicDelays.TWENTY_MINUTES, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.TWENTY_MINUTES), ValidatedChoice.WidgetType.SCROLLABLE);
        }

        @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".delays")
        public static class Credits extends ConfigSection {
            public ValidatedChoice<MusicDelays> min = new ValidatedChoice<>(MusicDelays.NONE, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.NONE), ValidatedChoice.WidgetType.SCROLLABLE);
            public ValidatedChoice<MusicDelays> max = new ValidatedChoice<>(MusicDelays.NONE, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.NONE), ValidatedChoice.WidgetType.SCROLLABLE);
        }

        @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".delays")
        public static class EndBoss extends ConfigSection {
            public ValidatedChoice<MusicDelays> min = new ValidatedChoice<>(MusicDelays.NONE, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.NONE), ValidatedChoice.WidgetType.SCROLLABLE);
            public ValidatedChoice<MusicDelays> max = new ValidatedChoice<>(MusicDelays.NONE, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.NONE), ValidatedChoice.WidgetType.SCROLLABLE);
        }

        @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".delays")
        public static class End extends ConfigSection {
            public ValidatedChoice<MusicDelays> min = new ValidatedChoice<>(MusicDelays.FIVE_MINUTES, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.FIVE_MINUTES), ValidatedChoice.WidgetType.SCROLLABLE);
            public ValidatedChoice<MusicDelays> max = new ValidatedChoice<>(MusicDelays.TWENTY_MINUTES, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.TWENTY_MINUTES), ValidatedChoice.WidgetType.SCROLLABLE);
        }

        @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".delays")
        public static class UnderWater extends ConfigSection {
            public ValidatedChoice<MusicDelays> min = new ValidatedChoice<>(MusicDelays.TEN_MINUTES, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.TEN_MINUTES), ValidatedChoice.WidgetType.SCROLLABLE);
            public ValidatedChoice<MusicDelays> max = new ValidatedChoice<>(MusicDelays.TWENTY_MINUTES, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.TWENTY_MINUTES), ValidatedChoice.WidgetType.SCROLLABLE);
        }

        @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".delays")
        public static class Game extends ConfigSection {
            public ValidatedChoice<MusicDelays> min = new ValidatedChoice<>(MusicDelays.TEN_MINUTES, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.TEN_MINUTES), ValidatedChoice.WidgetType.SCROLLABLE);
            public ValidatedChoice<MusicDelays> max = new ValidatedChoice<>(MusicDelays.TWENTY_MINUTES, Arrays.stream(MusicDelays.values()).toList(), new ValidatedEnum<>(MusicDelays.TWENTY_MINUTES), ValidatedChoice.WidgetType.SCROLLABLE);
        }
    }

    public ValidatedChoice<Musics> choiceI = new ValidatedChoice<>(Musics.AERIE, Arrays.stream(Musics.values()).toList(), new ValidatedEnum<>(Musics.AERIE), ValidatedChoice.WidgetType.SCROLLABLE);
    public ValidatedChoice<Musics> choiceII = new ValidatedChoice<>(Musics.ARIA_MATH, Arrays.stream(Musics.values()).toList(), new ValidatedEnum<>(Musics.ARIA_MATH), ValidatedChoice.WidgetType.SCROLLABLE);
    public ValidatedChoice<Musics> choiceIII = new ValidatedChoice<>(Musics.ENDLESS, Arrays.stream(Musics.values()).toList(), new ValidatedEnum<>(Musics.ENDLESS), ValidatedChoice.WidgetType.SCROLLABLE);
    public boolean musicToast = true;
    public Misc misc = new Misc();

    @Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX + ".misc" )
    public static class Misc extends ConfigSection {
        public boolean pauseForDiscs = true;
        public boolean forceKeepCurrentTrack = true;
    }
}
