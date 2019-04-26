import java.net.Inet4Address;

class IPv4ResourceRecord extends ResourceRecord {
    private Inet4Address ip;

    public IPv4ResourceRecord(int classValue, int type, int ttl, Inet4Address ip) {
        super(classValue, type, ttl);
        this.ip = ip;
    }
}