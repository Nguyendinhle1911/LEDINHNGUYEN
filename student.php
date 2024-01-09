<?php
include 'StudentManager.php';
// Handle delete operation
$studentManager = new StudentManager();
{
    if (isset($_GET['action']) && $_GET['action'] === 'delete' && isset($_GET['id'])) {
        $studentManager->deleteStudent($_GET['id']);
    }
}
$students = $studentManager->getAllStudents();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Student List</h2>
    <a href="add_student.php" class="btn btn-success mb-3">Add Student</a>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($students as $student): ?>
            <tr>
                <td><?php echo $student['ID']; ?></td>
                <td><?php echo $student['Name']; ?>
                </td> <td><?php echo $student['Address']; ?></td>
                <td>
                    <a href="edit_student.php?id=<?php echo $student['ID']; ?>"
                       class="btn btn-warning btn-sm">Edit</a>
                    <a href="students.php?action=delete&id=<?php echo $student['ID']; ?>"
                       class="btn btn-danger btn-sm" onclick="return
                    confirm('Are you sure you want to delete this student?!')">Delete</a>
                </td>
            </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
</div>
</body>
</html>
