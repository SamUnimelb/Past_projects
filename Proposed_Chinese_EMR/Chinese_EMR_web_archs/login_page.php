<?php
	$identity = $_POST['identity'];
	echo $identity;
	echo "<form action=\"login.php\" method=\"post\" />";
	echo "<input type=\"hidden\" name=\"identity\" value=\"".$identity."\" />";
	if($identity == 1)
		echo "Your Username: <input type=\"text\" name=\"logv\" size=\"15\" maxlength=\"20\" /><br>";
	else if($identity == 2)
		echo "Your citizen ID: <input type=\"text\" name=\"logv\" size=\"15\" maxlength=\"20\" /><br>";
	echo "Your password: <input type=\"password\" name=\"password\"  size=\"15\" maxlength=\"20\" /><br>";
	echo "<input type=\"submit\" name=\"submit\" value=\"Go\" />";
	echo "</form>";
?>
