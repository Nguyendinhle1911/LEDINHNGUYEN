<!DOCTYPE html>
<html lang="en">

<body>
    <?php
    $x = 5;
    $y = "John";
    $age= 18;
    echo $x;
    echo "<br>";
    print $y."<br>";
    print $age."<br>";
    var_dump($x);  //hàm trả về kiểu giá trị


    /*PHẠM VI CỦA BIẾN */
    //phamj vi toàn cầu
    function myTest(){
        echo "<p>Varible x inside function is: $x </p>";
    }
    myTest();
    echo "<p>Varible x inside function is: $x </p>";

    echo $x = $x + $age;

    ?>
</body>
</html>