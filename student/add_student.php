<?php
session_start();

include 'StudentManager.php';
$studentManager = new StudentManager();
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id = $_POST["id"];
    $name = $_POST["name"];
    $address = $_POST["address"];
    $studentManager->addStudent($id, $name, $address);
    header('Location: dashboard.php');
    exit;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <a href="dashboard.php" class="btn btn-danger">Home</a><br>
    <h2>Add Student</h2>
    <form method="post" action="">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" name="id" required>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" name="address" required>
        </div>
        <button type="submit" class="btn btn-primary">Add Student</button>
    </form>
</div>
</body>
</html>
