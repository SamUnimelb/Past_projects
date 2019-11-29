<?php
	require ('../db_connection.php'); // Connect to the db.
	$identity = $_POST['identity'];
	$blood_type = array ('O', 'A', 'B', 'AB', 'RH+', 'RH-');
	$hospitals = array();
	
	//User is a citizen:
	if($identity == 1)
	{
		echo "Citizen Register Page: ";
		echo "<form action=\"citizen_register.php\" method=\"post\">
		<p>Your citizen ID (*): <input type=\"text\" name=\"ID\" size=\"15\" maxlength=\"20\"/>
		<p>Your name (*): <input type=\"text\" name=\"name\" size=\"15\" maxlength=\"20\"/>
		<p>Your password (*): <input type=\"password\" name=\"password\" size=\"15\" maxlength=\"20\"/>
		<p>Confirm your password (*): <input type=\"password\" name=\"confirm_pass\" size=\"15\" maxlength=\"20\"/>
		<p>Your Age (*): <input type=\"text\" name=\"age\" size=\"15\" maxlength=\"20\"/>
		<p>Choose your sex: <input type=\"radio\" name=\"gender\" value=\"1\"/> Male
			<input type=\"radio\" name=\"gender\" value=\"2\"/> Female
			<input type=\"radio\" name=\"gender\" value=\"3\" checked/> Others
		<p>Choose your Blood Type (*): ";
		
		// Make the months pull-down menu:
		echo '<select name="blood_type">';
		foreach ($blood_type as $key => $value) 
			echo "<option value=\"$value\">$value</option>\n";		
		echo '</select><br>';
		
		echo "<p>Do you want to share your information? (*)<br>
		 <input type=\"radio\" name=\"agree_share\" value=\"1\"/> 
		 	I would like to share my medical data to doctors any time.<br>
		<input type=\"radio\" name=\"agree_share\" value=\"2\" checked/>
			I would like to share my data to doctors only in emergency cases.<br>
		<input type=\"radio\" name=\"agree_share\" value=\"3\"/>
			I would rather die for my privacy.<br>";
		

		echo "Note: <br>All the (*) column should be filled in.
		<br><input type=\"submit\" name=\"submit\" value=\"Register\"/>
		</form>";		
	}else if($identity == 2){
		//User is a doctor:
		echo "Doctor Registering Page: \n";
		$q = "SELECT name FROM hospitals";
		$result = @mysqli_query($dbc, $q);		
		while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
		{
			$hospitals[] = $row['name'];
		}		
		
		echo "<form action=\"doctor_register.php\" method=\"post\">
		<p>Your username (*): <input type=\"text\" name=\"username\" size=\"15\" maxlength=\"20\"/>
		<p>Your citizen ID(*): <input type=\"text\" name=\"ID\" size=\"15\" maxlength=\"20\"/>
		<p>Your password (*): <input type=\"password\" name=\"password\" size=\"15\" maxlength=\"20\"/>
		<p>Confirm your password (*): <input type=\"password\" name=\"c_pass\" size=\"15\" maxlength=\"20\"/>
		<p>Your name (*): <input type=\"text\" name=\"name\" size=\"15\" maxlength=\"20\"/>";
		
		echo '<br>Select the hospital you are working at: <select name="hospital">';
		foreach ($hospitals as $key => $value) 
			echo "<option value=\"$value\">$value</option>\n";		
		echo '</select><br>';	
		echo "<input type=\"submit\" name=\"submit\" value=\"Register\"/>";
		echo "</form>";
			
	}else if(isset($_COOKIE['wrong_citizen_id'])){
		echo "<form action=\"citizen_register.php\" method=\"post\">
		<p>Your citizen ID (*): <input type=\"text\" name=\"ID\" size=\"15\" maxlength=\"20\"
			value = \"".$_COOKIE['wrong_citizen_id']."\"/>";
		echo "<p>Your name (*): <input type=\"text\" name=\"name\" size=\"15\" maxlength=\"20\" 
			value = \"".$_COOKIE['wrong_name']."\" />";
		echo "<p>Your password (*): <input type=\"password\" name=\"password\" size=\"15\" maxlength=\"20\"
			value = \"".$_COOKIE['wrong_password']."\" />
		<p>Confirm your password (*): <input type=\"password\" name=\"confirm_pass\" size=\"15\" maxlength=\"20\"
			value = \"".$_COOKIE['wrong_confrim_password']."\" />
		<p>Your Age (*): <input type=\"text\" name=\"age\" size=\"15\" maxlength=\"20\"
			value = \"".$_COOKIE['wrong_age']."\" />
		<p>Choose your gender: <input type=\"radio\" name=\"gender\" value=\"1\"/> Male
			<input type=\"radio\" name=\"gender\" value=\"2\"/> Email
			<input type=\"radio\" name=\"gender\" value=\"3\" checked/> Unknown
		<p>Choose your Blood Type (*): ";
		
		// Make the months pull-down menu:
		echo '<select name="blood_type">';
		foreach ($blood_type as $key => $value) 
			echo "<option value=\"$value\">$value</option>\n";		
		echo '</select><br>';
		
		echo "<p>Do you want to share your information? (*)<br>
		 <input type=\"radio\" name=\"agree_share\" value=\"1\"/> 
		 	I would like to share my medical data to doctors any time.<br>
		<input type=\"radio\" name=\"agree_share\" value=\"2\" checked/>
			I would like to share my data to doctors only in emergency cases.<br>
		<input type=\"radio\" name=\"agree_share\" value=\"3\"/>
			I would rather die for my privacy.<br>";

		echo "<input type=\"submit\" name=\"submit\" value=\"Register\"/>
		</form>";
	}//end if-else if
?>

