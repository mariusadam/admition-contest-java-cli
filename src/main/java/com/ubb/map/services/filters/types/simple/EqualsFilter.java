package com.ubb.map.services.filters.types.simple;

import com.j256.ormlite.stmt.Where;
import com.ubb.map.services.filters.types.ValueProvider;

import java.sql.SQLException;

/**
 * Created by marius on 16.12.2016.
 */
public class EqualsFilter extends SimpleFilter {
    public EqualsFilter(String propertyName, ValueProvider valueProvider) {
        super(propertyName, valueProvider, "Equals");
    }

    @Override
    public void apply(Where<?, ?> where) throws SQLException {
        if (valueProvider.provideValue() != null) {
            where.eq(getPropertyName(), valueProvider.provideValue());
        }
    }
}
