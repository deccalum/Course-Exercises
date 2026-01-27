-- CREATE DATABASE school_management; -- Run once, then connect to it
-- \c school_management;            -- psql connect command

-- Clean slate for repeatable runs (drop children before parents)
DROP TABLE IF EXISTS attendance;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;

-- 1. DDL: tables
CREATE TABLE IF NOT EXISTS courses (
    id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    credits INT NOT NULL CHECK (credits > 0)
);

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    class_group INT NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    enrollment_date DATE NOT NULL,
    attendance INT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS attendance (
    id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES students(id),
    status TEXT NOT NULL CHECK (status IN ('present', 'absent')),
    attendance_date DATE NOT NULL DEFAULT CURRENT_DATE
);

-- 2. DML: insert/update/delete
INSERT INTO courses (course_name, credits) VALUES
('Database Systems', 4),
('Web Development', 3),
('Data Structures', 4);

UPDATE courses
SET credits = 5
WHERE course_name = 'Database Systems';

DELETE FROM courses
WHERE course_name = 'Web Development';

INSERT INTO students (class_group, student_name, enrollment_date, attendance) VALUES
(1, 'Alice Johnson',   '2023-09-01', 1),
(1, 'Bob Smith',       '2023-09-02', 1),
(3, 'Charlie Brown',   '2023-09-03', 1),
(2, 'David Wilson',    '2023-09-04', 1),
(1, 'Jennifer Davis',  '2023-09-05', 1);

INSERT INTO attendance (student_id, status, attendance_date) VALUES
(1, 'present', '2023-09-01'),
(2, 'absent',  '2023-09-01'),
(3, 'present', '2023-09-02');

-- 3. DQL: basic selects and filters
SELECT * FROM courses;

SELECT * FROM students;

SELECT * FROM students
WHERE class_group = 1;

SELECT * FROM students
WHERE student_name LIKE 'J%';

-- 4. Joins
SELECT s.student_name, a.status, a.attendance_date
FROM students s
INNER JOIN attendance a ON a.student_id = s.id; -- only students with attendance rows

SELECT s.student_name, a.status, a.attendance_date
FROM students s
LEFT JOIN attendance a ON a.student_id = s.id; -- include students with no attendance rows

-- 5. Aggregation and grouping
SELECT COUNT(*) AS total_students FROM students;

SELECT status, COUNT(*) AS total
FROM attendance
GROUP BY status
ORDER BY status;

SELECT s.student_name, COUNT(*) AS days_present
FROM students s
LEFT JOIN attendance a ON a.student_id = s.id AND a.status = 'present'
GROUP BY s.student_name
ORDER BY s.student_name;