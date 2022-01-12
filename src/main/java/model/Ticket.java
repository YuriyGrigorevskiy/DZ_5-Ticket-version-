package model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Объект тикета (POJO) */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {

        private int id;
        private String title;
        private String submitter_email;
        private int status;
        private boolean on_hold;
        private String description;
        private String resolution;
        private int priority;
        private Date last_escalation;
        private int queue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public boolean isOn_hold() {
        return on_hold;
    }

    public void setOn_hold(boolean on_hold) {
        this.on_hold = on_hold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getLast_escalation() {
        return last_escalation;
    }

    public void setLast_escalation(Date last_escalation) {
        this.last_escalation = last_escalation;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                status == ticket.status &&
                on_hold == ticket.on_hold &&
                priority == ticket.priority &&
                queue == ticket.queue &&
                Objects.equals(title, ticket.title) &&
                Objects.equals(submitter_email, ticket.submitter_email) &&
                Objects.equals(description, ticket.description) &&
                Objects.equals(resolution, ticket.resolution) &&
                Objects.equals(last_escalation, ticket.last_escalation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, submitter_email, status, on_hold, description, resolution, priority, last_escalation, queue);
    }
}
