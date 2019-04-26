import java.util.Map;

// Immutable.
public class Zone {
    private Map<DomainName, ResourceRecordStore> records;
    DomainName rootDomain;
}
