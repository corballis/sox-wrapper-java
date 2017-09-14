package ie.corballis.sox;

public class SoxFactory {

    private final String soxPath;

    public SoxFactory(String soxPath) {
        this.soxPath = soxPath;
    }
    public Sox getInstance() {
        return new Sox(soxPath);
    }

}
