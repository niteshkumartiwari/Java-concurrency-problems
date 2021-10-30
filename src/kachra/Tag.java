package kachra;

import java.util.Optional;

public class Tag {
    private String tagName;
    private Long value;

    public Tag(String tagName, Long value) {
        this.tagName = tagName;
        this.value = value;
    }

    public String getTagName() {
        return tagName;
    }

    public Optional<Long> getValue() {
        return Optional.ofNullable(value);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagName='" + tagName + '\'' +
                ", value=" + value +
                '}';
    }
}
