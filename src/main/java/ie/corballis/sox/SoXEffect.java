package ie.corballis.sox;

public enum SoXEffect {
    ALLPASS {
        @Override
        public String toString() {
            return "allpass";
        }
    },
    BAND {
        @Override
        public String toString() {
            return "band";
        }
    },
    BANDPASS {
        @Override
        public String toString() {
            return "bandpass";
        }
    },
    BANDREJECT {
        @Override
        public String toString() {
            return "bandreject";
        }
    },
    BASS {
        @Override
        public String toString() {
            return "bass";
        }
    },
    BEND {
        @Override
        public String toString() {
            return "bend";
        }
    },
    BIQUAD {
        @Override
        public String toString() {
            return "biquad";
        }
    },
    CHORUS {
        @Override
        public String toString() {
            return "chorus";
        }
    },
    CHANNELS {
        @Override
        public String toString() {
            return "channels";
        }
    },
    COMPAND {
        @Override
        public String toString() {
            return "compand";
        }
    },
    CONTRAST {
        @Override
        public String toString() {
            return "contrast";
        }
    },
    DCSHIFT {
        @Override
        public String toString() {
            return "dcshift";
        }
    },
    DEEMPH {
        @Override
        public String toString() {
            return "deemph";
        }
    },
    DELAY {
        @Override
        public String toString() {
            return "delay";
        }
    },
    DITHER {
        @Override
        public String toString() {
            return "dither";
        }
    },
    DIVIDE_PLUS {
        @Override
        public String toString() {
            return "divide+";
        }
    },
    DOWNSAMPLE {
        @Override
        public String toString() {
            return "downsample";
        }
    },
    EARWAX {
        @Override
        public String toString() {
            return "earwax";
        }
    },
    ECHO {
        @Override
        public String toString() {
            return "echo";
        }
    },
    ECHOS {
        @Override
        public String toString() {
            return "echos";
        }
    },
    EQUALIZER {
        @Override
        public String toString() {
            return "equalizer";
        }
    },
    FADE {
        @Override
        public String toString() {
            return "fade";
        }
    },
    FIR {
        @Override
        public String toString() {
            return "fir";
        }
    },
    FIRFIT_PLUS {
        @Override
        public String toString() {
            return "firfit+";
        }
    },
    FLANGER {
        @Override
        public String toString() {
            return "flanger";
        }
    },
    GAIN {
        @Override
        public String toString() {
            return "gain";
        }
    },
    HIGHPASS {
        @Override
        public String toString() {
            return "highpass";
        }
    },
    HILBERT {
        @Override
        public String toString() {
            return "hilbert";
        }
    },
    INPUT_HASH {
        @Override
        public String toString() {
            return "input#";
        }
    },
    LOUDNESS {
        @Override
        public String toString() {
            return "loudness";
        }
    },
    LOWPASS {
        @Override
        public String toString() {
            return "lowpass";
        }
    },
    MCOMPAND {
        @Override
        public String toString() {
            return "mcompand";
        }
    },
    NOISEPROF {
        @Override
        public String toString() {
            return "noiseprof";
        }
    },
    NOISERED {
        @Override
        public String toString() {
            return "noisered";
        }
    },
    NORM {
        @Override
        public String toString() {
            return "norm";
        }
    },
    OOPS {
        @Override
        public String toString() {
            return "oops";
        }
    },
    OUTPUT_HASH {
        @Override
        public String toString() {
            return "output#";
        }
    },
    OVERDRIVE {
        @Override
        public String toString() {
            return "overdrive";
        }
    },
    PAD {
        @Override
        public String toString() {
            return "pad";
        }
    },
    PHASER {
        @Override
        public String toString() {
            return "phaser";
        }
    },
    PITCH {
        @Override
        public String toString() {
            return "pitch";
        }
    },
    RATE {
        @Override
        public String toString() {
            return "rate";
        }
    },
    REMIX {
        @Override
        public String toString() {
            return "remix";
        }
    },
    REPEAT {
        @Override
        public String toString() {
            return "repeat";
        }
    },
    REVERB {
        @Override
        public String toString() {
            return "reverb";
        }
    },
    REVERSE {
        @Override
        public String toString() {
            return "reverse";
        }
    },
    RIAA {
        @Override
        public String toString() {
            return "riaa";
        }
    },
    SILENCE {
        @Override
        public String toString() {
            return "silence";
        }
    },
    SINC {
        @Override
        public String toString() {
            return "sinc";
        }
    },
    SPECTROGRAM {
        @Override
        public String toString() {
            return "spectrogram";
        }
    },
    SPEED {
        @Override
        public String toString() {
            return "speed";
        }
    },
    SPLICE {
        @Override
        public String toString() {
            return "splice";
        }
    },
    STAT {
        @Override
        public String toString() {
            return "stat";
        }
    },
    STATS {
        @Override
        public String toString() {
            return "stats";
        }
    },
    STRETCH {
        @Override
        public String toString() {
            return "stretch";
        }
    },
    SWAP {
        @Override
        public String toString() {
            return "swap";
        }
    },
    SYNTH {
        @Override
        public String toString() {
            return "synth";
        }
    },
    TEMPO {
        @Override
        public String toString() {
            return "tempo";
        }
    },
    TREBLE {
        @Override
        public String toString() {
            return "treble";
        }
    },
    TREMOLO {
        @Override
        public String toString() {
            return "tremolo";
        }
    },
    TRIM {
        @Override
        public String toString() {
            return "trim";
        }
    },
    UPSAMPLE {
        @Override
        public String toString() {
            return "upsample";
        }
    },
    VAD {
        @Override
        public String toString() {
            return "vad";
        }
    },
    VOL {
        @Override
        public String toString() {
            return "vol";
        }
    }

}
