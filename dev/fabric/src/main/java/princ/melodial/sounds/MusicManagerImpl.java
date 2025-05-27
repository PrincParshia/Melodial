package princ.melodial.sounds;

import com.mojang.blaze3d.audio.Channel;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.MusicInfo;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundSource;
import princ.melodial.mixin.SoundEngineAccessor;
import princ.melodial.mixin.SoundManagerAccessor;

import java.util.Map;

import static princ.melodial.MelodialConstants.*;

public class MusicManagerImpl {
    private final MusicManager musicManager;

    public MusicManagerImpl(MusicManager musicManager) {
        this.musicManager = musicManager;
    }

    public void playMusic(Music music) {
        musicManager.stopPlaying();
        musicManager.startPlaying(new MusicInfo(music));
    }

    public void stopMusic() {
        musicManager.stopPlaying();
    }

    public void pauseMusic() {
        SoundEngine soundEngine = ((SoundManagerAccessor) soundManager()).soundEngine();
        Map<SoundInstance, ChannelAccess.ChannelHandle> instanceToChannel = ((SoundEngineAccessor) soundEngine).instanceToChannel();

        for (Map.Entry<SoundInstance, ChannelAccess.ChannelHandle> instanceToChannelEntrySet : instanceToChannel.entrySet()) {
            SoundInstance soundInstance = instanceToChannelEntrySet.getKey();
            ChannelAccess.ChannelHandle channelHandle = instanceToChannelEntrySet.getValue();

            if (soundInstance.getSource() == SoundSource.MUSIC && channelHandle != null) {
                channelHandle.execute(Channel::pause);
            }
        }
    }

    public void resumeMusic() {
        SoundEngine soundEngine = ((SoundManagerAccessor) soundManager()).soundEngine();
        Map<SoundInstance, ChannelAccess.ChannelHandle> instanceToChannel = ((SoundEngineAccessor) soundEngine).instanceToChannel();

        for (Map.Entry<SoundInstance, ChannelAccess.ChannelHandle> instanceToChannelEntry : instanceToChannel.entrySet()) {
            SoundInstance instance = instanceToChannelEntry.getKey();
            ChannelAccess.ChannelHandle channel = instanceToChannelEntry.getValue();

            if (instance.getSource() == SoundSource.MUSIC && channel != null) {
                channel.execute(Channel::unpause);
            }
        }
    }
}
