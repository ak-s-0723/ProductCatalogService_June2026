package org.example.productcatalogservice_june2026.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_ta")
@DiscriminatorValue(value = "TATATATATATATATATATATATATATATATATATATATATATATATATA")
public class Ta extends User {
    private Integer hours;
}
