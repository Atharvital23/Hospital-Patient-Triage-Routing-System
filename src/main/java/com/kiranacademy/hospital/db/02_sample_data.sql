INSERT INTO hospital_patient_intake 
(patient_name, age, gender, disease, admission_type, condition_status, triage_score, doctor_name, admission_date, mobile, transfer_status) 
VALUES 
-- 1. Regular Stable -> General Care
('Rahul Patil', 45, 'Male', 'Diabetes', 'Regular', 'Stable', 4, 'Dr. Sharma', '2026-06-01', '9876543210', 'PENDING'),

-- 2. Emergency Moderate (Triage >= 8) -> Critical Care
('Priya Shah', 32, 'Female', 'Cardiac Arrest', 'Emergency', 'Moderate', 9, 'Dr. Mehta', '2026-06-02', '8765432109', 'PENDING'),

-- 3. Critical Condition -> Critical Care
('Amit Jadhav', 50, 'Male', 'Severe Trauma', 'Regular', 'Critical', 6, 'Dr. Joshi', '2026-06-02', '7654321098', 'PENDING'),

-- 4. Emergency Stable (Triage >= 7) -> Critical Care
('Sneha More', 28, 'Female', 'Asthma Attack', 'Emergency', 'Stable', 8, 'Dr. Kulkarni', '2026-06-03', '6543210987', 'PENDING'),

-- 5. Regular Moderate (Triage < 8) -> General Care
('Raj Kumar', 40, 'Male', 'Viral Fever', 'Regular', 'Moderate', 5, 'Dr. Verma', '2026-06-03', '5432109876', 'PENDING'),

-- 6. Regular Stable -> General Care
('Neha Patil', 25, 'Female', 'Migraine', 'Regular', 'Stable', 3, 'Dr. Rao', '2026-06-04', '4321098765', 'PENDING'),

-- 7. Regular Stable -> General Care
('John Dmello', 60, 'Male', 'Hypertension', 'Regular', 'Stable', 5, 'Dr. Deshmukh', '2026-06-04', '3210987654', 'PENDING'),

-- 8. Emergency Moderate (Triage >= 7) -> Critical Care
('Anita Roy', 35, 'Female', 'Appendicitis', 'Emergency', 'Moderate', 7, 'Dr. Sen', '2026-06-05', '2109876543', 'PENDING'),

-- 9. Emergency Critical -> Critical Care
('Vikram Singh', 55, 'Male', 'Stroke', 'Emergency', 'Critical', 10, 'Dr. Kapoor', '2026-06-05', '1098765432', 'PENDING'),

-- 10. Regular Stable -> General Care
('Pooja Deshmukh', 22, 'Female', 'Gastroenteritis', 'Regular', 'Stable', 4, 'Dr. Kadam', '2026-06-06', '9988776655', 'PENDING'),

-- 11. Regular Moderate -> General Care
('Rameshwar Kale', 65, 'Male', 'Pneumonia', 'Regular', 'Moderate', 6, 'Dr. Shinde', '2026-06-06', '8877665544', 'PENDING'),

-- 12. Regular Stable -> General Care
('Sunita Mane', 48, 'Female', 'Kidney Stone', 'Regular', 'Stable', 5, 'Dr. Pawar', '2026-06-07', '7766554433', 'PENDING'),

-- 13. Emergency Stable (Triage >= 7) -> Critical Care
('Kiran More', 30, 'Male', 'Fracture', 'Emergency', 'Stable', 7, 'Dr. Joshi', '2026-06-07', '6655443322', 'PENDING'),

-- 14. Regular Moderate (Triage >= 8) -> Critical Care
('Aarti Deshmukh', 29, 'Female', 'Dengue', 'Regular', 'Moderate', 8, 'Dr. Sharma', '2026-06-08', '5544332211', 'PENDING'),

-- 15. Emergency Critical -> Critical Care
('Manoj Tiwari', 52, 'Male', 'Chest Pain', 'Emergency', 'Critical', 9, 'Dr. Mehta', '2026-06-08', '4433221100', 'PENDING'),

-- 16. Regular Stable -> General Care
('Divya Kulkarni', 38, 'Female', 'Thyroid', 'Regular', 'Stable', 4, 'Dr. Rao', '2026-06-09', '3322110099', 'PENDING'),

-- 17. Regular Stable -> General Care
('Rauf Khan', 42, 'Male', 'Malaria', 'Regular', 'Stable', 5, 'Dr. Verma', '2026-06-09', '2211009988', 'PENDING'),

-- 18. Regular Stable -> General Care
('Smita Joshi', 33, 'Female', 'Bronchitis', 'Regular', 'Stable', 3, 'Dr. Kadam', '2026-06-10', '1100998877', 'PENDING'),

-- 19. TEST CASE: Validation Failure (Patient name too short: < 3 characters)
('Ab', 25, 'Male', 'Fever', 'Regular', 'Stable', 5, 'Dr. Sharma', '2026-06-10', '9898989898', 'PENDING'),

-- 20. TEST CASE: Validation Failure (Invalid age > 120, invalid triage > 10, future date, invalid mobile)
('Test Patient', 130, 'Female', 'Injury', 'Emergency', 'Critical', 12, 'Dr. Joshi', '2030-01-01', '12345', 'PENDING');
