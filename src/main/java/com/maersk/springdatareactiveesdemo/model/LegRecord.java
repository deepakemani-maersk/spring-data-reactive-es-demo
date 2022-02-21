package com.maersk.springdatareactiveesdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LegRecord {

   private static final String FIELD_END = "end";

    @Field(name = FIELD_END)
    private EndLegNodeRecord end;

}
