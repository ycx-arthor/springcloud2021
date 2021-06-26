package com.ycx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {
    private Integer id;
    private Integer productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
