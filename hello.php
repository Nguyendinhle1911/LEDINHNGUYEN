<?php
session_start();

if (!isset($_SESSION['username'])){
    header("Location: index.html");
    exit();
}
echo "Hello Admin zone!";

?>
<html>
<a href="logout.php">Logout</a>
</html>
