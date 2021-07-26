<?php # Script 9.5 - register.php #2
// This script performs an INSERT query to add a record to the users table.

$page_title = 'Record New Case';

// Check for form submission:
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	require ('db_connection.php'); // Connect to the db.	

	$doctor_user = $_POST['doctor_user'];
	$recordID = 0;
	$citizenID = "";
	$errors = array(); // Initialize an error array.

	// Check for citizen ID:
	if (empty($_POST['citizenID'])) {
		$errors[] = "Forget to input citizen ID or this citizen has not registered yet!";
	} else {
		$citizenID = mysqli_real_escape_string($dbc, trim($_POST['citizenID']));
	}//end if: Checking username

	// Check for illness:
	if (empty($_POST['illness'])) {
		$errors[] = "What's wrong with the patient? Please enter illness name.";
	} else {
		$illness = $_POST['illness'];
	}//end if-else
	
	// Check for discription of the illness:
	if (empty($_POST['discription'])) {
		$errors[] = 'Please descibe detailed situation of the patient in brief!';
	} else {
		$discription = $_POST['discription'];
	}//end if-else

	$q = 'SELECT * FROM diagonse';
	$result = @mysqli_query($dbc, $q);
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{		
		$recordID = $row['recordID'];
	}//end loop
	
	$q = "SELECT real_name FROM doctor WHERE username = '$doctor_user'";
	$result = @mysqli_query($dbc, $q);
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{		
		$real_name = $row['real_name'];
	}//end loop
	
	$recordID += 1;
		
	if (empty($errors)) { // If everything's OK.
			
		// Make the query:
		$q = "INSERT INTO diagonse (recordID, citizenID, doctor_user, illness, discription, dig_time) 
		VALUES ('$recordID', '$citizenID', '$doctor_user', '$illness', '$discription', NOW() );";			
		$r = @mysqli_query ($dbc, $q); // Run the query.
		if ($r) { // If it ran OK.
		
			// Print a message:
			echo '<h1>Thank you, Doctor '.$real_name.' for providing us the patient\'s new case!</h1>
			Jumping to patient checking page...</p><p><br /></p>';	
		
		} else { // If it did not run OK.
			
			// Public message:
			echo '<h1>System Error</h1>
			<p class="error">You could not be able to enter the data, check the patient yourself immediately! We are sorry about the system crash!</p>'; 
			
			// Debugging message:
			echo '<p>' . mysqli_error($dbc) . '<br /><br />Query: ' . $q . '</p>';
						
		} // End of if ($r) IF.
		
		mysqli_close($dbc); // Close the database connection.

		// Include the footer and quit the script:
		include ('includes/footer.html'); 
		exit();
		
	} else { // Report the errors.
	
		echo '<h1>Error!</h1>
		<p class="error">The following error(s) occurred:<br />';
		foreach ($errors as $msg) { // Print each error.
			echo " - $msg<br />\n";
		}
		echo '</p><p>Please try again.</p><p><br /></p>';
		
	} // End of if (empty($errors)) IF.
	
	mysqli_close($dbc); // Close the database connection.

} // End of the main Submit conditional.



?>