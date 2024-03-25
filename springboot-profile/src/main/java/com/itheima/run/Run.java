package com.itheima.run;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotEmpty;
public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location) {
//    public Run {
//        if (startedOn.isAfter(completedOn)) {
//            throw new IllegalArgumentException("CompletedOn must be after StartedOn");
//        }
//    }
}
