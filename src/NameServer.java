import java.net.Inet4Address;
import java.util.*;

public class NameServer {
    private List<Zone> zones;
    private Map<DomainName, Zone> domainNameZoneMap;

    public NameServer(List<Zone> zones) {
        this.zones = zones;
        domainNameZoneMap = new HashMap<>();
        for (Zone zone : zones) {
            domainNameZoneMap.put(zone.rootDomain, zone);
        }
    }

    public List<ResourceRecord> query(DomainName domain, int type) {
        // 1. Find nearest Zone ancestor of domain. If found, go to 2. If none
        //   found, then nothing found.
        Zone zone = findNearestZone(domain);
        if (zone == null) {
            return new ArrayList<>();
        }
        // 2. If Zone contains resources of desired type, then return those
        //   resource records.

    }

    private Zone findNearestZone(DomainName domain) {
        while (!domain.isEmpty()) {
            if (domainNameZoneMap.containsKey(domain)) {
                return domainNameZoneMap.get(domain);
            }
            domain = domain.remove();
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
