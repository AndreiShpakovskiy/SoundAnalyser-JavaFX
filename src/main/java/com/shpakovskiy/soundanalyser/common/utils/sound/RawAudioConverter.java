package com.shpakovskiy.soundanalyser.common.utils.sound;

import java.util.Arrays;

public class RawAudioConverter {

    //TODO: Add JavaDoc
    public static double[] retrieveSoundValues(byte[] rawAudioData, int sampleSizeBytes) {
        double[] audioData = new double[rawAudioData.length / sampleSizeBytes];

        for (int i = 0; i < rawAudioData.length / sampleSizeBytes; i++) {
            int singleValue = 0;

            for (int byteShift = sampleSizeBytes - 1; byteShift >= 0; byteShift--) {
                singleValue = singleValue | rawAudioData[i * sampleSizeBytes + byteShift];

                if (byteShift > 0) {
                    singleValue = singleValue << Byte.SIZE;
                }
            }

            audioData[i] = singleValue;
        }

        return normalize(audioData, Byte.MAX_VALUE);
    }

    public static double[] normalize(double[] rawValues, long adjustTo) {
        double maxValue = Arrays.stream(rawValues).max().orElse(0);

        for (int i = 0; i < rawValues.length; i++) {
            rawValues[i] = rawValues[i] / maxValue * adjustTo;
        }

        return rawValues;
    }
}