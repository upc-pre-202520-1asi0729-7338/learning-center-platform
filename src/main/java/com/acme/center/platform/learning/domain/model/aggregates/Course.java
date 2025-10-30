package com.acme.center.platform.learning.domain.model.aggregates;

import com.acme.center.platform.learning.domain.model.commands.CreateCourseCommand;
import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
public class Course extends AuditableAbstractAggregateRoot<Course> {
    private String title;
    private String description;

    public Course() {
        super();
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
    }

    public Course updateInformation(String title, String description) {
        this.title = title;
        this.description = description;
        return this;
    }

    public Course(CreateCourseCommand command) {
        this();
        this.title = command.title();
        this.description = command.description();
    }

}
