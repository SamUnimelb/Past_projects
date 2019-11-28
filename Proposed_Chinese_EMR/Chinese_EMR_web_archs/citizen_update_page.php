<?php
	$citizenID = $_POST['citizenID'];
	$blood_type = array ('', 'O', 'A', 'B', 'AB', 'RH+', 'RH-');
	echo "<form action=\"citizen_update.php\" method=\"post\">";
	echo "<input type=\"hidden\" name=\"citizenID\" value=\"".$citizenID."\"/>";
	echo "Update following information if it is changed: \n";
	echo "<br>Your New Name: <input type=\"text\" name=\"name\" size=\"15\" maxlength=\"20\"/><br>";
	echo "<br>Your New Password: <input type=\"password\" name=\"password\" size=\"15\" maxlength=\"20\"/><br>";
	echo "<br>Confirm Your New Password: <input type=\"password\" name=\"c_password\" size=\"15\" maxlength=\"20\"/><br>";
	echo "<br>Your New Age: <input type=\"text\" name=\"age\" size=\"15\" maxlength=\"20\"/><br>";
	echo "<br>Your Correct Gender: ";
	echo "<input type=\"radio\" name=\"gender\" value=\"1\"/> Male
		  <input type=\"radio\" name=\"gender\" value=\"2\"/> Email
		  <input type=\"radio\" name=\"gender\" value=\"3\" checked/> Unknown";
	echo "<p>Your correct Blood Type: ";

	echo '<select name="blood_type">';
	foreach ($blood_type as $key => $value) 
		echo "<option value=\"$value\">$value</option>\n";		
	echo '</select><br>';
		
	echo "<p>Do Your information share policy? (*)<br>
	 <input type=\"radio\" name=\"agree_share\" value=\"1\"/> 
	 	I would like to share my medical data to doctors any time.<br>
	<input type=\"radio\" name=\"agree_share\" value=\"2\" checked/>
		I would like to share my data to doctors only in emergency cases.<br>
	<input type=\"radio\" name=\"agree_share\" value=\"3\"/>
		I would rather die for my privacy.<br>";
		
	echo "<input type=\"submit\" name=\"submit\" value=\"UPDATE\"/>";
	echo "</form>";
?>