package design.zykus.zykus.clothing.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ProductSize {
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE
}
