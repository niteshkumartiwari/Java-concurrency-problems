package kachra;

import java.util.HashSet;
import java.util.Set;

public class PnpLiteListingInfo {
    private Set<ValueTag> valueTag;

    public PnpLiteListingInfo(){
        valueTag= new HashSet<>() {{
            add(new ValueTag());
            add(new ValueTag());
            add(new ValueTag());
        }};
    }

    public Set<ValueTag> getValueTag() {
        return valueTag;
    }
}
