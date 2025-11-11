package com.acme.center.platform.learning.domain.model.aggregates;

import com.acme.center.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;
import com.acme.center.platform.learning.domain.model.valueobjects.ProfileId;
import com.acme.center.platform.learning.domain.model.valueobjects.StudentPerformanceMetricSet;
import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

/**
 * Student aggregate root.
 * <p>
 * This class represents a student in the learning platform, associated with a profile,
 * and tracking performance metrics.
 * </p>
 */
@Entity
public class Student extends AuditableAbstractAggregateRoot<Student> {

    @Getter
    @Embedded
    @Column(name = "acme_student_id")
    private AcmeStudentRecordId acmeStudentRecordId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private StudentPerformanceMetricSet performanceMetricSet;

    /**
     * Default constructor for JPA.
     * Initializes the student with a new ACME student record ID and performance metric set.
     */
    public Student() {
        super();
        this.acmeStudentRecordId = new AcmeStudentRecordId();
        this.performanceMetricSet = new StudentPerformanceMetricSet();
    }

    /**
     * Constructor with profile ID.
     * @param profileId the profile ID as a Long
     */
    public Student(Long profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    /**
     * Constructor with profile id
     * @param profileId the profile id
     *                  @see ProfileId
     */
    public Student(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    /**
     * Updates the performance metrics when a tutorial is completed.
     * Increments the total completed tutorials count.
     */
    public void updateMetricsOnTutorialCompleted() {
        this.performanceMetricSet = this.performanceMetricSet.incrementCompletedTutorials();
    }

    /**
     * Updates the performance metrics when a course is completed.
     * Increments the total completed courses count.
     */
    public void updateMetricsOnCourseCompleted() {
        this.performanceMetricSet = this.performanceMetricSet.incrementCompletedCourses();
    }

    /**
     * Gets the student record ID.
     * @return the student record ID as a string
     */
    public String getStudentRecordId() {
        return this.acmeStudentRecordId.studentRecordId();
    }

    /**
     * Gets the profile ID.
     * @return the profile ID as a Long
     */
    public Long getProfileId() {
        return this.profileId.profileId();
    }

    /**
     * Gets the total number of completed courses.
     * @return the total completed courses
     */
    public int getTotalCompletedCourses() {
        return this.performanceMetricSet.totalCompletedCourses();
    }

    /**
     * Gets the total number of completed tutorials.
     * @return the total completed tutorials
     */
    public int getTotalCompletedTutorials() {
        return this.performanceMetricSet.totalCompletedTutorials();
    }
}
