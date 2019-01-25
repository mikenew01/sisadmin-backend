package io.mk.sisadmin.model.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BaseGenericObjectMapper<T> {
    @IterableMapping(
            qualifiedByName = {"toMap"}
    )
    List<T> toList(List<Object> value);

    @Named("toMap")
    T toMap(Object value);

    default String toString(Object valor, int pos) {
        return this.toObject(valor, pos).toString();
    }

    default Long toLong(Object valor, int pos) {
        return ((BigDecimal) this.toObject(valor, pos)).longValue();
    }

    default Integer toInteger(Object valor, int pos) {
        return ((BigDecimal) this.toObject(valor, pos)).intValue();
    }

    default BigDecimal toBigDecimal(Object valor, int pos) {
        return (BigDecimal) this.toObject(valor, pos);
    }

    default LocalDate toLocalDate(Object valor, int pos) {
        return (LocalDate) this.toObject(valor, pos);
    }

    default LocalDateTime toLocalDateTime(Object valor, int pos) {
        return (LocalDateTime) this.toObject(valor, pos);
    }

    default Object toObject(Object valor, int pos) {
        return ((Object[]) ((Object[]) valor))[pos];
    }
}
