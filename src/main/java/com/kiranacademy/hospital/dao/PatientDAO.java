package com.kiranacademy.hospital.dao;

import java.sql.Connection;
import java.util.List;

import com.kiranacademy.hospital.entity.Patient;

public interface PatientDAO {
	/**
	 * fetches all patient records from the database `hospital_patient_intake` table 
     * whose transfer_status is currently set to `PENDING`.
     * 
	 * @param con
	 * @return A List of Patient objects representing the pending records.
	 */
	List<Patient> getPendingPatients(Connection con);

	/**
	 * inserts a patient record into the `critical_care_patients` destination table 
     * after being evaluated as a critical case.
     * 
	 * @param patient
	 * @param con
	 */
	void insertCriticalPatient(Patient patient, Connection con);

	/**
	 * inserts a patient record into the `general_care_patients` destination table 
     * after being evaluated as a general case.
	 * 
	 * @param patient
	 * @param con
	 */
	void insertGeneralPatient(Patient patient, Connection con);

	/**
	 * updates the source `hospital_patient_intake` record's transfer status to `PROCESSED` 
     * and records the timestamp once the patient has been successfully routed.
     * 
	 * @param patientId
	 * @param con
	 */
	void markProcessed(int patientId, Connection con);

	/**
	 * Checks whether a specific patient record has already been transferred 
     * or processed to prevent duplicate entries.
     * 
	 * @param patientId
	 * @param con
	 * @return
	 */
	boolean alreadyTransferred(int patientId, Connection con);
}
