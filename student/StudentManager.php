<?php

class studentManager
{
    public $conn;

    public function __construct()
    {
        $host = "localhost:3306";
        $username = "root";
        $password = "";
        $dbname = "fptaptechdb";
        $this->conn = new mysqli($host, $username, $password, $dbname);
//check connection
        if ($this->conn->connect_error) {
            die("Connection failed: " . $this->conn->connect_error);
        }
    }

    public function getAllStudents()
    {
        $students = [];
        $sql = "SELECT * FROM students";

        $stmt = $this->conn->prepare($sql);


            $stmt->execute();

            $result = $stmt->get_result();

            while ($row = $result->fetch_assoc()) {
                $students[] = $row;
            }

            $stmt->close();

        return $students;
    }



    public function addStudent($id, $name, $address)
    {
        $sql = "insert into students (ID,Name,Address) values (?,?,?)";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("iss", $id, $name, $address);
        $stmt->execute();

        $stmt->close();
    }

    public function getStudentById($id)
    {
        $sql = "select * from students where ID = ?";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("i", $id);
        $stmt->execute();
        $result = $stmt->get_result();
            return $result->fetch_assoc();
        $stmt->close();
        return null;
    }

    public function updateStudent($id, $name, $address) {
        $sql = "UPDATE students SET Name=?, Address=? WHERE ID=?";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("ssi", $name, $address, $id);
        $stmt->execute();
        $stmt->close();
    }


    public function deleteStudent($id) {
        // Trước tiên, xóa tất cả các điểm liên quan đến sinh viên
        $this->deleteMarksForStudent($id);

        // Sau đó, xóa sinh viên
        $sql = "DELETE FROM students WHERE id=?";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("i", $id);
        $stmt->execute();
        $stmt->close();
    }

    private function deleteMarksForStudent($studentId) {
        $sql = "DELETE FROM marks WHERE student_id=?";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("i", $studentId);
        $stmt->execute();
        $stmt->close();
    }


    public function getMarkDetails() {
        $markDetails = [];
        $sql = "SELECT students.id AS student_id, students.name AS student_name, subjects.name AS subject, marks.mark
            FROM students
            INNER JOIN marks ON students.id = marks.student_id
            INNER JOIN subjects ON marks.subject_id = subjects.id";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $result = $stmt->get_result();
        while ($row = $result->fetch_assoc()) {
            $markDetails[] = $row;
        }
        $stmt->close();
        return $markDetails;
    }
    public function getAllStudentsWithMarks() {
        $students = [];

        // Lấy danh sách sinh viên và số điểm
        $sql = "SELECT students.id, students.name, students.address, COUNT(marks.id) AS mark_count
            FROM students
            LEFT JOIN marks ON students.id = marks.student_id
            GROUP BY students.id, students.name, students.address";

        $result = $this->conn->query($sql);

        if ($result->num_rows > 0) {
            while ($row = $result->fetch_assoc()) {
                $students[] = $row;
            }
        }

        return $students;
    }


    public function __destruct() {
        $this->conn->close();
    }
// Trong StudentManager.php

    public function searchStudents($searchTerm)
    {
        $students = [];
        $sql = "SELECT * FROM students WHERE name LIKE ? OR address LIKE ?";
        $stmt = $this->conn->prepare($sql);
        $searchTerm = '%' . $searchTerm . '%'; // Thêm dấu % để tìm kiếm mọi từ có chứa searchTerm
        $stmt->bind_param("ss", $searchTerm, $searchTerm);
        $stmt->execute();
        $result = $stmt->get_result();

        while ($row = $result->fetch_assoc()) {
            $students[] = $row;
        }

        $stmt->close();

        return $students;
    }



}


