package princ.melodial.sounds;

import me.fzzyhmstrs.fzzy_config.util.EnumTranslatable;

import static princ.melodial.MelodialConstants.GENERIC_CONFIG_TRANSLATION_PREFIX;

public enum MusicDelays implements EnumTranslatable {
    NONE(0),
    ONE_SECOND(20),
    THIRTY_SECONDS(600),
    TEN_MINUTES(12000),
    TWENTY_MINUTES(24000),
    FIVE_MINUTES(6000);

    private final int delay;

    MusicDelays(int i) {
        this.delay = i;
    }

    public int value() {
        return this.delay;
    }

    @Override
    public String prefix() {
        return GENERIC_CONFIG_TRANSLATION_PREFIX + ".musicDelays";
    }
}
