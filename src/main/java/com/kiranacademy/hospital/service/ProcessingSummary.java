package com.kiranacademy.hospital.service;

import java.util.ArrayList;
import java.util.List;

public class ProcessingSummary {
	private static int totalRecords;
	private static int successCount;
	private static int failureCount;
	private static int skippedCount;
	private static int criticalCareCount;
	private static int generalCareCount;
	private static List<String> errorMessages = new ArrayList<>();

	public ProcessingSummary() {
	}

	public ProcessingSummary(int totalRecords, int successCount, int failureCount, int skippedCount,
			int criticalCareCount, int generalCareCount, List<String> errorMessages) {
		ProcessingSummary.totalRecords = totalRecords;
		ProcessingSummary.successCount = successCount;
		ProcessingSummary.failureCount = failureCount;
		ProcessingSummary.skippedCount = skippedCount;
		ProcessingSummary.criticalCareCount = criticalCareCount;
		ProcessingSummary.generalCareCount = generalCareCount;
		ProcessingSummary.errorMessages = errorMessages;
	}

	public static int getTotalRecords() {
		return totalRecords;
	}

	public static void setTotalRecords(int totalRecords) {
		ProcessingSummary.totalRecords = totalRecords;
	}

	public static int getSuccessCount() {
		return successCount;
	}

	public static void setSuccessCount(int successCount) {
		ProcessingSummary.successCount = successCount;
	}

	public static int getFailureCount() {
		return failureCount;
	}

	public static void setFailureCount(int failureCount) {
		ProcessingSummary.failureCount = failureCount;
	}

	public static int getSkippedCount() {
		return skippedCount;
	}

	public static void setSkippedCount(int skippedCount) {
		ProcessingSummary.skippedCount = skippedCount;
	}

	public static int getCriticalCareCount() {
		return criticalCareCount;
	}

	public static void setCriticalCareCount(int criticalCareCount) {
		ProcessingSummary.criticalCareCount = criticalCareCount;
	}

	public static int getGeneralCareCount() {
		return generalCareCount;
	}

	public static void setGeneralCareCount(int generalCareCount) {
		ProcessingSummary.generalCareCount = generalCareCount;
	}

	public static List<String> getErrorMessages() {
		return errorMessages;
	}

	public static void setErrorMessages(List<String> errorMessages) {
		ProcessingSummary.errorMessages = errorMessages;
	}

	public static void showResult() {
		System.out.println("PROCESSING SUMMARY");
		System.out.println("---------------------------------------");
		System.out.println("Total Pending Records : " + getTotalRecords());
		System.out.println("Critical Care         : " + getCriticalCareCount());
		System.out.println("General Care          : " + getGeneralCareCount());
		System.out.println("Validation Failed     : " + getFailureCount());
		System.out.println("Skipped Duplicate     : " + getSkippedCount());
		System.out.println("Successfully Processed: " + getSuccessCount());
	}

}
