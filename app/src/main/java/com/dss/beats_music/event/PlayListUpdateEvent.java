package com.dss.beats_music.event;

public class PlayListUpdateEvent {
    public long updatePlayListId;

    public PlayListUpdateEvent(long playListId) {
        this.updatePlayListId = playListId;
    }
}
