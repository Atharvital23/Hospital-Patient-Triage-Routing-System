CREATE DATABASE hospital;
USE hospital;

CREATE TABLE hospital_patient_intake (
    patient_id INT,                      
    patient_name VARCHAR(100) NOT NULL,                             
    age INT NOT NULL,                                               
    gender VARCHAR(10) NOT NULL,                                    
    disease VARCHAR(120) NOT NULL,                                  
    admission_type VARCHAR(20) NOT NULL,                            
    condition_status VARCHAR(20) NOT NULL,                          
    triage_score INT NOT NULL,                                      
    doctor_name VARCHAR(100) NOT NULL,                              
    admission_date DATE NOT NULL,                                   
    mobile VARCHAR(15) NOT NULL,                                    
    transfer_status VARCHAR(20) DEFAULT 'PENDING',                  
    processed_at DATETIME DEFAULT NULL,                             
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP                   
);

CREATE TABLE critical_care_patients (
    critical_id INT AUTO_INCREMENT PRIMARY KEY,                 
    source_patient_id INT UNIQUE NOT NULL,                      
    patient_name VARCHAR(100) NOT NULL,                         
    age INT NOT NULL,                                           
    disease VARCHAR(120) NOT NULL,                              
    admission_type VARCHAR(20) NOT NULL,                        
    condition_status VARCHAR(20) NOT NULL,                      
    triage_score INT NOT NULL,                                  
    doctor_name VARCHAR(100) NOT NULL,                          
    routed_at DATETIME DEFAULT CURRENT_TIMESTAMP                
);

CREATE TABLE general_care_patients (
    general_id INT AUTO_INCREMENT PRIMARY KEY,                 
    source_patient_id INT UNIQUE NOT NULL,                      
    patient_name VARCHAR(100) NOT NULL,                         
    age INT NOT NULL,                                           
    disease VARCHAR(120) NOT NULL,                              
    admission_type VARCHAR(20) NOT NULL,                        
    condition_status VARCHAR(20) NOT NULL,                      
    triage_score INT NOT NULL,                                  
    doctor_name VARCHAR(100) NOT NULL,                          
    routed_at DATETIME DEFAULT CURRENT_TIMESTAMP                
);
