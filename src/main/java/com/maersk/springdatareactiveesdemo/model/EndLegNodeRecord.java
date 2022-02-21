package com.maersk.springdatareactiveesdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EndLegNodeRecord {

    private static final String FIELD_IS_PLACE_OF_DELIVERY = "isPlaceOfDelivery";
    private static final String FIELD_CURRENT_ETA_UTC = "currentEtaUTC";

    @Field(name = FIELD_IS_PLACE_OF_DELIVERY)
    private Boolean isPlaceOfDelivery;

    @Field(name = FIELD_CURRENT_ETA_UTC, type = FieldType.Date, format = DateFormat.date_time)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private ZonedDateTime currentEtaUTC;
}
