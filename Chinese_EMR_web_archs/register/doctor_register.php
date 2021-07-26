<?php # Script 9.5 - register.php #2
// This script performs an INSERT query to add a record to the users table.

$page_title = 'Doctor Register Page';

// Check for form submission:
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	require ('../db_connection.php'); // Connect to the db.

	$username = trim(strip_tags($_POST['username']));
	$citizenID = trim(strip_tags($_POST['ID']));
	$password = trim(strip_tags($_POST['password']));
	$confirm_pass = trim(strip_tags($_POST['c_pass']));
	$real_name = trim(strip_tags($_POST['name']));
	$hospital = $_POST['hospital'];
	//echo $hospital;
	
	$errors = array(); // Initialize an error array.
	//$data = array($citizenID, $name, $password, $confirm_pass, $age, $sex, $blood_type, $agree_share);
	
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
	
	$q = "SELECT ID FROM doctor WHERE username = '$username'";
	$r = @mysqli_query ($dbc, $q); // Run the query.

	if(mysqli_num_rows($r) >= 1)
		$errors[] = "You already registered, please log in!";
	
	$hospitalID = 0;
	$q = "SELECT hospitalID FROM hospitals WHERE name = '$hospital'";
	$r = @mysqli_query($dbc, $q); // Run the query.
	while($row = mysqli_fetch_array($r, MYSQLI_ASSOC))
	{
		$hospitalID = $row['hospitalID'];
	}//end loop
	
	if (empty($errors)) { // If everything's OK.
		$q = "INSERT INTO doctor (username, ID, hospitalID, password, real_name, register_time) 
		VALUES ('$username', '$citizenID', '$hospitalID', '".SHA1($password)."','$real_name', NOW());";			
		$r = @mysqli_query ($dbc, $q); // Run the query.
		
		//echo $q;
		
		if($r)
		{
			echo "Registering...and successful!\n";
		}else {		
			echo "Writing to database fails! Sorry for system error!\n";	
			echo '<p>' . mysqli_error($dbc) . '<br /><br />Query: ' . $q . '</p>';				
		} // End of if ($r) IF.
	}else{
		/*echo '<br>';
		foreach($errors as $error)
			echo $error;
		
		setcookie('wrong_citizen_id', $data[0]);
		setcookie('wrong_name',  $data[1]);
		setcookie('wrong_password',  $data[2]);
		setcookie('wrong_confrim_password',  $data[3]);	
		setcookie('wrong_age',  $data[4]);*/
		echo "Register fails! If already registered, try log in!";
		
		/*echo "<form action=\"register_page.php\" method=\"cookie\"
			<input type=\"submit\" name=\"submit\" value=\"GET IT\" />
		</form>";*/
		
		include("register_identity.html");
	}//Registering errors happen
	
	//end if: Registering db.
	
	mysqli_close($dbc); // Close the database connection.

} // End of the main Submit conditional.
?>