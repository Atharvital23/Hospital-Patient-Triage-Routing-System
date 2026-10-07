package com.kiranacademy.hospital.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.kiranacademy.hospital.enums.AdmissionType;
import com.kiranacademy.hospital.enums.ConditionStatus;
import com.kiranacademy.hospital.enums.Gender;
import com.kiranacademy.hospital.enums.TransferStatus;

public class Patient {
	private int patient_id;
	private String patient_name;
	private int age;
	private Gender gender;
	private String disease;
	private AdmissionType admissionType;
	private ConditionStatus conditionStatus;
	private int triage_score;
	private String doctor_name;
	private LocalDate admission_date;
	private String mobile;
	private TransferStatus transferStatus;
	private LocalDateTime processed_at;
	private LocalDateTime created_at;

	public Patient() {
	}

	public Patient(int patient_id, String patient_name, int age, Gender gender, String disease,
			AdmissionType admissionType, ConditionStatus conditionStatus, int triage_score, String doctor_name,
			LocalDate admission_date, String mobile, TransferStatus transferStatus, LocalDateTime processed_at,
			LocalDateTime created_at) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.age = age;
		this.gender = gender;
		this.disease = disease;
		this.admissionType = admissionType;
		this.conditionStatus = conditionStatus;
		this.triage_score = triage_score;
		this.doctor_name = doctor_name;
		this.admission_date = admission_date;
		this.mobile = mobile;
		this.transferStatus = transferStatus;
		this.processed_at = processed_at;
		this.created_at = created_at;
	}

	public Patient(String patient_name, int age, Gender gender, String disease, AdmissionType admissionType,
			ConditionStatus conditionStatus, int triage_score, String doctor_name, LocalDate admission_date,
			String mobile, TransferStatus transferStatus, LocalDateTime processed_at, LocalDateTime created_at) {
		super();
		this.patient_name = patient_name;
		this.age = age;
		this.gender = gender;
		this.disease = disease;
		this.admissionType = admissionType;
		this.conditionStatus = conditionStatus;
		this.triage_score = triage_score;
		this.doctor_name = doctor_name;
		this.admission_date = admission_date;
		this.mobile = mobile;
		this.transferStatus = transferStatus;
		this.processed_at = processed_at;
		this.created_at = created_at;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public AdmissionType getAdmissionType() {
		return admissionType;
	}

	public void setAdmissionType(AdmissionType admissionType) {
		this.admissionType = admissionType;
	}

	public ConditionStatus getConditionStatus() {
		return conditionStatus;
	}

	public void setConditionStatus(ConditionStatus conditionStatus) {
		this.conditionStatus = conditionStatus;
	}

	public int getTriage_score() {
		return triage_score;
	}

	public void setTriage_score(int triage_score) {
		this.triage_score = triage_score;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public LocalDate getAdmission_date() {
		return admission_date;
	}

	public void setAdmission_date(LocalDate admission_date) {
		this.admission_date = admission_date;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public TransferStatus getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(TransferStatus transferStatus) {
		this.transferStatus = transferStatus;
	}

	public LocalDateTime getProcessed_at() {
		return processed_at;
	}

	public void setProcessed_at(LocalDateTime processed_at) {
		this.processed_at = processed_at;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

}
