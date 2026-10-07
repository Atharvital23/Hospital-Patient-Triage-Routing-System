package com.kiranacademy.hospital.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiranacademy.hospital.dao.PatientDAO;
import com.kiranacademy.hospital.entity.Patient;
import com.kiranacademy.hospital.enums.AdmissionType;
import com.kiranacademy.hospital.enums.ConditionStatus;
import com.kiranacademy.hospital.enums.Gender;
import com.kiranacademy.hospital.enums.TransferStatus;

public class PatientRoutingService implements PatientDAO {

	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
//	private ResultSet resultSet = null;

	private static final String GET_PENDING_RECORDS = "SELECT * FROM `hospital_patient_intake` WHERE `transfer_status`='PENDING'";
	private static final String INSERT_CRITICAL = "INSERT INTO `critical_care_patients` (source_patient_id, patient_name, age, disease, admission_type, condition_status, triage_score, doctor_name) VALUES (?,?,?,?,?,?,?,?)";
	private static final String INSERT_GENERAL = "INSERT INTO `general_care_patients` (source_patient_id, patient_name, age, disease, admission_type, condition_status, triage_score, doctor_name) VALUES (?,?,?,?,?,?,?,?)";
	private static final String MARK_PROCESSED = "UPDATE `hospital_patient_intake` SET `transfer_status` = 'PROCESSED', `processed_at` = ? WHERE `patient_id` = ?";
//	private static final String GET_PATIENT_BY_ID = "SELECT * FROM `hospital_patient_intake` WHERE `patient_id`=?";
	private static final String QUERY_CRITICAL = "SELECT 1 FROM critical_care_patients WHERE `source_patient_id` = ?";
	private static final String QUERY_GENERAL = "SELECT 1 FROM general_care_patients WHERE `source_patient_id` = ?";

	@Override
	public List<Patient> getPendingPatients(Connection con) {
		List<Patient> list = new ArrayList<Patient>();
		try {
			statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_PENDING_RECORDS);

			while (resultSet.next()) {
				list.add(new Patient(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
						resultSet.getString(4) != null ? Gender.valueOf(resultSet.getString(4)) : null,
						resultSet.getString(5),
						resultSet.getString(6) != null ? AdmissionType.valueOf(resultSet.getString(6)) : null,
						resultSet.getString(7) != null ? ConditionStatus.valueOf(resultSet.getString(7)) : null,
						resultSet.getInt(8), resultSet.getString(9),
						resultSet.getDate(10) != null ? resultSet.getDate(10).toLocalDate() : null,
						resultSet.getString(11),
						resultSet.getString(12) != null ? TransferStatus.valueOf(resultSet.getString(12)) : null,
						resultSet.getTimestamp(13) != null ? resultSet.getTimestamp(13).toLocalDateTime() : null,
						resultSet.getTimestamp(14) != null ? resultSet.getTimestamp(14).toLocalDateTime() : null));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insertCriticalPatient(Patient patient, Connection con) {
		try {
			preparedStatement = con.prepareStatement(INSERT_CRITICAL);
			preparedStatement.setInt(1, patient.getPatient_id());
			preparedStatement.setString(2, patient.getPatient_name());
			preparedStatement.setInt(3, patient.getAge());
			preparedStatement.setString(4, patient.getDisease());
			preparedStatement.setString(5, patient.getAdmissionType().name());
			preparedStatement.setString(6, patient.getConditionStatus().name());
			preparedStatement.setInt(7, patient.getTriage_score());
			preparedStatement.setString(8, patient.getDoctor_name());
//			preparedStatement.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertGeneralPatient(Patient patient, Connection con) {
		try {
			preparedStatement = con.prepareStatement(INSERT_GENERAL);
			preparedStatement.setInt(1, patient.getPatient_id());
			preparedStatement.setString(2, patient.getPatient_name());
			preparedStatement.setInt(3, patient.getAge());
			preparedStatement.setString(4, patient.getDisease());
			preparedStatement.setString(5, patient.getAdmissionType().name());
			preparedStatement.setString(6, patient.getConditionStatus().name());
			preparedStatement.setInt(7, patient.getTriage_score());
			preparedStatement.setString(8, patient.getDoctor_name());
//			preparedStatement.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void markProcessed(int patientId, Connection con) {
		try (PreparedStatement ps = con.prepareStatement(MARK_PROCESSED)) {
			ps.setTimestamp(1, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps.setInt(2, patientId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean alreadyTransferred(int patientId, Connection con) {
		try {
			try (PreparedStatement ps = con.prepareStatement(QUERY_CRITICAL)) {
				ps.setInt(1, patientId);
				if (ps.executeQuery().next()) {
					return true;
				}
			}
			try (PreparedStatement ps = con.prepareStatement(QUERY_GENERAL)) {
				ps.setInt(1, patientId);
				if (ps.executeQuery().next()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
