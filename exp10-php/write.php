<?php
echo implode(', ', $_POST);
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

// $item0 = $xml->createElement("User");
// $item1 = $xml->createElement("UserID");
// $item2 = $xml->createElement("UserName");
// $item3 = $xml->createElement("Product");
// $item4 = $xml->createElement("FeedBack");

// $item0->appendChild($item1);
// $item0->appendChild($item2);
// $item0->appendChild($item3);
// $item0->appendChild($item4);
// $item1->nodeValue = $a;
// $item2->nodeValue = $b;
// $item3->nodeValue = $c;
// $item4->nodeValue = $d;

//echo $xml->save("form.xml");