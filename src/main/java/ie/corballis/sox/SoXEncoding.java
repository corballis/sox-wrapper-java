package ie.corballis.sox;

public enum SoXEncoding {
    SIGNED_INTEGER {
        @Override
        public String toString() {
            return "signed-integer";
        }
    },
    UNSIGNED_INTEGER {

        @Override
        public String toString() {
            return "unsigned-integer";
        }
    },


    FLOATING_POINT {
        @Override
        public String toString() {
            return "floating-point";
        }
    },
    MU_LAW {
        @Override
        public String toString() {
            return "mu-law";
        }
    },
    A_LAW {
        @Override
        public String toString() {
            return "a-law";
        }
    },
    IMA_ADPCM {
        @Override
        public String toString() {
            return "ima-adpcm";
        }
    },
    MS_ADPCM {
        @Override
        public String toString() {
            return "ms-adpcm";
        }
    },
    GSM_FULL_RATE {
        @Override
        public String toString() {
            return "gsm-full-rate";
        }
    }
}
