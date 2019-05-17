<?php

	$id = 1;
	$curl = curl_init();
	curl_setopt_array($curl, array(
		CURLOPT_URL => "deals-service-spring.herokuapp.com/deals/".$id,
		CURLOPT_RETURNTRANSFER => true,
		CURLOPT_TIMEOUT => 30,
  		CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  		CURLOPT_CUSTOMREQUEST => "GET",
  		CURLOPT_HTTPHEADER => array(
    		"cache-control: no-cache"
  		),
	));

	$response = curl_exec($curl);
	$err = curl_error($curl);

	curl_close($curl);

	$allDeals = json_decode($response, true); 	
?>

<!DOCTYPE html>
<html>
<head>
	<title>Get All Deals of A Restaurant</title>

	<style type="text/css">
		.head {
			padding-left: 5px;
			display: inline-flex;
			list-style: none;
		}
	</style>
</head>
<body>

<header>
	<ul>
		<li class="head"><h1>Deals of A Restaurant</h1></li>
		<li class="head"><?php echo '<a href="get_all_active_deals.php?id='.$id.'">Active</a>' ?></li>
		<li class="head"><?php echo '<a href="get_all_expired_deals.php?id='.$id.'">Expired</a>' ?></li>
		<li class="head"><?php echo '<a href="form_add_deals.php?id='.$id.'">Add Deals</a>' ?></li>
	</ul>	
</header>

<table>
	<thead>
		<th>ID</th>
		<th>Kode Voucher</th>
		<th>Name</th>
		<th>Description</th>
		<th>Besar Diskon</th>
		<th>Maksimum Diskon</th>
		<th>Belanja Minimal</th>
		<th>Total Banyak Voucher</th>
		<th>Voucher per user</th>
		<th>Untuk customer baru</th>
		<th>Status</th>
		<th>Mulai</th>
		<th>Hingga</th>
	</thead>

	<tbody>
		<?php
			for ($i=0; $i < sizeof($allDeals); $i++) {
		?>
		<tr>
			<td><?php echo $allDeals[$i]['id'] ?></td>
			<td><?php echo $allDeals[$i]['code'] ?></td>
			<td><?php echo $allDeals[$i]['name'] ?></td>
			<td><?php echo $allDeals[$i]['description'] ?></td>
			<td><?php echo $allDeals[$i]['amount'] ?></td>
			<td><?php echo $allDeals[$i]['max_val'] ?></td>
			<td><?php echo $allDeals[$i]['min_val'] ?></td>
			<td><?php echo $allDeals[$i]['total_limit_use'] ?></td>
			<td><?php echo $allDeals[$i]['limit_use_per_user'] ?></td>
			<td><?php 
				if($allDeals[$i]['new_cust_only'] === TRUE)
			        echo "Yes";
			    else
			        echo "No";
				?></td>
			<td><?php echo $allDeals[$i]['active_status'] ?></td>
			<td><?php echo $allDeals[$i]['start'] ?></td>
			<td><?php echo $allDeals[$i]['end_time'] ?></td>
		</tr>

		<?php 			
			}
		?>
	</tbody>
</table>

</body>
</html>