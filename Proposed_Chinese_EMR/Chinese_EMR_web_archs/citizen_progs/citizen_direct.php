<?php # Script 9.5 - register.php #2


if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	echo "Log in successful!\n";
	
	require ('../db_connection.php'); // Connect to the db.
	
	$citizenID = $_POST['ID'];
	$q = "SELECT * FROM citizen WHERE ID = '$citizenID'";
	$result = @mysqli_query($dbc, $q);
	
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{
		echo 'Welcome, citizen '.$row['name'].'<br>Below is your basic information.<br>';
		echo 'Age: '.$row['age'].'<br>';
		echo 'Gender: '.$row['sex'].'<br>';
		echo 'Blood type: '.$row['blood_type'].'<br>';
		if($row['agree_share'] == 1)
			echo 'Agree to share information.';
		else if($row['agree_share'] == 2)
			echo 'Agree to share only when in emergency.';
		else
			echo 'Die for privacy!';
		echo '<br><br>';
	}//end loop
	
	echo "<form action=\"citizen_update_page.php\" method=\"post\" />";
	echo "<input type=\"hidden\" name=\"citizenID\" value=\"".$citizenID."\" />";
	echo "<input type=\"submit\" name=\"submit\" value=\"Update My Information\" /><br><br>";
	echo "</form>";
	
	echo "<form action=\"citizen_check_history.php\" method=\"post\" />";
	echo "<input type=\"hidden\" name=\"citizenID\" value=\"".$citizenID."\" />";
	echo "<input type=\"submit\" name=\"submit\" value=\"Check My Health History\" />";
	echo "</form>";
}//end if: Post method

include("../includes/footer.html");
?>