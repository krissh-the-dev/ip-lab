<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
	<title>Regex validation</title>
</head>

<body>
	<main>
		<h1>PHP Form validation using regex</h1>

		<?php
		$nameErr = $emailErr = $mobilenoErr = $genderErr = $websiteErr = $agreeErr = "";
		$name = $email = $mobileno = $gender = $website = $agree = "";
		if ($_SERVER["REQUEST_METHOD"] == "POST") {
			include 'include/validation.php';
		}
		?>

		<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
			<label for='nameIp'>Name *:</label>
			<input type="text" name="name" id="nameIp" />
			<span class="error"> <?php echo $nameErr; ?> </span> <br>

			<label for="emailIp">Email *:</label>
			<input type="text" name="email" id="emailIp" />
			<span class="error"> <?php echo $emailErr; ?> </span>
			<br>

			<label for="mobilenoIp">Mobile No *:</label>
			<input type="text" name="mobileno" id="mobilenoIp" />
			<span class="error"> <?php echo $mobilenoErr; ?> </span>
			<br>

			<label for="webIp">Website *:</label>
			<input type="text" name="website" id="webIp" />
			<span class="error"><?php echo $websiteErr; ?> </span>
			<br>

			<label for="genderIp">Gender *:</label>
			<input type="radio" name="gender" value="male"> Male
			<input type="radio" name="gender" value="female"> Female
			<input type="radio" name="gender" value="other"> Other
			<span class="error"> <?php echo $genderErr; ?> </span>
			<br>
			<br />

			<label for="agreement">Agree to Terms of Service *:</label>
			<input type="checkbox" name="agree">
			<span class="error"> <?php echo $agreeErr; ?> </span>
			<br>
			<br>

			<input type="submit" name="submit" value="Submit" />
		</form>

		<?php
		if (isset($_POST['submit'])) {
			if ($nameErr == "" && $emailErr == "" && $mobilenoErr == "" && $genderErr == "" && $websiteErr == "" && $agreeErr == "") {
				echo "<h3 color = #FF0001> <b>You have successfully registered.</b> </h3>";
				echo "<h2>Your Input:</h2>";
				echo "Name: " . $name;
				echo "<br>";
				echo "Email: " . $email;
				echo "<br>";
				echo "Mobile No: " . $mobileno;
				echo "<br>";
				echo "Website: " . $website;
				echo "<br>";
				echo "Gender: " . $gender;
			} else {
				echo "<h3> <b>You didn't filled up the form correctly.</b> </h3>";
			}
		}
		?>
	</main>

</body>

</html>