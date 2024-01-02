<!DOCTYPE html>
<html>
<body>

<?php
class Fruit {
    // Properties
    var $name;
    var $color;

    // Methods
    function __construct($name, $color) {
        $this->name = $name;
        $this->color = $color;
    }
    function __destruct() {
        echo "The fruit is {$this->name} and the color is {$this->color}.";
    }
}

$apple = new Fruit("Apple", "red");
?>

</body>
</html>

