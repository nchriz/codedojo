package com.codedojo.three.three.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "range", schema = "codedojo")
@Data
public class RangeEntity {

    @Id
    private Long low;
    private Long high;

}
