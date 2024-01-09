<?php

class StudentManager
{

    private $conn;

    public function __construct()
    {
        // Replace these database connection details with your actual credentials
        $host = "localhost:3306";
        $username = "root";
        $password = "";
        $dbname = "fptaptechdb";
        // Create connection
        $this->conn = new mysqli($host, $username, $password, $dbname);
        // Check connection
        if ($this->conn->connect_error) {
            die("Connection failed: " . $this->conn->connect_error);
        }
    }

    public function getAllStudents()
    {
        $students = [];
        $sql = "SELECT * FROM students";
        $result = $this->conn->query($sql);
        if ($result->num_rows > 0) {
            while ($row = $result->fetch_assoc()) {
                $students[] = $row;
            }
        }
        return $students;
    }

    public function addStudent($ID, $Name, $Address)
    {
        $sql = "INSERT INTO students (ID, Name, Address) VALUES (?, ?, ?)";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("iss", $ID, $Name, $Address);
        if ($stmt->execute()) {
            echo "Student with ID $ID added successfully.\n";
        } else {
            echo "Error adding student: " . $stmt->error . "\n";
        }
        $stmt->close();
    }

    public function getStudentById($ID)
    {
        $sql = "SELECT * FROM students WHERE id = '$ID'";
        $result = $this->conn->query($sql);
        if ($result->num_rows == 1) {
            return $result->fetch_assoc();
        }
        return null;
    }

    public function updateStudent($ID, $Name, $Address)
    {
        $sql = "UPDATE students SET name='$Name', address='$Address' WHERE id='$ID'";
        $this->conn->query($sql);
    }

    public function deleteStudent($ID)
    {
        $sql = "DELETE FROM students WHERE id='$ID'";
        $this->conn->query($sql);
    }

    public function __destruct()
    {
        $this->conn->close();
    }
}
