package com.itheima.run;

import javax.xml.stream.Location;
import java.time.LocalDateTime;
import java.util.Objects;

public class RunFirst {
    private Integer id;
    private String title;
    private LocalDateTime startedOn;
    private LocalDateTime completedOn;
    private Integer miles;
    private Location location;

    public RunFirst(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles, Location location) {
        this.id = id;
        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.miles = miles;
        this.location = location;
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("CompletedOn must be after StartedOn");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RunFirst run)) return false;
        return Objects.equals(getId(), run.getId()) && Objects.equals(getTitle(), run.getTitle()) && Objects.equals(getStartedOn(), run.getStartedOn()) && Objects.equals(getCompletedOn(), run.getCompletedOn()) && Objects.equals(getMiles(), run.getMiles()) && Objects.equals(getLocation(), run.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getStartedOn(), getCompletedOn(), getMiles(), getLocation());
    }

    @Override
    public String toString() {
        return "Run{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startedOn=" + startedOn +
                ", completedOn=" + completedOn +
                ", miles=" + miles +
                ", location=" + location +
                '}';
    }
}
