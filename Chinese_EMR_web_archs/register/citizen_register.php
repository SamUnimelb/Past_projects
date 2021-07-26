<?php # Script 9.5 - register.php #2
// This script performs an INSERT query to add a record to the users table.

$page_title = 'Citizen Register Page';

// Check for form submission:
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	require('../db_connection.php'); // Connect to the db.
	
	$citizenID = trim(strip_tags($_POST['ID']));
	$name = strip_tags($_POST['name']);
	$password = trim(strip_tags($_POST['password']));
	$confirm_pass = trim(strip_tags($_POST['confirm_pass']));
	$age = $_POST['age'];
	$sex = $_POST['gender'];
	$blood_type = $_POST['blood_type'];
	$agree_share = $_POST['agree_share'];
	
	$errors = array(); // Initialize an error array.
	$data = array($citizenID, $name, $password, $confirm_pass, $age, $sex, $blood_type, $agree_share);
	
	if(empty($password))
		$errors[] = "You must enter your password!\n";
	
	if($password != $confirm_pass)
		$errors[] = "You entered a different password at confirming time!\n";
		
	// Check for citizen ID:
	if(strlen(trim($citizenID)) != 18)
	{
		$errors[] = "Your citizen ID is not valid, please check again!\n";
	} else {
		$citizenID = mysqli_real_escape_string($dbc, $citizenID);
	}//end if: Checking username
	
	// Check for illness:
	if (!is_numeric($age)) {
		$errors[] = "Value of your age is not valid!\n";
	}//end checking

	$q = "SELECT ID FROM citizen WHERE ID = '$citizenID'";
	$r = @mysqli_query ($dbc, $q); // Run the query.
	
	//echo $citizenID;
		
	if(mysqli_num_rows($r) == 1)
		$errors[] = "You already registered, please log in!";
	
	if (empty($errors)) { // If everything's OK.
		$q = "INSERT INTO citizen (ID, name, password, age, sex, blood_type, agree_share) 
		VALUES ('$citizenID', '$name', "."'".SHA1('$password')."'".", '$age', '$sex', '$blood_type', '$agree_share');";			
		$r = @mysqli_query ($dbc, $q); // Run the query.
		
		if($r)
		{
			echo 'Your ID: '.$citizenID.'<br>'.
			'Your name: '.$name.'<br>'.
			'Your password: '.$password.'<br>'.
			'Your age: '.$age.'<br>'.
			'Your gender: '.$sex.'<br>'.
			'Your blood type: '.$blood_type.'<br>'.
			'Your share policy: ';
			if($agree_share == 1)
				echo 'Agree to share to doctors at any time.<br>';
			else if($agree_share == 2)
				echo 'Agree to share to doctors only in emergencies.<br>';
			else if($agree_share == 3)
				echo 'Willing to die for privacy.<br>';
			
			echo "Registering...\n";
		}else {		
			echo "Writing to database fails! Sorry for system error!\n";	
			echo '<p>' . mysqli_error($dbc) . '<br /><br />Query: ' . $q . '</p>';				
		} // End of if ($r) IF.
	}else{
		echo '<br>';
		foreach($errors as $error)
			echo $error;
		
		setcookie('wrong_citizen_id', $data[0]);
		setcookie('wrong_name',  $data[1]);
		setcookie('wrong_password',  $data[2]);
		setcookie('wrong_confrim_password',  $data[3]);	
		setcookie('wrong_age',  $data[4]);
		
		echo "<form action=\"register_page.php\" method=\"cookie\"
			<input type=\"submit\" name=\"submit\" value=\"GET IT\" />
		</form>";
		
		include("register_page.php");
	}//Registering errors happen
	
	//end if: Registering db.
	
	mysqli_close($dbc); // Close the database connection.

} // End of the main Submit conditional.
?>