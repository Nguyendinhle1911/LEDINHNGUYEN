<?php
echo date("d.m.Y.l");
echo date("h:i:sa");
$a=mktime(11,3,5,1,4,2019);
echo date("h:i:sa d.m.Y",$a);