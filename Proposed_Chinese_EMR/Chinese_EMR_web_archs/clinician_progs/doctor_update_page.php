<?php
	require('../db_connection.php'); // Connect to the db.
	
	$username = $_POST['username'];		
	echo "<form action=\"doctor_update.php\" method=\"post\">";
	echo "Update your password if you want to:<br>
		<input type=\"password\" name=\"password\" size=\"15\" maxlength=\"20\"/><br>
		<br>Confirm Your New Password: <input type=\"password\" name=\"c_password\" size=\"15\" maxlength=\"20\"/><br>";
	echo "Update your name if it is changed: <input type=\"text\" name=\"name\" size=\"15\" maxlength=\"20\"/><br>";
	echo "<input type=\"hidden\" name=\"username\" value=\"".$username."\" />";
	
	$hospitals = array('');
	$q = "SELECT name FROM hospitals";
	$result = @mysqli_query($dbc, $q);
		
	while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
		$hospitals[] = $row['name'];
		
	echo 'Update your hospital information if it changed: <select name="hospital">';
	foreach ($hospitals as $key => $value) 
		echo "<option value=\"$value\">$value</option>\n";		
	echo '</select><br>';
	
	echo "<input type=\"submit\" name=\"submit\" value=\"UPDATE\"/>";
	echo "</form>";

	include ('../includes/footer.html');
?>