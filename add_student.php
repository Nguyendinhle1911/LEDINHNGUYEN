
<?php
include 'StudentManager.php';
$studentManager = new StudentManager();

// Kiểm tra xem ID học sinh có được gửi qua GET không
if (isset($_GET['id'])) {
    $id = $_GET['id'];

    // Nếu form chỉnh sửa đã được gửi, cập nhật học sinh
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $name = $_POST['Name'];
        $address = $_POST['Address'];
        $studentManager->updateStudent($id, $name, $address);
        header('Location: students.php');
        exit;
    }

    // Lấy thông tin học sinh để hiển thị trong form
    $student = $studentManager->getStudentById($id);
} else {
    // Nếu không có ID học sinh, chuyển hướng người dùng về trang danh sách
    header("Location: students.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Edit Student</h2>
    <form method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="Name" name="Name" value="<?php echo $student['Name']; ?>" required>
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="Address" name="Address" value="<?php echo $student['Address']; ?>" required>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>