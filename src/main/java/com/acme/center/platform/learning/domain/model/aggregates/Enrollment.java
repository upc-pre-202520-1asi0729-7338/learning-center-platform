package com.acme.center.platform.learning.domain.model.aggregates;

import com.acme.center.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;
import com.acme.center.platform.learning.domain.model.valueobjects.EnrollmentStatus;
import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
public class Enrollment extends AuditableAbstractAggregateRoot<Enrollment> {
    @Getter
    @Embedded
    private AcmeStudentRecordId acmeStudentRecordId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private EnrollmentStatus status;

    public Enrollment() {
        super();
    }

    public Enrollment(AcmeStudentRecordId acmeStudentRecordId, Course course) {
        this();
        this.acmeStudentRecordId = acmeStudentRecordId;
        this.course = course;
        this.status = EnrollmentStatus.REQUESTED;
    }

    public void confirm() {
        this.status = EnrollmentStatus.CONFIRMED;
    }

    public void reject() {
        this.status = EnrollmentStatus.REJECTED;
    }

    public void cancel() {
        this.status = EnrollmentStatus.CANCELLED;
    }

    public boolean isConfirmed() {
        return this.status == EnrollmentStatus.CONFIRMED;
    }

    public boolean isRejected() {
        return this.status == EnrollmentStatus.REJECTED;
    }

    public boolean isCancelled() {
        return this.status == EnrollmentStatus.CANCELLED;
    }



}
