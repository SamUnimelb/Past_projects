<h1>Fetch Patient's History Records:</h1>
<form action="diagnose_read.php" method="post">
	<p>Patient's citizen ID (*): <input type="text" name="citizenID" size="15" maxlength="20" value="
	<?php if (isset($_POST['citizenID'])) echo $_POST['citizenID']; ?>"</p><br />	
	<p><input type="submit" name="submit" value="Check" /></p>
	<p>Note: The (*) columns must be filled up. </p>
</form>

<?php # Script 9.5 - register.php #2
// This script performs an INSERT query to add a record to the users table.

$page_title = 'Record New Case';

// Check for form submission:
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	require ('db_connection.php'); // Connect to the db.
	
	$doctor_user = $_POST['username'];
	$recordID = 0;
	$citizenID = "";
	$name = "";
	$errors = array(); // Initialize an error array.

	// Check for citizen ID:
	if (empty($_POST['citizenID'])) {
		$errors[] = "Forget to input citizen ID or this citizen has not registered yet!";
	} else {
		$citizenID = mysqli_real_escape_string($dbc, trim($_POST['citizenID']));
	}//end if: Checking username
	
	$q = "SELECT * FROM citizen WHERE ID = '$citizenID'";
	$result = @mysqli_query($dbc, $q);
	
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{
		//Patient don't want his / her record be checked, jump back.
		if($row['agree_share'] == 3)
		{
			echo 'This patient does not want his/her record to be shared, <br>
			 please check him/her mannually!<br>';
			 //Should go back to the reading page.
			 //include ('diagnose_read.php');
		}
			
		echo 'Name: '.$row['name'].'<br>';
		echo 'Age: '.$row['age'].'<br>';
		if($row['sex'] == 1)
			echo 'Sex: M <br />';
		elseif($row['sex'] == 2)
			echo 'Sex: F <br />';
		echo 'Blood type: '.$row['blood_type'].'<br>';
		echo '<br><br>';
	}//end loop
	
	$q = "SELECT * FROM diagonse WHERE citizenID = '$citizenID'";
	$result = @mysqli_query($dbc, $q);
	$record_nums = mysqli_num_rows($result);
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{		
		$recordIDs[] = $row['recordID'];
		$doctor_users[] = $row['doctor_user'];
		$illnesses[] = $row['illness'];
		$discriptions[] = $row['discription'];
		$dig_times[] = $row['dig_time'];
	}//end loop
	
	echo 'This patient\'s dark history: <br>';
	for($index = 0; $index < $record_nums; $index++)
	{
		echo 'Record: '.$recordIDs[$index].'<br>';
		$query = "SELECT * FROM hospitals as H WHERE H.hospitalID = 
			(SELECT D.hospitalID
            from doctor as D
            WHERE D.username = 'dr_jiang')";
		$q_result = @mysqli_query($dbc, $query);
		while($row = mysqli_fetch_array($q_result, MYSQLI_ASSOC))
		{		
			$cityID = $row['cityID'];
			echo 'Dignosed by hospital: '.$row['name'].'<br>';
		}//end loop*/
		
		$query = "SELECT C.city, P.province 
		FROM cities as C natural join province as P 
		WHERE C.cityID = '$cityID'";
		$q_result = @mysqli_query($dbc, $query);
		while($row = mysqli_fetch_array($q_result, MYSQLI_ASSOC))
		{
			echo 'In city: '.$row['city'];
			echo ' of province: '.$row['province'].'<br>';	
		}//end loop*/
		
		echo 'Illness name: '.$illnesses[$index].'<br>';
		echo 'Discription: '.$discriptions[$index].'<br>';
		echo '<br>';
	}//end loop: Echo each record
	
	/*$q = "SELECT real_name FROM doctor WHERE username = '$doctor_user'";
	$result = @mysqli_query($dbc, $q);
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{		
		$real_name = $row['real_name'];
	}//end loop*/
	
	mysqli_close($dbc); // Close the database connection.

	// Include the footer and quit the script:
	include ('includes/footer.html'); 
	exit();
		
	} else { // Report the errors.
		echo 'Please enter patient ID. If still have problems, please connect technical person!';
		/*"""echo '<h1>Error!</h1>
		<p class="error">The following error(s) occurred:<br />';
		foreach ($errors as $msg) { // Print each error.
			echo " - $msg<br />\n";
		}
		echo '</p><p>Please try again.</p><p><br /></p>';
		mysqli_close($dbc);"""*/
	} // End of if (empty($errors)) IF.
?>
