
<?php # Script 9.5 - register.php #2
// This script performs an INSERT query to add a record to the users table.

$page_title = 'Your Health History:';

// Check for form submission:
//if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	require ('../../mysqli_doctorweb.php'); // Connect to the db.
	
	$citizenID = $_POST['citizenID'];
	$q = "SELECT * FROM citizen WHERE ID = '$citizenID'";
	$result = @mysqli_query($dbc, $q);
	
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{
		echo 'Name: '.$row['name'].'<br>';
		echo 'Age: '.$row['age'].'<br>';
		echo 'Gender: '.$row['sex'].'<br>';
		echo 'Blood type: '.$row['blood_type'].'<br>';
		if($row['agree_share'] == 1)
			echo 'Agree to share information.';
		else
			echo 'Do not agree to share even under extreme emergency.';
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
	
	echo 'Your health history: <br>';
	for($index = 0; $index < $record_nums; $index++)
	{
		echo 'Record: '.$recordIDs[$index].'<br>';
		$query = "SELECT * FROM hospitals as H WHERE H.hospitalID = 
			(SELECT D.hospitalID
            from doctor as D
            WHERE D.username = '$doctor_users[$index]')";
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
		
	
?>