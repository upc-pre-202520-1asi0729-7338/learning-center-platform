package com.acme.center.platform.learning.domain.model.aggregates;

import com.acme.center.platform.learning.domain.model.events.TutorialCompletedEvent;
import com.acme.center.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;
import com.acme.center.platform.learning.domain.model.valueobjects.EnrollmentStatus;
import com.acme.center.platform.learning.domain.model.valueobjects.ProgressRecord;
import com.acme.center.platform.learning.domain.model.valueobjects.TutorialId;
import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

/**
 * Enrollment aggregate root.
 * <p>
 * This class represents an enrollment of a student in a course, tracking progress and status.
 * </p>
 */
@Entity
public class Enrollment extends AuditableAbstractAggregateRoot<Enrollment> {
    @Getter
    @Embedded
    private AcmeStudentRecordId acmeStudentRecordId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Embedded
    private ProgressRecord progressRecord;

    private EnrollmentStatus status;

    /**
     * Default constructor for JPA.
     */
    public Enrollment() {
        super();
    }

    /**
     * Constructor with student record ID and course.
     * Initializes the enrollment with REQUESTED status and a new progress record.
     * @param acmeStudentRecordId the ACME student record ID
     * @param course the course to enroll in
     */
    public Enrollment(AcmeStudentRecordId acmeStudentRecordId, Course course) {
        this();
        this.acmeStudentRecordId = acmeStudentRecordId;
        this.course = course;
        this.status = EnrollmentStatus.REQUESTED;
        this.progressRecord = new ProgressRecord();
    }

    /**
     * Confirms the enrollment.
     * Sets the status to CONFIRMED and initializes the progress record.
     */
    public void confirm() {
        this.status = EnrollmentStatus.CONFIRMED;
        this.progressRecord.initializeProgressRecord(this, course.getLearningPath());
        // this.registerEvent(new EnrollmentConfirmedEvent(this));
    }

    /**
     * Rejects the enrollment.
     * Sets the status to REJECTED.
     */
    public void reject() {
        this.status = EnrollmentStatus.REJECTED;
        // this.registerEvent(new EnrollmentRejectedEvent(this));
    }

    /**
     * Cancels the enrollment.
     * Sets the status to CANCELLED.
     */
    public void cancel() {
        this.status = EnrollmentStatus.CANCELLED;
        // this.registerEvent(new EnrollmentCancelledEvent(this));
    }

    /**
     * Checks if the enrollment is confirmed.
     * @return true if the status is CONFIRMED, false otherwise
     */
    public boolean isConfirmed() {
        return this.status == EnrollmentStatus.CONFIRMED;
    }

    /**
     * Checks if the enrollment is rejected.
     * @return true if the status is REJECTED, false otherwise
     */
    public boolean isRejected() {
        return this.status == EnrollmentStatus.REJECTED;
    }

    /**
     * Checks if the enrollment is cancelled.
     * @return true if the status is CANCELLED, false otherwise
     */
    public boolean isCancelled() {
        return this.status == EnrollmentStatus.CANCELLED;
    }

    /**
     * Gets the status of the enrollment as a lowercase string.
     * @return the status in lowercase
     */
    public String getStatus() {
        return this.status.name().toLowerCase();
    }

    /**
     * Calculates the number of days elapsed since the enrollment.
     * @return the number of days elapsed
     */
    public long calculateDaysElapsed() {
        return progressRecord.calculateDaysElapsedForEnrollment(this);
    }

    /**
     * Marks a tutorial as completed and registers a tutorial completed event.
     * @param tutorialId the ID of the tutorial to complete
     */
    public void completeTutorial(TutorialId tutorialId) {
        this.progressRecord.completeTutorial(tutorialId, course.getLearningPath());
        // Publish a Tutorial Completed Event
        this.registerEvent(new TutorialCompletedEvent(this, this.getId(), tutorialId));
    }


}
