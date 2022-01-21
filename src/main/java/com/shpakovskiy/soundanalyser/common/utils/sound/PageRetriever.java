package com.shpakovskiy.soundanalyser.common.utils.sound;

import com.shpakovskiy.soundanalyser.model.Sound;

public class PageRetriever {
    //TODO: Think of better name
    public static int[] retrieveSoundRange(Sound sound, int offset, int limit) {
        int signalRangeLength = Math.min(sound.getRawValues().length - offset, limit);
        int[] signalRange = new int[signalRangeLength];
        System.arraycopy(sound.getRawValues(), offset, signalRange, 0, signalRangeLength);
        return signalRange;
    }
}