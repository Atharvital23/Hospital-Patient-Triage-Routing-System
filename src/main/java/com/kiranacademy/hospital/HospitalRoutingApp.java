package com.kiranacademy.hospital;

import com.kiranacademy.hospital.service.BusinessLogic;
import com.kiranacademy.hospital.service.ProcessingSummary;

public class HospitalRoutingApp {
	public static void main(String[] args) {
		BusinessLogic.businessLogic();
		ProcessingSummary.showResult();
	}
}
