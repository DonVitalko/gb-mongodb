package ru.gb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Product {
    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
    private BigDecimal cost;
    private LocalDate manufactureDate;
    private Manufacturer manufacturer;
    private Set<Category> categories;
    private Status status;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", manufactureDate=" + manufactureDate +
                ", manufacturer=" + manufacturer +
                ", categories=" + categories +
                ", status=" + status +
                '}';
    }
}