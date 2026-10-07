package com.kiranacademy.hospital.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.kiranacademy.hospital.entity.Patient;
import com.kiranacademy.hospital.enums.AdmissionType;
import com.kiranacademy.hospital.enums.ConditionStatus;

public class PatientValidator {
	public static List<String> validatePatient(Patient patient) {
		List<String> error = new ArrayList<String>();

		if (patient == null) {
			error.add("Object is NULL");
			return error;
		}

		if (patient.getPatient_name() == null || patient.getPatient_name().isBlank()
				|| patient.getPatient_name().trim().length() < 3) {
			error.add("patient_name must not be null, blank or shorter than 3 characters");
		}

		if (patient.getAge() < 0 || patient.getAge() > 120) {
			error.add("age must be between 0 and 120");
		}

		if (patient.getGender() == null) {
			error.add(" gender must be Male, Female or Other");
		}

		if (patient.getDisease() == null || patient.getDisease().trim().isEmpty()) {
			error.add("disease must not be blank");
		}

		if (patient.getAdmissionType() == null) {
			error.add("admission_type must be Emergency or Regular");
		}

		if (patient.getConditionStatus() == null) {
			error.add("condition_status must be Critical, Moderate or Stable");
		}

		if (patient.getTriage_score() < 1 || patient.getTriage_score() > 10) {
			error.add("triage_score must be between 1 and 10");
		}

		if (patient.getDoctor_name() == null || patient.getDoctor_name().trim().isEmpty()) {
			error.add("doctor_name must not be blank");
		}

		if (patient.getAdmission_date() == null || patient.getAdmission_date().isAfter(LocalDate.now())) {
			error.add("admission_date must not be a future date");
		}

		if (patient.getMobile() == null || patient.getMobile().trim().length() != 10) {
			error.add("mobile must contain exactly 10 digits");
		}
		if (patient.getTransferStatus() == null || !patient.getTransferStatus().name().equalsIgnoreCase("PENDING")) {
			error.add("transfer_status must be PENDING before the record is processed");
		}

		return error;
	}

	public static boolean isCritical(Patient patient) {
		if ((patient.getConditionStatus().equals(ConditionStatus.Critical))
				|| ((patient.getAdmissionType().equals(AdmissionType.Emergency)) && (patient.getTriage_score() >= 7))
				|| ((patient.getConditionStatus().equals(ConditionStatus.Moderate))
						&& (patient.getTriage_score() >= 8))) {
			return true;
		}
		return false;
	}
}
