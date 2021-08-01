<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
	<title>Post</title>
</head>

<body>
	<main>
		<?php
		// Create a connection instance
		$host = "localhost";
		$user = "root";
		$password = "";
		$conn = mysqli_connect($host, $user, $password, "user");

		// Check connection
		if ($conn === false) {
			die("ERROR: Could not connect to the database. "
				. mysqli_connect_error());
		}
		// Taking all 5 values from the form data(input)
		$first_name =  $_REQUEST['first_name'];
		$last_name = $_REQUEST['last_name'];
		$gender =  $_REQUEST['gender'];
		$address = $_REQUEST['address'];
		$email = $_REQUEST['email'];

		$sql = "INSERT INTO student (first_name, last_name, gender, address, email) VALUES ('$first_name', '$last_name','$gender','$address','$email')";

		if (mysqli_query($conn, $sql)) {
			echo "<h3>Student created successfully</h3>";

			echo nl2br("\n$first_name $last_name\n "
				. "$gender\n $address\n $email");
		} else {
			echo "ERROR: $sql. "
				. mysqli_error($conn);
		}

		// Close connection
		mysqli_close($conn);
		?>
	</main>
</body>

</html>