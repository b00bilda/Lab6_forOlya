package org.example.system;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class JsonDate implements JsonDeserializer<Date>, JsonSerializer<Date> {
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date deserialize(final JsonElement json, final Type typeOfT,
                                 final JsonDeserializationContext context) throws JsonParseException {
        try {
            return formatter.parse(json.getAsString());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public JsonElement serialize(final Date date, final Type typeOfSrc,
                                 final JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(date));
    }
}
