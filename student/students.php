<?php

session_start();

// Kiểm tra nếu người dùng chưa đăng nhập, chuyển hướng về trang đăng nhập
if (!isset($_SESSION['user_id'])) {
    header("Location: index.php");
    exit();
}

// Kết nối đến StudentManager
include 'StudentManager.php';

$studentManager = new StudentManager();

// Lấy danh sách sinh viên
$students = $studentManager->getAllStudents();

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Manager</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Welcome, <?php echo $_SESSION['username']; ?>!</h2>
    <p>This is the main page after successful login.</p>
    <a href="logout.php" class="btn btn-danger">Logout</a>

    <h3>Student List</h3>

    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <!-- Add other columns as needed -->
        </tr>
        </thead>
        <tbody>
        <?php foreach ($students as $student): ?>
            <tr>
                <td><?php echo $student['id']; ?></td>
                <td><?php echo $student['name']; ?></td>
                <!-- Add other columns as needed -->
            </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
</div>

</body>
</html>
