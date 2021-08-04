<?php
$a = $_POST['userid'];
$b = $_POST["username"];
$c = $_POST["product"];
$d = $_POST["fb"];
$xml = new DomDocument();
$xml->load("form.xml");
$xml->formatOutput = true;
$global = $xml->documentElement;
$global = $xml->firstChild;
$root = $xml->getElementsByTagName('feedbacks');
$newFb = $xml->createElement('feedback');
$newFb->setAttribute('userid', $a);
$newFb->setAttribute('username', $b);
$newFb->setAttribute('product', $c);
$newFb->setAttribute('fb', $d);

$global->appendChild($newFb);
$xml->save("form.xml");
echo "<div style=\"height: 100vh; width: 100%; display: flex; align-items: center; justify-content: center; font-size: 4rem\">Feedback added successfully.</div>";