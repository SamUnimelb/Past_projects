<?php
	$doctor_user = $_POST['username'];
	echo "<h1>Record Patient Case</h1>
	<form action=\"diagnose_write.php\" method=\"post\">
		<p>Patient's citizen ID (*): <input type=\"text\" name=\"citizenID\" size=\"15\" maxlength=\"20\"</p><br />	
		<p>Patient's illness (*): <input type=\"text\" name=\"illness\" size=\"20\" maxlength=\"60\"/> </p>
		<p>Brief Discription of this illness and patient's situation: (*) 
			<textarea name=\"discription\" rows=\"6\" cols=\"80\"></textarea>
		<p><input type=\"submit\" name=\"submit\" value=\"Submit New Record\" /></p>
		<input type=\"hidden\" name=\"doctor_user\" value=\"".$doctor_user."\" />
		<p>Note: The (*) columns must be filled up. </p>
	</form>"

?>
