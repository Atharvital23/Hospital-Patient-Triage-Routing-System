package com.kiranacademy.hospital.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kiranacademy.hospital.dao.PatientDAO;
import com.kiranacademy.hospital.daoimpl.PatientRoutingService;
import com.kiranacademy.hospital.entity.Patient;

/**
 * this is main business logic
 */
public class BusinessLogic {
	static boolean flag = false;

	public static void businessLogic() {

		PatientDAO dao = new PatientRoutingService();
		Connection connection = DBConnection.getConnection();

		if (connection == null) {
			System.out.println("Connection is not Establish.");
			return;
		}

		List<Patient> pendingList = dao.getPendingPatients(connection);

		if (pendingList == null || pendingList.isEmpty()) {
			System.out.println("There is no Pending Patient.");
			return;
		}

		try {
			connection.setAutoCommit(false);

			ProcessingSummary.setTotalRecords(pendingList.size());

			for (Patient patient : pendingList) {
				if (dao.alreadyTransferred(patient.getPatient_id(), connection)) {
					ProcessingSummary.setSkippedCount(ProcessingSummary.getSkippedCount() + 1);
					ProcessingSummary.setErrorMessages(new ArrayList<>(List.of("Already processed")));
					showRecordStatus(patient, "SKIPPED");
				} else {
					ProcessingSummary.setErrorMessages(PatientValidator.validatePatient(patient));

					if (ProcessingSummary.getErrorMessages().size() == 0) {
						if (PatientValidator.isCritical(patient)) {
							dao.insertCriticalPatient(patient, connection);
							dao.markProcessed(patient.getPatient_id(), connection);
							ProcessingSummary.setSuccessCount(ProcessingSummary.getSuccessCount() + 1);
							ProcessingSummary.setCriticalCareCount(ProcessingSummary.getCriticalCareCount() + 1);
							ProcessingSummary.setErrorMessages(new ArrayList<>(List.of("SUCCESS")));
							showRecordStatus(patient, "CRITICAL CARE");
							connection.commit();

						} else {
							dao.insertGeneralPatient(patient, connection);
							dao.markProcessed(patient.getPatient_id(), connection);
							ProcessingSummary.setSuccessCount(ProcessingSummary.getSuccessCount() + 1);
							ProcessingSummary.setGeneralCareCount(ProcessingSummary.getGeneralCareCount() + 1);
							ProcessingSummary.setErrorMessages(new ArrayList<>(List.of("SUCCESS")));
							showRecordStatus(patient, "GENERAL CARE");
							connection.commit();
						}
					} else {
						connection.rollback();
						ProcessingSummary.setFailureCount(ProcessingSummary.getFailureCount() + 1);
						showRecordStatus(patient, "FAILED");
					}
				}
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void showRecordStatus(Patient patient, String status) {
		if (!flag) {
			System.out.println("KIRAN ACADEMY - HOSPITAL PATIENT ROUTING");
			System.out.println("----------------------------------------");
			flag = true;
		}
		System.out.print("Patient " + patient.getPatient_id() + " -> " + status + " -> " );
		ProcessingSummary.getErrorMessages().forEach(err->System.out.print(err));
		System.out.println();
	}
}
