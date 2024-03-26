package com.itheima.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        Integer id,
        @NotEmpty //添加了一个非空验证
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive //添加了一个正数（>0）验证
        Integer miles,
        Location location) {
    public Run {
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("CompletedOn must be after StartedOn");
        }
    }
}
