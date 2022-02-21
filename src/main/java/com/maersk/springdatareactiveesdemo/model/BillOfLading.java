package com.maersk.springdatareactiveesdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "bills-of-lading-write-demo")
public class BillOfLading {

    @Id
    private String billOfLadingId;

    @Field(name = "brandCode")
    private String brandCode;

    @Field(name = "bookedByReference")
    private Set<String> bookedByReference;

    @Field(name = "shipmentStatus")
    private String shipmentStatus;

    @Field(name = "transportPlan", type = FieldType.Nested)
    private List<LegRecord> transportPlan;

}
