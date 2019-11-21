package com.minds.lms.springboot2jpacrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "course_model")

public class Course {
	
	    
	    
	    /*public Course(String organizations, String code, String name, long tuition, String description, String duration,
				String targetedLearners, String deliveryMethod, boolean approvalRequired,
				String courseCompletionCertificate, String language, String notes, String courseDisplayDate,
				String enrollmentOpenDate, String enrollmentCloseDate, String courseHideDate,
				String certificationCalculationDate, long daysStdToCompl, long daysBeforeStdToCompl, long expireDays,
				long remindStudent, String enrollmentRestriction, String accumulateCredit, String credit,
				String instructionalLanguages, String version, String allowUseOfInterestLists) {
			super();
			Organizations = organizations;
			Code = code;
			Name = name;
			Tuition = tuition;
			Description = description;
			Duration = duration;
			TargetedLearners = targetedLearners;
			DeliveryMethod = deliveryMethod;
			ApprovalRequired = approvalRequired;
			courseCompletionCertificate = courseCompletionCertificate;
			Language = language;
			Notes = notes;
			CourseDisplayDate = courseDisplayDate;
			EnrollmentOpenDate = enrollmentOpenDate;
			EnrollmentCloseDate = enrollmentCloseDate;
			CourseHideDate = courseHideDate;
			CertificationCalculationDate = certificationCalculationDate;
			DaysStdToCompl = daysStdToCompl;
			DaysBeforeStdToCompl = daysBeforeStdToCompl;
			ExpireDays = expireDays;
			RemindStudent = remindStudent;
			EnrollmentRestriction = enrollmentRestriction;
			AccumulateCredit = accumulateCredit;
			Credit = credit;
			InstructionalLanguages = instructionalLanguages;
			Version = version;
			AllowUseOfInterestLists = allowUseOfInterestLists;
		}*/
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
		private long   id;
		private String Organizations;
	    private String Code;
		private String Name;
		private long   Tuition;
	    private String Description;
	    private String Duration;
		private String TargetedLearners;
		private String DeliveryMethod;
		private boolean ApprovalRequired;
		private boolean courseCompletionCertificate;
		private String Language;
		private String Notes;
		private String CourseDisplayDate;
		private String EnrollmentOpenDate;
		private String EnrollmentCloseDate ;
		private String CourseHideDate;
		private String CertificationCalculationDate;
		private long   DaysStdToCompl;
		private long   DaysBeforeStdToCompl;
		private long   ExpireDays;
		private long   RemindStudent;
		private String EnrollmentRestriction;
		private String AccumulateCredit;
		private String Credit;
		private String InstructionalLanguages;
		private String Version;
		private String AllowUseOfInterestLists;
		private boolean canRelaunch;
		private String contentType;
		private String resourceContent;
		private boolean selfCertifiedCompletion;
		 
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getOrganizations() {
			return Organizations;
		}
		public void setOrganizations(String organizations) {
			Organizations = organizations;
		}
		public String getCode() {
			return Code;
		}
		public void setCode(String code) {
			Code = code;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public long getTuition() {
			return Tuition;
		}
		public void setTuition(long tuition) {
			Tuition = tuition;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getDuration() {
			return Duration;
		}
		public void setDuration(String duration) {
			Duration = duration;
		}
		public String getTargetedLearners() {
			return TargetedLearners;
		}
		public void setTargetedLearners(String targetedLearners) {
			TargetedLearners = targetedLearners;
		}
		public String getDeliveryMethod() {
			return DeliveryMethod;
		}
		public void setDeliveryMethod(String deliveryMethod) {
			DeliveryMethod = deliveryMethod;
		}
		public boolean getApprovalRequired() {
			return ApprovalRequired;
		}
		public void setApprovalRequired1(boolean approvalRequired) {
			ApprovalRequired = approvalRequired;
		}
		
		public String getLanguage() {
			return Language;
		}
		public void setLanguage(String language) {
			Language = language;
		}
		public String getNotes() {
			return Notes;
		}
		public void setNotes(String notes) {
			Notes = notes;
		}
		public String getCourseDisplayDate() {
			return CourseDisplayDate;
		}
		public void setCourseDisplayDate(String courseDisplayDate) {
			CourseDisplayDate = courseDisplayDate;
		}
		public String getEnrollmentOpenDate() {
			return EnrollmentOpenDate;
		}
		public void setEnrollmentOpenDate(String enrollmentOpenDate) {
			EnrollmentOpenDate = enrollmentOpenDate;
		}
		public String getEnrollmentCloseDate() {
			return EnrollmentCloseDate;
		}
		public void setEnrollmentCloseDate(String enrollmentCloseDate) {
			EnrollmentCloseDate = enrollmentCloseDate;
		}
		public String getCourseHideDate() {
			return CourseHideDate;
		}
		public void setCourseHideDate(String courseHideDate) {
			CourseHideDate = courseHideDate;
		}
		public String getCertificationCalculationDate() {
			return CertificationCalculationDate;
		}
		public void setCertificationCalculationDate(String certificationCalculationDate) {
			CertificationCalculationDate = certificationCalculationDate;
		}
		public long getDaysStdToCompl() {
			return DaysStdToCompl;
		}
		public void setDaysStdToCompl(long daysStdToCompl) {
			DaysStdToCompl = daysStdToCompl;
		}
		public long getDaysBeforeStdToCompl() {
			return DaysBeforeStdToCompl;
		}
		public void setDaysBeforeStdToCompl(long daysBeforeStdToCompl) {
			DaysBeforeStdToCompl = daysBeforeStdToCompl;
		}
		public long getExpireDays() {
			return ExpireDays;
		}
		public void setExpireDays(long expireDays) {
			ExpireDays = expireDays;
		}
		public long getRemindStudent() {
			return RemindStudent;
		}
		public void setRemindStudent(long remindStudent) {
			RemindStudent = remindStudent;
		}
		public String getEnrollmentRestriction() {
			return EnrollmentRestriction;
		}
		public void setEnrollmentRestriction(String enrollmentRestriction) {
			EnrollmentRestriction = enrollmentRestriction;
		}
		public String getAccumulateCredit() {
			return AccumulateCredit;
		}
		public void setAccumulateCredit(String accumulateCredit) {
			AccumulateCredit = accumulateCredit;
		}
		public String getCredit() {
			return Credit;
		}
		public void setCredit(String credit) {
			Credit = credit;
		}
		public String getInstructionalLanguages() {
			return InstructionalLanguages;
		}
		public void setInstructionalLanguages(String instructionalLanguages) {
			InstructionalLanguages = instructionalLanguages;
		}
		public String getVersion() {
			return Version;
		}
		public void setVersion(String version) {
			Version = version;
		}
		public String getAllowUseOfInterestLists() {
			return AllowUseOfInterestLists;
		}
		public void setAllowUseOfInterestLists(String allowUseOfInterestLists) {
			AllowUseOfInterestLists = allowUseOfInterestLists;
		}
		
		public boolean isCanRelaunch() {
			return canRelaunch;
		}
		public void setCanRelaunch(boolean canRelaunch) {
			this.canRelaunch = canRelaunch;
		}
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		public String getResourceContent() {
			return resourceContent;
		}
		public void setResourceContent(String resourceContent) {
			this.resourceContent = resourceContent;
		}
		public boolean getSelfCertifiedCompletion() {
			return selfCertifiedCompletion;
		}
		public void setSelfCertifiedCompletion(boolean selfCertifiedCompletion) {
			this.selfCertifiedCompletion = selfCertifiedCompletion;
		}
		public void setApprovalRequired(boolean approvalRequired) {
			ApprovalRequired = approvalRequired;
		}
		public boolean isCourseCompletionCertificate() {
			return courseCompletionCertificate;
		}
		public void setCourseCompletionCertificate(boolean courseCompletionCertificate) {
			this.courseCompletionCertificate = courseCompletionCertificate;
		}
		
		
		
	    
		
		
}
