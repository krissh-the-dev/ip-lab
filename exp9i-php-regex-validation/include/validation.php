<?php
function input_data($data)
{
	$data = trim($data);
	$data = stripslashes($data);
	$data = htmlspecialchars($data);
	return $data;
}

//String Validation
if (empty($_POST["name"])) {
	$nameErr = "Name is required";
} else {
	$name = input_data($_POST["name"]);
	// check if name only contains letters and whitespace
	if (!preg_match("/^[a-zA-Z ]*$/", $name)) {
		$nameErr = "Only alphabets and white space are allowed";
	}
}

//Email Validation
if (empty($_POST["email"])) {
	$emailErr = "Email is required";
} else {
	$email = input_data($_POST["email"]);
	// check if the e-mail address is well-formed
	if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
		$emailErr = "Invalid email format";
	}
}

if (empty($_POST["mobileno"])) {
	$mobilenoErr = "Mobile no is required";
} else {
	$mobileno = input_data($_POST["mobileno"]);
	if (!preg_match("/^[0-9]*$/", $mobileno)) {
		$mobilenoErr = "Only numeric value is allowed.";
	}
	if (strlen($mobileno) != 10) {
		$mobilenoErr = "Mobile no must contain 10 digits.";
	}
}

//URL Validation
if (empty($_POST["website"])) {
	$website = "";
} else {
	$website = input_data($_POST["website"]);
	// check if URL address syntax is valid
	if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i", $website)) {
		$websiteErr = "Invalid URL";
	}
}

//Empty Field Validation
if (empty($_POST["gender"])) {
	$genderErr = "Gender is required";
} else {
	$gender = input_data($_POST["gender"]);
}

//Checkbox Validation
if (!isset($_POST['agree'])) {
	$agreeErr = "Accept terms of services before submit.";
} else {
	$agree = input_data($_POST["agree"]);
}