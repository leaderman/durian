package com.miaoyurun.durian.aigc.deepseek.request;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = Function.FunctionSerializer.class)
public class Function {
    private String name;
    private String description;
    private List<Parameter> parameters;

    public Function(String name) {
        this.name = name;
    }

    public static class FunctionSerializer extends JsonSerializer<Function> {
        @Override
        public void serialize(Function value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();

            gen.writeStringField("name", value.getName());

            if (StringUtils.hasLength(value.getDescription())) {
                gen.writeStringField("description", value.getDescription());
            }

            if (!CollectionUtils.isEmpty(value.getParameters())) {
                gen.writeFieldName("parameters");

                gen.writeStartObject();

                gen.writeStringField("type", JsonType.OBJECT.getName());

                gen.writeFieldName("properties");

                gen.writeStartObject();

                for (Parameter parameter : value.getParameters()) {
                    gen.writeFieldName(parameter.getName());

                    gen.writeStartObject();

                    gen.writeStringField("type", parameter.getType().getName());

                    gen.writeStringField("description", parameter.getDescription());

                    gen.writeEndObject();
                }

                gen.writeEndObject();

                gen.writeFieldName("required");

                gen.writeStartArray();

                for (Parameter parameter : value.getParameters()) {
                    if (parameter.isRequired()) {
                        gen.writeString(parameter.getName());
                    }
                }

                gen.writeEndArray();

                gen.writeEndObject();
            }

            gen.writeEndObject();
        }
    }
}
