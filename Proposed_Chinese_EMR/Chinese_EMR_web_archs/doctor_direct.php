<?php # Script 9.5 - register.php #2


if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	echo "Log in successful!\n";
	
	require ('../../mysqli_doctorweb.php'); // Connect to the db.
	
	$username = $_POST['ID'];
	$q = "SELECT * FROM doctor WHERE username = '$username'";
	$result = @mysqli_query($dbc, $q);
	$hospitalID = 0;
	
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{
		echo 'Welcome, doctor '.$row['real_name'].'<br>Below is your basic information.<br>';
		echo 'Register time: '.$row['register_time'].'<br>';
		$hospitalID = $row['hospitalID'];		
		echo '<br><br>';
	}//end loop
	
	$q = "SELECT * FROM hospitals WHERE hospitalID = '$hospitalID';";
	$result = @mysqli_query($dbc, $q);
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{
		echo 'From: '.$row['name'];		
		echo '<br><br>';
	}//end loop
	
	echo "<form action=\"doctor_update_page.php\" method=\"post\" />";
	echo "<input type=\"hidden\" name=\"username\" value=\"".$username."\" />";
	echo "<input type=\"submit\" name=\"submit\" value=\"Update My Information\" /><br><br>";
	echo "</form>";
	
	echo "<form action=\"diagnose_read.php\" method=\"post\" />";
	echo "<input type=\"hidden\" name=\"username\" value=\"".$username."\" />";
	echo "<input type=\"submit\" name=\"submit\" value=\"Check Patient's History\" />";
	echo "</form>";
	
	echo "<form action=\"diagnose_write_page.php\" method=\"post\" />";
	echo "<input type=\"hidden\" name=\"username\" value=\"".$username."\" />";
	echo "<input type=\"submit\" name=\"submit\" value=\"Write New Diagnose Record\" />";
	echo "</form>";
}//end if: Post method
	
?>