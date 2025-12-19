package com.workintech.zoo.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Kangaroo {
    private Integer id;
    private String name;
    private Double height;
    private Double weight;
    private String gender;
    private boolean isAggressive;

    public boolean getIsAggressive() {
        return isAggressive;
    }

    public void setIsAggressive(boolean bool) {
        this.isAggressive = bool;
    }
}
