<?php
session_start();
if($_SERVER["REQUEST_METHOD"]=="POST"){
    $validUsername ="admin";
    $validPassword ="admin123";
    $enteredUsername = $_POST["username"];
    $enteredPassword = $_POST["password"];
    if($enteredUsername ==$validUsername && $enteredPassword==$validPassword){
        $_SESSION["username"] =$enteredUsername;
        header("Location: hello.php");
        exit();
    }else{
        echo "Sai username of password. Moi thu lai";
    }
}
