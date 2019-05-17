<?php 
	$id = $_GET['id'];
?>

<!DOCTYPE html>
<html>
<head>
	<title>Form Add Deals</title>
	<style type="text/css">
		.deals-form {
			margin-left: 35%;
		}
		.submit {
			margin-top: 5%;
			margin-left: 38%;
		}
	</style>
</head>
<body>
	<div class="deals-form">
		<h1>Add Deals Form</h1>

		<form action="" method="POST">
			<table>
				<tr>
					<td>Kode voucher</td>
					<td><input type="text" name="code"></td>
				</tr>

				<tr>
					<td>Nama voucher</td>
					<td><input type="text" name="name"></td>
				</tr>

				<tr>
					<td>Deskripsi</td>
					<td><input type="text" name="description"></td>
				</tr>

				<tr>
					<td>Tipe voucher</td>
					<td><input type="text" name="type"></td>
				</tr>

				<tr>
					<td>Besar diskon</td>
					<td><input type="text" name="amount"></td>
				</tr>

				<tr>
					<td>Max diskon</td>
					<td><input type="text" name="max_val"></td>
				</tr>

				<tr>
					<td>Min belanja</td>
					<td><input type="text" name="min_val"></td>
				</tr>

				<tr>
					<td>Banyak voucher</td>
					<td><input type="text" name="total_limit_use"></td>
				</tr>

				<tr>
					<td>Batas penggunaan tiap customer</td>
					<td><input type="text" name="limit_use_per_user"></td>
				</tr>

				<tr>
					<td>Hanya customer baru</td>
					<td><input type="text" name="new_cust_only"></td>
				</tr>

				<tr>
					<td>Status voucher</td>
					<td><input type="text" name="active_status"></td>
				</tr>

				<tr>
					<td>Berlaku sejak</td>
					<td><input type="text" name="start"></td>
				</tr>

				<tr>
					<td>Berakhir pada</td>
					<td><input type="text" name="end"></td>
				</tr>
			</table>

			<input class="submit" type="submit" name="submit" value="Submit">
		</form>
	</div>
	
</body>
</html>