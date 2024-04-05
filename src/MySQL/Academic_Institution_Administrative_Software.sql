CREATE DATABASE AcademicAdminDB;

USE AcademicAdminDB;

-- Table for user login credentials
CREATE TABLE users (
    username VARCHAR(30),
    password VARCHAR(30)
);

-- Insert default admin user
INSERT INTO users (username, password) VALUES ('admin', 'admin12');

-- Table for student information
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40),
    father_name VARCHAR(40),
    roll_number VARCHAR(20),
    date_of_birth DATE,
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(40),
    class VARCHAR(20),
    section VARCHAR(10),
    course_enrolled VARCHAR(40),
    branch VARCHAR(40),
    admission_date DATE
);

-- Table for teacher information
CREATE TABLE teachers (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40),
    father_name VARCHAR(40),
    employee_id VARCHAR(20),
    date_of_birth DATE,
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(40),
    qualification VARCHAR(40),
    department VARCHAR(40),
    hire_date DATE
);

-- Table for student leave requests
CREATE TABLE student_leaves (
    leave_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    leave_date DATE,
    leave_duration VARCHAR(20),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

-- Table for teacher leave requests
CREATE TABLE teacher_leaves (
    leave_id INT AUTO_INCREMENT PRIMARY KEY,
    teacher_id INT,
    leave_date DATE,
    leave_duration VARCHAR(20),
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
);

-- Table for subjects offered
CREATE TABLE subjects (
    subject_id INT AUTO_INCREMENT PRIMARY KEY,
    subject_name VARCHAR(50),
    course VARCHAR(40),
    branch VARCHAR(40),
    semester INT
);

-- Table for storing marks of students
CREATE TABLE student_marks (
    mark_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    subject_id INT,
    marks_obtained INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
);

-- Table for fee structure
CREATE TABLE fees (
    fee_id INT AUTO_INCREMENT PRIMARY KEY,
    course VARCHAR(20),
    semester INT,
    fee_amount DECIMAL(10,2)
);

-- Table for recording fee payments of students
CREATE TABLE fee_payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    fee_id INT,
    payment_date DATE,
    amount_paid DECIMAL(10,2),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (fee_id) REFERENCES fees(fee_id)
);
