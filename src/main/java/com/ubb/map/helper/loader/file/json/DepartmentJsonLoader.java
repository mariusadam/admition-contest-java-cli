package com.ubb.map.helper.loader.file.json;

import com.ubb.map.domain.Department;
import org.json.JSONObject;
import com.ubb.map.validator.ValidatorInterface;

/**
 * @author Marius Adam
 */
public class DepartmentJsonLoader extends JsonLoader<Department> {
    public DepartmentJsonLoader(ValidatorInterface<Department> validator) {
        super(validator);
    }

    @Override
    protected Department createFromJSONObject(JSONObject jsonObject) {
        return new Department(
                jsonObject.getInt("id"),
                jsonObject.getString("name"),
                jsonObject.getInt("numberOfSeats")
        );
    }
}