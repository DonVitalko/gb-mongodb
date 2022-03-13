package ru.gb.model;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Cart {
    @Id
    private String id;
    private Set<Product> products;
}