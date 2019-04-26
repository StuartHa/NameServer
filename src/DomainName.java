import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// An immutable domain name.
public class DomainName {
    // The sequence of labels that makes up the domain name. If you imagine the
    // domain name space as a tree each node has a label, then these labels are
    // the concatenation of all labels on path from node to the root of the
    // tree. The final value in this sequence will always be an empty string.
    private List<String> labels;

    private DomainName(List<String> labels) {
        this.labels = labels;
    }

    public static DomainName create(String dottedDomain) {
        // TODO: Enforce that zero-length label only exists at root.
        String[] labels = dottedDomain.split(".");
        return new DomainName(Arrays.asList(labels));
    }

    public boolean equals(Object other) {
        if (other instanceof DomainName) {
            DomainName otherDomainName = (DomainName) other;
            return labels.equals(otherDomainName.labels);
        }
        return false;
    }

    public int hashCode() {
        return labels.hashCode();
    }

    public boolean isEmpty() {
        return labels.isEmpty();
    }

    public DomainName remove() {
        if (isEmpty()) {
            return this;
        }
        List<String> newLabels = new ArrayList<>(labels);
        newLabels.remove(0);
        return new DomainName(newLabels);
    }
}